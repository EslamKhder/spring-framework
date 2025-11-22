package springdemo.finalprojectrestoran.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import springdemo.finalprojectrestoran.model.ClientModels.Client;

@Entity
@Getter
@Setter
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String subject;
    @Column(length = 1000)
    private String message;

    @ManyToOne()
    @JoinColumn(name ="Client_id")
    private Client client;

}
