package com.demo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vehicle")
public class Vehicle
{
    private Long id;
    private String brand;
    private String model;
    private String vehicleType;
    private String plateCountry;
    private String plateNumber;
    private String vinNumber;
    private Date creationDate;
    private String manifacturedCountry;

    public Vehicle()
    {
        // Default Empty Constructor
    }

    public Vehicle(String brand, String model, String vehicleType, String plateCountry, String plateNumber,
            String vinNumber, Date creationDate, String manifacturedCountry)
    {
        super();
        this.brand = brand;
        this.model = model;
        this.vehicleType = vehicleType;
        this.plateCountry = plateCountry;
        this.plateNumber = plateNumber;
        this.vinNumber = vinNumber;
        this.creationDate = creationDate;
        this.manifacturedCountry = manifacturedCountry;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Column(name = "brand")
    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    @Column(name = "model")
    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    @Column(name = "vehicle_type")
    public String getVehicleType()
    {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType)
    {
        this.vehicleType = vehicleType;
    }

    @Column(name = "plate_country")
    public String getPlateCountry()
    {
        return plateCountry;
    }

    public void setPlateCountry(String plateCountry)
    {
        this.plateCountry = plateCountry;
    }

    @Column(name = "plate_number")
    public String getPlateNumber()
    {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber)
    {
        this.plateNumber = plateNumber;
    }

    @Column(name = "vin_number", unique = true)
    public String getVinNumber()
    {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber)
    {
        this.vinNumber = vinNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDate")
    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    @Column(name = "manifactured_country")
    public String getManifacturedCountry()
    {
        return manifacturedCountry;
    }

    public void setManifacturedCountry(String manifacturedCountry)
    {
        this.manifacturedCountry = manifacturedCountry;
    }

    @Override
    public String toString()
    {
        return "Vehicle [id=" + id + ", brand=" + brand + ", vehicleType=" + vehicleType + ", plateCountry="
                + plateCountry + ", plateNumber=" + plateNumber + ", vinNumber=" + vinNumber + ", creationDate="
                + creationDate + ", manifacturedCountry=" + manifacturedCountry + "]";
    }
}
