package com.Hulajnogi.App.service;


import com.Hulajnogi.App.enums.VehicleStatus;
import com.Hulajnogi.App.model.Rental;
import com.Hulajnogi.App.model.User;
import com.Hulajnogi.App.model.Vehicle;
import com.Hulajnogi.App.repository.RentalRepository;
import com.Hulajnogi.App.repository.UserRepository;
import com.Hulajnogi.App.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository, UserRepository userRepository, VehicleRepository vehicleRepository) {
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public void rentVehicle(Long vehicleId, Long userId) throws Exception {
        // Pobierz pojazd z bazy danych
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new Exception("Nie znaleziono pojazdu o id: " + vehicleId));

        // Pobierz użytkownika z bazy danych
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("Nie znaleziono użytkownika o id: " + userId));

        // Sprawdź, czy pojazd jest dostępny do wypożyczenia
        if (vehicle.getStatus() != VehicleStatus.AVAILABLE) {
            throw new Exception("Pojazd nie jest dostępny do wypożyczenia.");
        }

        // Utwórz nowe wypożyczenie
        Rental rental = new Rental();
        rental.setVehicle(vehicle);
        rental.setUser(user);
        rental.setRentalStart(LocalDateTime.now());
        // Ustaw inne potrzebne pola wypożyczenia

        // Zapisz wypożyczenie w bazie danych
        rentalRepository.save(rental);

        // Zaktualizuj status pojazdu jako wypożyczony
        vehicle.setStatus(VehicleStatus.IN_USE);
        rental.setActive(true);
        vehicleRepository.save(vehicle);
    }


    public Rental endRental(Long rentalId) {
        // Znajdź wypożyczenie po ID
        Rental rental = rentalRepository.findById(rentalId).orElse(null);

        if (rental != null) {
            // Zaktualizuj status wypożyczenia
            rental.setActive(false);

            // Znajdź pojazd przypisany do tego wypożyczenia i zaktualizuj jego status
            Vehicle vehicle = rental.getVehicle();
            if (vehicle != null) {
                vehicle.setStatus(VehicleStatus.AVAILABLE);
                vehicleRepository.save(vehicle);
            }

            // Zapisz zmiany w wypożyczeniu
            return rentalRepository.save(rental);
        }

        return null;
    }


    // Dodaj tutaj inne metody, które będą potrzebne do obsługi logiki wypożyczeń
}

