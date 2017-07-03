package io.egen.controller;

import io.egen.entity.readings;
import io.egen.entity.vehicles;
import io.egen.service.vehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by deepakasinathan on 6/30/17.
 */

@RestController
@CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
public class vehicleController {

    @Autowired
    vehicleService service;

    @RequestMapping(method = RequestMethod.GET, value="vehicle", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<vehicles> findAll() {
        return service.findAll();
    }


    @RequestMapping(method = RequestMethod.POST, value="readings")
    public readings create(@RequestBody readings read)
    {
         return service.create(read);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "vehicles")
    public List<vehicles> update(@RequestBody List<vehicles> vehicle) {
          return service.update(vehicle);
    }

}

