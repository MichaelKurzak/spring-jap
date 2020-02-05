package pl.connectis.springjap.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.connectis.springjap.domaine.Movie;
import pl.connectis.springjap.domaine.MovieCategory;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

    Page<Movie> findByCategory(MovieCategory category, Pageable pageable);

    Page<Movie> findByTitleContaining(String partOfTitle, Pageable pageable);

}
