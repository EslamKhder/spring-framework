package springdemo.finalprojectrestoran.model.ClientModels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import springdemo.finalprojectrestoran.model.ContactInfo;
import springdemo.finalprojectrestoran.model.Orders;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Client extends ClientBaseEntity {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    List<Orders> requestOrders;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_roles",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    List<ContactInfo> contactInfo;
}
