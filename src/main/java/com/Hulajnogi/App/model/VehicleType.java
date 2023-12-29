package com.Hulajnogi.App.model;

import com.Hulajnogi.App.enums.scooterType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModel;

    private String brand; // Zakładając, że Brand to enum

    private String model; // Zakładając, że Model to enum

    @Enumerated(EnumType.STRING)
    private scooterType vehicleType; // Zakładając, że Type to enum

    private int capacity;
    private double price;
}
