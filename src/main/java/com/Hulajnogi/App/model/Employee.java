package com.Hulajnogi.App.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String department; // np. "Customer Service", "Maintenance", "HR", "Management"

    private int salary;

    public Employee(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }
}
