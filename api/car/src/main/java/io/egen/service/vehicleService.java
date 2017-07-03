package io.egen.service;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by deepakasinathan on 6/30/17.
 */
public interface vehicleService {
    List<Vehicle> findAll();

    Reading create(Reading emp);

     List<Vehicle> update(List<Vehicle> emp);

}

