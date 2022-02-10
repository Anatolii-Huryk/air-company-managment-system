package com.example.aircompanymanagementsystem.service;

import com.example.aircompanymanagementsystem.model.AirCompany;

public interface AirCompanyService extends CustomService<AirCompany> {
    AirCompany update(Long id, AirCompany airCompany);
}
