package pl.connectis.springjap.repository;

import org.springframework.data.repository.CrudRepository;
import pl.connectis.springjap.domaine.Movie;
import pl.connectis.springjap.domaine.Poster;

import java.util.Optional;

public interface PosterRepository extends CrudRepository<Poster, Long> {

    Optional<Poster> findByMovie(Movie movie);
}
