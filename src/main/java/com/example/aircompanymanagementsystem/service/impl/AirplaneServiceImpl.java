package com.example.aircompanymanagementsystem.service.impl;

import com.example.aircompanymanagementsystem.service.AirplaneService;
import com.example.aircompanymanagementsystem.dao.AirCompanyDao;
import com.example.aircompanymanagementsystem.dao.AirplaneDao;
import com.example.aircompanymanagementsystem.model.AirCompany;
import com.example.aircompanymanagementsystem.model.Airplane;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneDao airplaneDao;
    private final AirCompanyDao airCompanyDao;

    public AirplaneServiceImpl(AirplaneDao airplaneDao,
                               AirCompanyDao airCompanyDao) {
        this.airplaneDao = airplaneDao;
        this.airCompanyDao = airCompanyDao;
    }

    @Override
    public Airplane update(Long id, Long airCompanyId) {
        Airplane airplane = get(id);
        AirCompany airCompany =  airCompanyDao.getById(id);
        airplane.setAirCompany(airCompany);
        return add(airplane);
    }

    @Override
    public Airplane add(Airplane airplane) {
        return airplaneDao.save(airplane);
    }

    @Override
    public Airplane get(Long id) {
        return airplaneDao.getById(id);
    }

    @Override
    public List<Airplane> getAll() {
        return airplaneDao.findAll();
    }

    @Override
    public void delete(Long id) {
        airplaneDao.deleteById(id);
    }
}
