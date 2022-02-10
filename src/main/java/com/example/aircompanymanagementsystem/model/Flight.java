package com.example.aircompanymanagementsystem.model;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "flight_status")
    private FlightStatus flightStatus;
    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;
    @ManyToMany
    @JoinTable(name = "airplane_flight",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "airplane_id"))
    private List<Airplane> airplane;
    private String departureCountry;
    private String destinationCountry;
    private Long distance;
    private LocalDateTime estimatedFlightTime;
    private LocalDateTime startedFlight;
    private LocalDateTime endedFlight;
    private LocalDateTime delayStarted;
    private LocalDateTime created;

    public enum FlightStatus {
        ACTIVE, COMPLETED, DELAYED, PENDING
    }
}
