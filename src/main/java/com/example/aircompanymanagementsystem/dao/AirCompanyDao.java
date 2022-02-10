package com.example.aircompanymanagementsystem.dao;

import com.example.aircompanymanagementsystem.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyDao extends JpaRepository<AirCompany, Long> {
}
