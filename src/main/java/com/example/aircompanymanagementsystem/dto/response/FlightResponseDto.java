package com.example.aircompanymanagementsystem.dto.response;

import com.example.aircompanymanagementsystem.model.Flight;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightResponseDto {
    private Long id;
    private Flight.FlightStatus flightStatus;
    private Long airCompanyId;
    private List<Long> airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private Long distance;
    private LocalDateTime estimatedFlightTime;
    private LocalDateTime startedFlight;
    private LocalDateTime endedFlight;
    private LocalDateTime delayStarted;
    private LocalDateTime created;
}
