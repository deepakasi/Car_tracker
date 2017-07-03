package io.egen.service;

import io.egen.entity.readings;
import io.egen.entity.vehicles;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
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
    public List<vehicles> findAll() {
        return repository.findAll();
    }


    @Transactional
    public readings create(readings emp) {
        readings existing = repository.findReadVin(emp.getVin());
        if (existing != null) {
            throw new BadRequestException("Vehicle with vin " + emp.getVin() + " already exists.");
        }
        return repository.create(emp);
    }

    @Transactional
    public List<vehicles> update(List<vehicles> vehicle) {
        for (vehicles vh : vehicle) {
            vehicles existing = repository.findVehVin(vh.getVin());
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
