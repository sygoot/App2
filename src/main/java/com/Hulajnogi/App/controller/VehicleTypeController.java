package com.Hulajnogi.App.controller;

import com.Hulajnogi.App.model.VehicleType;
import com.Hulajnogi.App.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicleTypes")
public class VehicleTypeController {

    private final VehicleTypeService vehicleTypeService;

    @Autowired
    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleType>> getAllVehicleTypes() {
        List<VehicleType> vehicleTypes = vehicleTypeService.findAllVehicleTypes();
        return ResponseEntity.ok(vehicleTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleType> getVehicleTypeById(@PathVariable Long id) {
        VehicleType vehicleType = vehicleTypeService.findVehicleTypeById(id);
        return vehicleType != null ? ResponseEntity.ok(vehicleType) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<VehicleType> createVehicleType(@RequestBody VehicleType vehicleType) {
        VehicleType savedVehicleType = vehicleTypeService.saveVehicleType(vehicleType);
        return ResponseEntity.ok(savedVehicleType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleType> updateVehicleType(@PathVariable Long id, @RequestBody VehicleType vehicleTypeDetails) {
        VehicleType updatedVehicleType = vehicleTypeService.findVehicleTypeById(id);
        if (updatedVehicleType != null) {
            updatedVehicleType.setBrand(vehicleTypeDetails.getBrand());
            updatedVehicleType.setModel(vehicleTypeDetails.getModel());
            updatedVehicleType.setVehicleType(vehicleTypeDetails.getVehicleType());
            updatedVehicleType.setCapacity(vehicleTypeDetails.getCapacity());
            updatedVehicleType.setPrice(vehicleTypeDetails.getPrice());
            vehicleTypeService.saveVehicleType(updatedVehicleType);
            return ResponseEntity.ok(updatedVehicleType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleType(@PathVariable Long id) {
        vehicleTypeService.deleteVehicleType(id);
        return ResponseEntity.ok().build();
    }
}
