package pl.connectis.springjap.domaine;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Movie extends BaseEntity {

    private String title;
    @Enumerated(EnumType.STRING)
    private MovieCategory category;
    private Integer length;
    private String description;
    private Integer requiredAge;


    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Marathon> marathons = new ArrayList<>();


    public Movie(Object o, String title, MovieCategory category, Integer length, String description, Integer requiredAge) {
        super();
    }

    public Long gatId() {
    }
}
