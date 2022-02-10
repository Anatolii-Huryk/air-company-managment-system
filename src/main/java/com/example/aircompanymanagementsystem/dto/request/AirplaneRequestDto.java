package com.example.aircompanymanagementsystem.dto.request;

import com.example.aircompanymanagementsystem.model.Airplane;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AirplaneRequestDto {
    private String name;
    private String factorySerialNumber;
    private Long airCompanyId;
    private Long numberOfFlights;
    private Long flightDistance;
    private Long fuelCapacity;
    private Airplane.AirplaneType type;
    private LocalDate created;
}
