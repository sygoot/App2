package com.Hulajnogi.App.repository;

import com.Hulajnogi.App.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

//    // Znajdź wypożyczenie po ID pojazdu
//    List<Rental> findById(Long idVehicle);
//
//    // Znajdź aktywne wypożyczenia użytkownika
//    List<Rental> findByIdAndIsActive(Long idUser, boolean isActive);
//
//    // Znajdź pojedyncze wypożyczenie na podstawie ID pojazdu i aktywności
//    Optional<Rental> findByIdAndIsActive(Long idVehicle, boolean isActive);


}