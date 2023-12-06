package com.Hulajnogi.App.model;

import com.Hulajnogi.App.enums.DepartmentName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartment;

    @Enumerated(EnumType.STRING)
    private DepartmentName name; // Zakładając, że DepartmentName to enum

    private String manager;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    // Konstruktory, gettery, settery itd.
}
