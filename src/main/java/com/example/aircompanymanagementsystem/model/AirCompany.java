package com.example.aircompanymanagementsystem.model;

import lombok.Data;
import java.time.LocalDate;
import javax.persistence.*;

@Data
@Entity
@Table(name = "air_companies")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private CompanyType companyType;
    private LocalDate founded;

    public enum CompanyType {
        INTERNATIONAL_AIRLINES,
        NATIONAL_AIRLINES,
        REGIONAL_AIRLINES
    }
}
