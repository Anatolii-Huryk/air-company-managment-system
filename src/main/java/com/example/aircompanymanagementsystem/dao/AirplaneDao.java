package com.example.aircompanymanagementsystem.dao;

import com.example.aircompanymanagementsystem.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneDao extends JpaRepository<Airplane, Long> {
}
