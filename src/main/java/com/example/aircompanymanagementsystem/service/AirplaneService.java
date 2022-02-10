package com.example.aircompanymanagementsystem.service;

import com.example.aircompanymanagementsystem.model.Airplane;

public interface AirplaneService extends CustomService<Airplane> {
    Airplane update(Long id, Long airCompanyId);
}
