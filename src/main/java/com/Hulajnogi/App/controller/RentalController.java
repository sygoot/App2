package com.Hulajnogi.App.controller;


import com.Hulajnogi.App.model.Rental;
import com.Hulajnogi.App.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody Rental rental) {
        return ResponseEntity.ok(rentalService.saveRental(rental));
    }

    @PostMapping("/rent")
    public ResponseEntity<String> rentVehicle(@RequestParam Long idVehicle, @RequestParam Long idUser) {
        try {
            rentalService.rentVehicle(idVehicle, idUser);
            return ResponseEntity.ok("Pojazd został wypożyczony.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wypożyczenie nie powiodło się: " + e.getMessage());
        }
    }

    // Dodaj tutaj inne endpointy, np. do zakończenia wypożyczenia
}
