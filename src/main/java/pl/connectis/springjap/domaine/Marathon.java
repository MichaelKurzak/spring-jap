package pl.connectis.springjap.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Marathon extends BaseEntity {
    private String name;
    private LocalDateTime startTime;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "marathon_movies",
            joinColumns = @JoinColumn(name = "marathon_id"),
            inverseJoinColums = @JoinColumn(name = "movie_id"))
    private List<Movie> movies = new ArrayList<>();


}
