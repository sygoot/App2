package com.Hulajnogi.App.DTO;

import com.Hulajnogi.App.enums.VehicleStatus;
import com.Hulajnogi.App.enums.scooterType;
import com.Hulajnogi.App.model.VehicleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleAddDto {


    private String brand;

    private String model;

    @Enumerated(EnumType.STRING)
    private scooterType vehicleType;

    private int capacity;

    private double price;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    private int range;

}
