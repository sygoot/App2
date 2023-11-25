package controller;

import com.Hulajnogi.App.model.Vehicle;
import com.Hulajnogi.App.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/vehicle")
public class VehicleController {


    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }


//    @Autowired
//    private VehicleService vehicleService;
//
//    @GetMapping
//    public List<Vehicle> getAllVehicles() {
//        return vehicleService.getAllVehicles();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
//        Vehicle vehicle = vehicleService.getVehicleById(id);
//        if (vehicle != null) {
//            return ResponseEntity.ok(vehicle);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping
//    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
//        return vehicleService.saveOrUpdateVehicle(vehicle);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
//        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicleDetails);
//        if (updatedVehicle != null) {
//            return ResponseEntity.ok(updatedVehicle);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
//        if (vehicleService.deleteVehicle(id)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
