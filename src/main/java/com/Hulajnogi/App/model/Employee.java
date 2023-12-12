package com.Hulajnogi.App.model;

import com.Hulajnogi.App.enums.EmployeeType;
import com.Hulajnogi.App.enums.Position;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Enumerated(EnumType.STRING)
    private Position position; // Zakładając, że Position to enum

    private String userDetails;

    @Enumerated (EnumType.STRING)
    private EmployeeType employeeType;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    // Konstruktory, gettery, settery itd.
}

