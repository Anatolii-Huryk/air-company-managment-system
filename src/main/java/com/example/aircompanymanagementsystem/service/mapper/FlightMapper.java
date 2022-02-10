package com.example.aircompanymanagementsystem.service.mapper;

import com.example.aircompanymanagementsystem.dto.request.FlightRequestDto;
import com.example.aircompanymanagementsystem.dto.response.FlightResponseDto;
import com.example.aircompanymanagementsystem.model.Airplane;
import com.example.aircompanymanagementsystem.model.Flight;
import com.example.aircompanymanagementsystem.service.AirCompanyService;
import com.example.aircompanymanagementsystem.service.AirplaneService;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class FlightMapper {
    private final AirCompanyService airCompanyService;
    private final AirplaneService airplaneService;


    public FlightMapper(AirCompanyService airCompanyService,
                        AirplaneService airplaneService) {
        this.airCompanyService = airCompanyService;
        this.airplaneService = airplaneService;
    }

    public Flight toModel(FlightRequestDto flightRequestDto) {
        Flight flight = new Flight();
        flight.setAirplane(flightRequestDto.getAirplaneId().stream()
                .map(airplaneService::get)
                .collect(Collectors.toList()));
        flight.setDelayStarted(flightRequestDto.getDelayStarted());
        flight.setStartedFlight(flightRequestDto.getStartedFlight());
        flight.setEndedFlight(flightRequestDto.getEndedFlight());
        flight.setDistance(flightRequestDto.getDistance());
        flight.setAirCompany(airCompanyService.get(flightRequestDto.getAirCompanyId()));
        flight.setCreated(flightRequestDto.getCreated());
        flight.setEstimatedFlightTime(flightRequestDto.getEstimatedFlightTime());
        flight.setDestinationCountry(flightRequestDto.getDestinationCountry());
        flight.setDepartureCountry(flightRequestDto.getDepartureCountry());
        flight.setFlightStatus(flightRequestDto.getFlightStatus());
        return flight;
    }

    public FlightResponseDto toDto(Flight flight) {
        FlightResponseDto flightResponseDto = new FlightResponseDto();
        flightResponseDto.setId(flight.getId());
        flightResponseDto.setFlightStatus(flight.getFlightStatus());
        flightResponseDto.setAirCompanyId(flight.getAirCompany().getId());
        flightResponseDto.setAirplaneId(flight.getAirplane().stream()
                .map(Airplane::getId)
                .collect(Collectors.toList()));
        flightResponseDto.setDepartureCountry(flight.getDepartureCountry());
        flightResponseDto.setDestinationCountry(flight.getDestinationCountry());
        flightResponseDto.setDistance(flight.getDistance());
        flightResponseDto.setEstimatedFlightTime(flight.getEstimatedFlightTime());
        flightResponseDto.setStartedFlight(flight.getStartedFlight());
        flightResponseDto.setEndedFlight(flight.getEndedFlight());
        flightResponseDto.setDelayStarted(flight.getDelayStarted());
        flightResponseDto.setCreated(flight.getCreated());
        return flightResponseDto;
    }
}
