package com.Hulajnogi.App.repository;

import com.Hulajnogi.App.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Dodatkowe metody związane z wyszukiwaniem działów, jeśli potrzebne
}
