package com.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import com.demo.model.Vehicle;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VehiclemanagementServerApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleControllerIntegrationTest
{
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl()
    {
        return "http://localhost:" + port + "/api";
    }

    @Test
    public void contextLoads()
    {

    }

    @Test
    public void testGetAllVehicles()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response =
                restTemplate.exchange(getRootUrl() + "/vehicles", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetVehicleById()
    {
        Vehicle vehicle = restTemplate.getForObject(getRootUrl() + "/vehicle/1", Vehicle.class);
        System.out.println(vehicle.getBrand());
    }

    @Test
    public void testCreateVehicle()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("B");
        vehicle.setCreationDate(new Date());
        vehicle.setManifacturedCountry("MC");
        vehicle.setPlateCountry("PC");
        vehicle.setPlateNumber("PN");
        vehicle.setVehicleType("VY");
        vehicle.setVinNumber("VN");
        ResponseEntity<Vehicle> postResponse =
                restTemplate.postForEntity(getRootUrl() + "/vehicle", vehicle, Vehicle.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateVehicle()
    {
        int id = 1;
        Vehicle vehicle = restTemplate.getForObject(getRootUrl() + "/vehicle/" + id, Vehicle.class);
        vehicle.setBrand("B1");
        vehicle.setCreationDate(new Date());
        vehicle.setManifacturedCountry("MC1");
        vehicle.setPlateCountry("PC1");
        vehicle.setPlateNumber("PN1");
        vehicle.setVehicleType("VY1");
        vehicle.setVinNumber("VN1");
        restTemplate.put(getRootUrl() + "/vehicle/" + id, vehicle);
        Vehicle updatedVehicle = restTemplate.getForObject(getRootUrl() + "/vehicle/" + id, Vehicle.class);
        assertNotNull(updatedVehicle);
    }

    @Test
    public void testDeleteVehicle()
    {
        int id = 2;
        Vehicle vehicle = restTemplate.getForObject(getRootUrl() + "/vehicle/" + id, Vehicle.class);
        assertNotNull(vehicle);
        restTemplate.delete(getRootUrl() + "/vehicle/" + id);
        try
        {
            vehicle = restTemplate.getForObject(getRootUrl() + "/vehicle/" + id, Vehicle.class);
        } catch (final HttpClientErrorException e)
        {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }
    }

}
