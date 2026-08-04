package start.group.demo910.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "player_number")
    private Integer number;
    private Double salary;


    public Player(String name, Integer number, Double salary) {
        this.name = name;
        this.number = number;
        this.salary = salary;
    }


}
