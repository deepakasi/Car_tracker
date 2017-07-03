package io.egen.repository;

import io.egen.entity.readings;
import io.egen.entity.vehicles;
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

    public List<vehicles> findAll() {
        TypedQuery<vehicles> query = entityManager.createNamedQuery("vehicles.findAll",
                vehicles.class);
        return query.getResultList();
    }

    public readings findReadVin(String read) {

       return entityManager.find(readings.class,read);
    }

    public vehicles findVehVin(String vin) {
    return entityManager.find(vehicles.class,vin);

    }

    public vehicles create(vehicles vehicle) {
       entityManager.persist(vehicle);
       return vehicle;
    }

    public readings create(readings read) {
        entityManager.persist(read.getTires());
       entityManager.persist(read);
       return  read;
    }

    public vehicles update(vehicles emp) {
       return  entityManager.merge(emp);
    }

}

