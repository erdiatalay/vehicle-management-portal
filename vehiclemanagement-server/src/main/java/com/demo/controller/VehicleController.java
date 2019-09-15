package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Vehicle;
import com.demo.repository.VehicleRepository;
import com.demo.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@Api(value = "Vehicle Management Portal", produces = "application/json")
public class VehicleController
{

    @Autowired
    private VehicleRepository vehicleRepository;

    @ApiOperation(value = "Get all vehicles", response = List.class)
    @GetMapping(path = "/vehicles")
    public List<Vehicle> getAllVehicles()
    {
        return vehicleRepository.findAll();
    }

    @ApiOperation(value = "Get a vehicle by Id")
    @GetMapping(path = "/vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Long vehicleId)
            throws NotFoundException, ResourceNotFoundException
    {
        final Vehicle vehicle = vehicleRepository.findById(vehicleId)
            .orElseThrow(() -> new ResourceNotFoundException(Constants.ERR_MSJ + vehicleId));

        return ResponseEntity.ok()
            .body(vehicle);
    }

    @ApiOperation(value = "Add a vehicle")
    @PostMapping(path = "/vehicle")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle)
    {
        // Check if VIN number exists, then save or throw error
        return vehicleRepository.findByVinNumber(vehicle.getVinNumber()) != null ? ResponseEntity.badRequest()
            .body(null)
                : ResponseEntity.ok()
                    .body(vehicleRepository.save(vehicle));
    }

    @ApiOperation(value = "Update a vehicle")
    @PutMapping(path = "/vehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable(value = "id") Long vehicleId,
            @RequestBody Vehicle updatedVehicle) throws ResourceNotFoundException
    {
        final Vehicle vehicle = vehicleRepository.findById(vehicleId)
            .orElseThrow(() -> new ResourceNotFoundException(Constants.ERR_MSJ + vehicleId));
        vehicle.setId(updatedVehicle.getId());
        return ResponseEntity.ok()
            .body(vehicleRepository.save(updatedVehicle));
    }

    @ApiOperation(value = "Delete a vehicle")
    @DeleteMapping(path = "/vehicle/{id}")
    public Map<String, Boolean> deleteVehicle(@PathVariable(value = "id") Long vehicleId)
            throws ResourceNotFoundException
    {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
            .orElseThrow(() -> new ResourceNotFoundException(Constants.ERR_MSJ + vehicleId));

        vehicleRepository.delete(vehicle);
        Map<String, Boolean> response = new HashMap<>();
        response.put(Constants.DELETED, Boolean.TRUE);
        return response;
    }

}
