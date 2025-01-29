package springdemo.finalprojectrestoran.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Chefs  extends  BaseEntity{

    private String specialty;
    private String facebookLink;
    private String twitterLink;
    private String instagramLink;
}
