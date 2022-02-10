package com.example.aircompanymanagementsystem.controller;

import com.example.aircompanymanagementsystem.dto.request.AirCompanyRequestDto;
import com.example.aircompanymanagementsystem.dto.response.AirCompanyResponseDto;
import com.example.aircompanymanagementsystem.service.AirCompanyService;
import com.example.aircompanymanagementsystem.service.mapper.AirCompanyMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/air-companies")
public class AirCompanyController {
    private final AirCompanyService airCompanyService;
    private final AirCompanyMapper airCompanyMapper;

    public AirCompanyController(AirCompanyService airCompanyService,
                                AirCompanyMapper airCompanyMapper) {
        this.airCompanyService = airCompanyService;
        this.airCompanyMapper = airCompanyMapper;
    }

    @PutMapping
    public AirCompanyResponseDto add(@RequestBody AirCompanyRequestDto airCompanyRequestDto) {
        return airCompanyMapper.toDto(airCompanyService.add
                (airCompanyMapper.toModel(airCompanyRequestDto)));
    }

    @GetMapping
    public List<AirCompanyResponseDto> getAll() {
        return airCompanyService.getAll().stream()
                .map(airCompanyMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AirCompanyResponseDto get(@PathVariable Long id) {
        return airCompanyMapper.toDto(airCompanyService.get(id));
    }

    @PutMapping("/{id}")
    public AirCompanyResponseDto update (@RequestBody AirCompanyRequestDto airCompanyRequestDto,
                                         @PathVariable Long id) {
        return airCompanyMapper.toDto(airCompanyService.update(id,
                airCompanyMapper.toModel(airCompanyRequestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        airCompanyService.delete(id);
    }
}
