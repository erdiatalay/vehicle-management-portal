package com.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.demo.model.Vehicle;
import com.demo.repository.VehicleRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleRepositoryTest
{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testSaveVehicle()
    {
        Vehicle vehicle = new Vehicle("Audi", "a8", "car", "pc", "pn", "AudiVin1", new Date(), "Germany");
        vehicleRepository.save(vehicle);

        Vehicle vehicle2 = vehicleRepository.findByVinNumber("AudiVin1");
        assertNotNull(vehicle);
        assertEquals(vehicle.getBrand(), vehicle2.getBrand());
        assertEquals(vehicle.getModel(), vehicle2.getModel());
    }

    @Test
    public void findAllVehicles()
    {
        Vehicle vehicle = new Vehicle("Audi", "a8", "car", "pc", "pn", "AudiVin1", new Date(), "Germany");
        vehicleRepository.save(vehicle);
        assertNotNull(vehicleRepository.findAll());
    }

    @Test
    public void findVehicle()
    {
        Vehicle vehicle = new Vehicle("Audi", "a8", "car", "pc", "pn", "AudiVin1", new Date(), "Germany");
        vehicleRepository.save(vehicle);
        assertNotNull(vehicleRepository.findById(vehicle.getId()));
    }

    @Test
    public void testDeleteVehicle()
    {
        Vehicle vehicle = new Vehicle("Audi", "a8", "car", "pc", "pn", "AudiVin1", new Date(), "Germany");
        vehicleRepository.save(vehicle);
        vehicleRepository.delete(vehicle);
    }
}
