package com.spring.boot.resturantbackend.models.security;

import com.spring.boot.resturantbackend.models.ContactInfo;
import com.spring.boot.resturantbackend.models.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "hr")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @OneToOne(mappedBy = "account")
    private AccountDetails accountDetails;
    @Getter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "hr",
            name = "Account_Role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"account_id", "role_id"})
    )
    private List<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "account")
    private List<ContactInfo> contacts;
    @OneToMany(mappedBy = "account")
    private List<Order> orders;
    private String enabled;
}
