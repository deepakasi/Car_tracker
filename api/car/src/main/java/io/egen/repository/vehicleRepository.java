package io.egen.repository;




import io.egen.entity.Reading;
import io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by deepakasinathan on 6/30/17.
 */
public interface vehicleRepository {
    List<Vehicle> findAll();

    Vehicle findVehVin(String id);
    Reading findReadVin(String id);
    Reading create(Reading emp);

    Vehicle create(Vehicle emp);
    Vehicle update(Vehicle emp);

}
