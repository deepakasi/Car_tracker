package io.egen.repository;




import io.egen.entity.readings;
import io.egen.entity.vehicles;

import java.util.List;

/**
 * Created by deepakasinathan on 6/30/17.
 */
public interface vehicleRepository {
    List<vehicles> findAll();

    vehicles findVehVin(String id);
    readings findReadVin(String id);
    readings create(readings emp);

    vehicles create(vehicles emp);
    vehicles update(vehicles emp);

}
