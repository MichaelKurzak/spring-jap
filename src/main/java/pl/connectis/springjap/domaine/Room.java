package pl.connectis.springjap.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Room extends BaseEntity {

    String name;
    int capacity;
    String description;

}
