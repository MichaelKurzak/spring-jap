package pl.connectis.springjap.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity {

    private String seat;
    private BigDecimal price;

    @ManyToOne(optional = false)
    @Column
    private Session session;
}
