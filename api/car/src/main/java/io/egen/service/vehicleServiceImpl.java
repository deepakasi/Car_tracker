package io.egen.service;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.exception.BadRequestException;
import io.egen.repository.vehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by deepakasinathan on 6/30/17.
 */

@Service
public class vehicleServiceImpl implements vehicleService {

    @Autowired
    vehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }


    @Transactional
    public Reading create(Reading emp) {
        Reading existing = repository.findReadVin(emp.getVin());
        if (existing != null) {
            throw new BadRequestException("Vehicle with vin " + emp.getVin() + " already exists.");
        }
        return repository.create(emp);
    }

    @Transactional
    public List<Vehicle> update(List<Vehicle> vehicle) {
        for (Vehicle vh : vehicle) {
            Vehicle existing = repository.findVehVin(vh.getVin());
            if (existing == null) {
               repository.create(vh);
            } else
               repository.update(vh);
        }
        if (vehicle == null) {
            throw new BadRequestException("Vehicles dont exist ");
        }
        return vehicle;
    }
}
