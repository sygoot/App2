package com.Hulajnogi.App.service;

import com.Hulajnogi.App.DTO.VehicleAddDto;
import com.Hulajnogi.App.model.Vehicle;
import com.Hulajnogi.App.model.VehicleType;
import com.Hulajnogi.App.repository.VehicleRepository;
import com.Hulajnogi.App.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleTypeRepository vehicleTypeRepository;


    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }


    public void addVehicle(VehicleAddDto vehicleAddDto){

        VehicleType vehicleType = new VehicleType();

        vehicleType.setVehicleType(vehicleAddDto.getVehicleType());
        vehicleType.setBrand(vehicleAddDto.getBrand());
        vehicleType.setPrice(vehicleAddDto.getPrice());
        vehicleType.setModel(vehicleAddDto.getModel());
        vehicleType.setCapacity(vehicleAddDto.getCapacity());

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleType);
        vehicle.setStatus(vehicleAddDto.getStatus());
        vehicle.setRange(vehicleAddDto.getRange());

        vehicleTypeRepository.save(vehicleType);
        vehicleRepository.save(vehicle);
    }



    public Vehicle findVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
