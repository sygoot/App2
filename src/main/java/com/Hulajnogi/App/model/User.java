package com.Hulajnogi.App.model;
import com.Hulajnogi.App.enums.UserRole;
import com.Hulajnogi.App.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity 
@Table(name = "app_users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String login;
    private String password;
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = true)
    private Customer customer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = true)
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public void addRole(UserRole role) {
        this.role = role;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        if (customer != null) {
            customer.setUser(this);
        }
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        if (employee != null) {
            employee.setUser(this);
        }
    }

    // Konstruktory, gettery, settery itd.
}
