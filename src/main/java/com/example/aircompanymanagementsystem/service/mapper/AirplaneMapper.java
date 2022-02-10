package com.example.aircompanymanagementsystem.service.mapper;

import com.example.aircompanymanagementsystem.dto.request.AirplaneRequestDto;
import com.example.aircompanymanagementsystem.dto.response.AirplaneResponseDto;
import com.example.aircompanymanagementsystem.model.Airplane;
import org.springframework.stereotype.Component;

@Component
public class AirplaneMapper {
    public Airplane toModel(AirplaneRequestDto airplaneRequestDto) {
        Airplane airplane = new Airplane();
        airplane.setName(airplaneRequestDto.getName());
        airplane.setCreated(airplaneRequestDto.getCreated());
        airplane.setAirCompany(airplane.getAirCompany());
        airplane.setFlightDistance(airplaneRequestDto.getFlightDistance());
        airplane.setFuelCapacity(airplaneRequestDto.getFuelCapacity());
        airplane.setFactorySerialNumber(airplaneRequestDto.getFactorySerialNumber());
        airplane.setType(airplaneRequestDto.getType());
        airplane.setNumberOfFlights(airplaneRequestDto.getNumberOfFlights());
        return airplane;
    }

    public AirplaneResponseDto toDto(Airplane airplane) {
        AirplaneResponseDto airplaneResponseDto = new AirplaneResponseDto();
        airplaneResponseDto.setAirCompanyId(airplaneResponseDto.getId());
        airplaneResponseDto.setName(airplane.getName());
        airplaneResponseDto.setCreated(airplane.getCreated());
        airplaneResponseDto.setFuelCapacity(airplane.getFuelCapacity());
        airplaneResponseDto.setType(airplane.getType());
        airplaneResponseDto.setFlightDistance(airplane.getFlightDistance());
        airplaneResponseDto.setNumberOfFlights(airplane.getNumberOfFlights());
        airplaneResponseDto.setAirCompanyId(airplane.getAirCompany().getId());
        airplaneResponseDto.setFactorySerialNumber(airplane.getFactorySerialNumber());
        return airplaneResponseDto;
    }
}
