package com.example.aircompanymanagementsystem.controller;

import com.example.aircompanymanagementsystem.service.mapper.FlightMapper;
import com.example.aircompanymanagementsystem.dto.request.FlightRequestDto;
import com.example.aircompanymanagementsystem.dto.response.FlightResponseDto;
import com.example.aircompanymanagementsystem.service.FlightService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;
    private final FlightMapper flightMapper;

    public FlightController(FlightService flightService,
                            FlightMapper flightMapper) {
        this.flightService = flightService;
        this.flightMapper = flightMapper;
    }

    @PostMapping
    public FlightResponseDto add(@RequestBody FlightRequestDto flightRequestDto) {
        return flightMapper.toDto(flightService.add(flightMapper
                .toModel(flightRequestDto)));
    }

    @GetMapping("/{id}")
    public FlightResponseDto get(@PathVariable Long id) {
        return flightMapper.toDto(flightService.get(id));
    }

    @PutMapping
    public FlightResponseDto update(@RequestParam("id") Long id,
                                                @RequestParam("status") String status) {
        return flightMapper.toDto(flightService.update(id, status));
    }

    @GetMapping("/findAllByAirCompanyNameAndFlightStatus")
    public List<FlightResponseDto> findAllByAirCompanyNameAndFlightStatus(
            @RequestParam("airCompanyName") String airCompanyName,
            @RequestParam("flightStatus") String flightStatus) {
        return flightService.findAllByAirCompanyNameAndFlightStatus(airCompanyName,
                        flightStatus).stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/active24")
    public List<FlightResponseDto> findAllByFlightStatus_ActiveAndStartedAtBefore24Hours() {
        return flightService.findAllByFlightStatusAndStartedAtBefore().stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/differences")
    public List<FlightResponseDto> findAllByFlightStatusEqualsAndEstimatedFlightTimeLessThan(
            @RequestParam("status") String status) {
        return flightService.findAllByDifferences(status).stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }
}
