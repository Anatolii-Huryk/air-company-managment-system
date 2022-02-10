package com.example.aircompanymanagementsystem.service.mapper;

import com.example.aircompanymanagementsystem.dto.request.AirCompanyRequestDto;
import com.example.aircompanymanagementsystem.dto.response.AirCompanyResponseDto;
import com.example.aircompanymanagementsystem.model.AirCompany;
import org.springframework.stereotype.Component;

@Component
public class AirCompanyMapper {
    public AirCompany toModel(AirCompanyRequestDto acr) {
        AirCompany airCompany = new AirCompany();
        airCompany.setName(acr.getName());
        airCompany.setCompanyType(acr.getCompanyType());
        airCompany.setFounded(acr.getFounded());
        return airCompany;
    }

    public AirCompanyResponseDto toDto(AirCompany ac) {
        AirCompanyResponseDto acr = new AirCompanyResponseDto();
        acr.setId(ac.getId());
        acr.setName(ac.getName());
        acr.setFounded(ac.getFounded());
        acr.setCompanyType(ac.getCompanyType());
        return acr;
    }
}
