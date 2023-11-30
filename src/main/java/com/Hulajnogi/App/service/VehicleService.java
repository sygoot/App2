package com.Hulajnogi.App.service;

import com.Hulajnogi.App.model.Vehicle;
import com.Hulajnogi.App.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public Vehicle saveOrUpdateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        return vehicleRepository.findById(id)
                .map(vehicle -> {
                    vehicle.setType(vehicleDetails.getType());
                    vehicle.setStatus(vehicleDetails.getStatus());
                    vehicle.setLocation(vehicleDetails.getLocation());
                    return vehicleRepository.save(vehicle);
                }).orElse(null);
    }

    public boolean deleteVehicle(Long id) {
        return vehicleRepository.findById(id)
                .map(vehicle -> {
                    vehicleRepository.delete(vehicle);
                    return true;
                }).orElse(false);
    }

    public List<Vehicle> findByStatus(String status) {
        return vehicleRepository.findByStatus(status);
    }
}



//package com.Hulajnogi.App.service;
//
//import com.Hulajnogi.App.model.Vehicle;
//import com.Hulajnogi.App.repository.VehicleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//
//
//@Service
//public class VehicleService {
//
//    public List<Vehicle> getVehicles() {
//        return List.of(
//                new Vehicle(
//                        525L,
//                        "Scooter",
//                        "Available",
//                        "XYZ"
//                )
//        );
//    }
////
////    @Autowired
////    private VehicleRepository vehicleRepository;
////
////    public List<Vehicle> getAllVehicles() {
////        return vehicleRepository.findAll();
////    }
////
////    public Vehicle getVehicleById(Long id) {
////        return vehicleRepository.findById(id).orElse(null);
////    }
////
////    public Vehicle saveOrUpdateVehicle(Vehicle vehicle) {
////        return vehicleRepository.save(vehicle);
////    }
////    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
////        return vehicleRepository.findById(id)
////                .map(vehicle -> {
////                    vehicle.setType(vehicleDetails.getType());
////                    vehicle.setStatus(vehicleDetails.getStatus());
////                    vehicle.setLocation(vehicleDetails.getLocation());
////                    // tutaj możesz dodać aktualizacje innych pól
////                    return vehicleRepository.save(vehicle);
////                }).orElse(null); // jeśli pojazd nie istnieje, zwróć null
////    }
////
////    public boolean deleteVehicle(Long id) {
////        return vehicleRepository.findById(id)
////                .map(vehicle -> {
////                    vehicleRepository.delete(vehicle);
////                    return true; // zwraca true, jeśli pojazd został usunięty
////                }).orElse(false); // zwraca false, jeśli pojazd nie istnieje
////    }
//
//
//    // Możesz dodać inne metody, np. do usuwania pojazdu
//}