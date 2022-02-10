package com.example.aircompanymanagementsystem.model;

import lombok.Data;
import java.time.LocalDate;
import javax.persistence.*;

@Data
@Entity
@Table(name = "airplanes")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String factorySerialNumber;
    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;
    private Long numberOfFlights;
    private Long flightDistance;
    private Long fuelCapacity;
    private AirplaneType type;
    private LocalDate created;

    public enum AirplaneType {
        POSTAL, TRANSPORT, PASSENGER, AGRICULTURE
    }
}
