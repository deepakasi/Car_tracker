package io.egen.service;

import io.egen.entity.readings;
import io.egen.entity.vehicles;

import java.util.List;

/**
 * Created by deepakasinathan on 6/30/17.
 */
public interface vehicleService {
    List<vehicles> findAll();

    readings create(readings emp);

     List<vehicles> update(List<vehicles> emp);

}

