package com.example.aircompanymanagementsystem.controller;

import com.example.aircompanymanagementsystem.dto.request.AirplaneRequestDto;
import com.example.aircompanymanagementsystem.service.AirplaneService;
import com.example.aircompanymanagementsystem.service.mapper.AirplaneMapper;
import com.example.aircompanymanagementsystem.dto.response.AirplaneResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;
    private final AirplaneMapper airplaneMapper;

    public AirplaneController(AirplaneService airplaneService,
                              AirplaneMapper airplaneMapper) {
        this.airplaneService = airplaneService;
        this.airplaneMapper = airplaneMapper;
    }

    @PostMapping
    public AirplaneResponseDto add(@RequestBody AirplaneRequestDto airplaneRequestDto) {
        return airplaneMapper.toDto(airplaneService.add(airplaneMapper
                .toModel(airplaneRequestDto)));
    }
    @GetMapping
    public List<AirplaneResponseDto> getAll() {
        return airplaneService.getAll().stream()
                .map(airplaneMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AirplaneResponseDto get(@PathVariable Long id) {
        return airplaneMapper.toDto(airplaneService.get(id));
    }

    @PutMapping
    public AirplaneResponseDto update(@RequestParam Long airplaneId,
                                      @RequestParam Long companyId) {
        return airplaneMapper.toDto(airplaneService.update(airplaneId, companyId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        airplaneService.delete(id);
    }
}
