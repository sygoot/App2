package com.Hulajnogi.App.repository;

import com.Hulajnogi.App.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // Tutaj można dodać niestandardowe metody wyszukiwania
}