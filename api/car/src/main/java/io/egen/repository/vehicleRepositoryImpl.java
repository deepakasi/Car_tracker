package io.egen.repository;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by deepakasinathan on 6/30/17.
 */

@Repository
public class vehicleRepositoryImpl implements vehicleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",
                Vehicle.class);
        return query.getResultList();
    }

    public Reading findReadVin(String read) {

       return entityManager.find(Reading.class,read);
    }

    public Vehicle findVehVin(String vin) {
    return entityManager.find(Vehicle.class,vin);

    }

    public Vehicle create(Vehicle vehicle) {
       entityManager.persist(vehicle);
       return vehicle;
    }

    public Reading create(Reading read) {
        entityManager.persist(read.getTires());
       entityManager.persist(read);
       return  read;
    }

    public Vehicle update(Vehicle emp) {
       return  entityManager.merge(emp);
    }

}

