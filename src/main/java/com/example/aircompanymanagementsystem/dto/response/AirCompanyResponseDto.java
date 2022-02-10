package com.example.aircompanymanagementsystem.dto.response;

import com.example.aircompanymanagementsystem.model.AirCompany;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AirCompanyResponseDto {
    private Long id;
    private String name;
    private AirCompany.CompanyType companyType;
    private LocalDate founded;
}
