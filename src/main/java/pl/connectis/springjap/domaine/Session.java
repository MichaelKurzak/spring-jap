package pl.connectis.springjap.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Session extends BaseEntity {


    private LocalDateTime startTime;

    @ManyToOne()
    private Movie movie;

    @ManyToOne
    private Room room;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticket = new ArrayList<>();

}
