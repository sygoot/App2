package com.Hulajnogi.App.model;

import com.Hulajnogi.App.enums.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status; // Zakładając, że VehicleStatus to enum

    private int range;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_model")
    private VehicleType vehicleType;
}
