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
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModel;

    @Enumerated(EnumType.STRING)
    private Brand brand; // Zakładając, że Brand to enum

    @Enumerated(EnumType.STRING)
    private Model model; // Zakładając, że Model to enum

    @Enumerated(EnumType.STRING)
    private com.Hulajnogi.App.enums.VehicleType vehicleType; // Zakładając, że Type to enum

    private int capacity;
    private double price;
}
