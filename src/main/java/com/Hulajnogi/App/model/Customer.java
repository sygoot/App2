package com.Hulajnogi.App.model;

import com.Hulajnogi.App.enums.CustomerType;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;

    @Enumerated(EnumType.STRING)
    private CustomerType type; // Zakładając, że CustomerType to enum

    private String drivingLicenseNumber;
    private Long cardNumber;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;

    @OneToMany(mappedBy = "customer")
    private Set<Payment> payments;

    // Konstruktory, gettery, settery itd.
}
