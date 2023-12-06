package com.Hulajnogi.App.repository;

import com.Hulajnogi.App.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Metody związane z wyszukiwaniem klientów, jeśli potrzebne
}
