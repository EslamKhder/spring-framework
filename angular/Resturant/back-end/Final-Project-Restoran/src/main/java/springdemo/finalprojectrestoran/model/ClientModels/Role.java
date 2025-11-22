package springdemo.finalprojectrestoran.model.ClientModels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Role extends ClientBaseEntity {


    private String code;

    @ManyToMany(mappedBy = "roles")
    private List<Client> client;
}
