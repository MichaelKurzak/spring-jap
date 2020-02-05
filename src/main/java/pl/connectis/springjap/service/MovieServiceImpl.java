package pl.connectis.springjap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.connectis.springjap.EntityDoesNotExistsException;
import pl.connectis.springjap.domaine.Movie;
import pl.connectis.springjap.domaine.MovieCategory;
import pl.connectis.springjap.domaine.Poster;
import pl.connectis.springjap.repository.MovieRepository;
import pl.connectis.springjap.repository.PosterRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private PosterRepository posterRepository;

    public MovieServiceImpl(MovieRepository movieRepository, PosterRepository posterRepository) {
        this.movieRepository = movieRepository;
        this.posterRepository = posterRepository;
    }

    @Override
    @Transactional
    public Long createMovie(String title, MovieCategory category, Integer length, String description, Integer requiredAge, String posterFilePath) {

        Movie movie = new Movie(null, title, category, length, description, requiredAge);

        movieRepository.save(movie);

        if (posterFilePath != null) {
            createPoster(movie, posterFilePath);
        }

        return movie.gatId();
    }

    private void createPoster(Movie movie, String posterFilePath) {
        Poster poster = new Poster(null, posterFilePath);
        poster.setMovie(movie);
        posterRepository.save(poster);
    }

    @Override
    public Optional<Movie> getMovie(Long movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public Page<Movie> getMoviesInCategory(MovieCategory category, Pageable pageable) {
        return movieRepository.findByCategory(category, pageable);
    }

    @Override
    public Page<Movie> getMoviesByPartOfTitle(String partOfTitle, Pageable pageable) {
        return movieRepository.findByTitleContaining(partOfTitle, pageable);
    }


    @Override
    public Page<Movie> getAllMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void updateMovie(Long movieId, String title, MovieCategory category, Integer length, String description, Integer requiredAge, String posterFilePath) throws EntityDoesNotExistsException {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if (!movieOptional.isPresent()) {
            throw new EntityDoesNotExistsException("Movie, id=" + movieId);
        }

        Movie movie = movieOptional.get();
        movie.setTitle(title);
        movie.setCategory(category);
        movie.setLength(length);
        movie.setDescription(description);
        movie.setRequiredAge(requiredAge);

        movieRepository.save(movie);

        Optional<Poster> posterOptional = posterRepository.findByMovie(movie);

        if (posterOptional.isPresent()) {
            Poster poster = posterOptional.get();
            if (posterFilePath != null) {
                poster.setFilePath(posterFilePath);
                posterRepository.save(poster);
            } else {
                posterRepository.delete(poster);
            }
        } else if (posterFilePath != null) {
            createPoster(movie, posterFilePath);
        }
    }

    @Override
    @Transactional
    public void removeMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }


}
