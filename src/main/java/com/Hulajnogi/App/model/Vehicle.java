package com.Hulajnogi.App.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // np. "Electric Scooter", "Electric Bike"
    private String status; // np. "Available", "In Use", "Under Maintenance"
    private String location; // Może być reprezentowane w zależności od wymagań

    public Vehicle() {
    }

    public Vehicle(Long id, String type, String status, String location) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.location = location;
    }

    public Vehicle(String type, String status, String location) {
        this.type = type;
        this.status = status;
        this.location = location;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}