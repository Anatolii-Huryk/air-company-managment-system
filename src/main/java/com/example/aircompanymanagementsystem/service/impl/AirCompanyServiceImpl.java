package com.example.aircompanymanagementsystem.service.impl;

import com.example.aircompanymanagementsystem.service.AirCompanyService;
import com.example.aircompanymanagementsystem.dao.AirCompanyDao;
import com.example.aircompanymanagementsystem.model.AirCompany;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {
    private final AirCompanyDao airCompanyDao;

    public AirCompanyServiceImpl(AirCompanyDao airCompanyDao) {
        this.airCompanyDao = airCompanyDao;
    }

    @Override
    public AirCompany update(Long id, AirCompany airCompany) {
        airCompany.setId(id);
        return add(airCompany);
    }

    @Override
    public AirCompany add(AirCompany airCompany) {
        return airCompanyDao.save(airCompany);
    }

    @Override
    public AirCompany get(Long id) {
        return airCompanyDao.getById(id);
    }

    @Override
    public List<AirCompany> getAll() {
        return airCompanyDao.findAll();
    }

    @Override
    public void delete(Long id) {
        airCompanyDao.deleteById(id);
    }
}
