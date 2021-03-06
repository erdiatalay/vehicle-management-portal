package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>
{
    public Vehicle findByVinNumber(String vinNum);
}
