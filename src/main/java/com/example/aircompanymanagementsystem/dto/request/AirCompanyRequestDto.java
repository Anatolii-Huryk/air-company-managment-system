package com.example.aircompanymanagementsystem.dto.request;

import lombok.Data;
import com.example.aircompanymanagementsystem.model.AirCompany;
import java.time.LocalDate;

@Data
public class AirCompanyRequestDto {
    private String name;
    private AirCompany.CompanyType companyType;
    private LocalDate founded;
}
