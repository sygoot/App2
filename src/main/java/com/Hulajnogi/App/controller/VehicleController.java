package com.Hulajnogi.App.controller;

import com.Hulajnogi.App.DTO.VehicleAddDto;
import com.Hulajnogi.App.model.Vehicle;
import com.Hulajnogi.App.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.findAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/addScooter")
    public String addScooterForm(Model model, VehicleAddDto vehicleAddDto){
        model.addAttribute("vehicle", vehicleAddDto);
        return "addScooter";
    }

    @PostMapping("/addScooter")
    public String addScooterForm(VehicleAddDto vehicleAddDto){
        vehicleService.addVehicle(vehicleAddDto);
        return "addVehicleSuccess";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.findVehicleById(id);
        return vehicle != null ? ResponseEntity.ok(vehicle) : ResponseEntity.notFound().build();
    }

//    @PostMapping
//    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
//        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);
//        return ResponseEntity.ok(savedVehicle);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
        Vehicle updatedVehicle = vehicleService.findVehicleById(id);
        if (updatedVehicle != null) {
            updatedVehicle.setStatus(vehicleDetails.getStatus());
            updatedVehicle.setRange(vehicleDetails.getRange());
            updatedVehicle.setVehicleType(vehicleDetails.getVehicleType());
            vehicleService.saveVehicle(updatedVehicle);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok().build();
    }
}
