package com.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.Vehicle;
import com.demo.repository.VehicleRepository;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class VehicleController
{

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping(path = "/vehicles")
    public List<Vehicle> getAllVehicles()
    {
        return vehicleRepository.findAll();
    }

    @GetMapping(path = "/vehicle/{id}")
    public Vehicle getVehicleById(@PathVariable(value = "id") Long vehicleId) throws NotFoundException
    {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);

        if (!vehicle.isPresent())
            throw new NotFoundException("id-" + vehicleId);
        return vehicle.get();
    }

    @PostMapping(path = "/vehicle")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle)
    {
        return vehicleRepository.save(vehicle);
    }

    @PutMapping(path = "/vehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable(value = "id") Long vehicleId,
            @RequestBody Vehicle vehicle)
    {
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }

    @DeleteMapping(path = "/vehicle/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable(value = "id") Long vehicleId)
    {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle.isPresent())
        {
            vehicleRepository.delete(vehicle.get());
            return ResponseEntity.noContent()
                .build();
        }
        return ResponseEntity.notFound()
            .build();
    }

}
