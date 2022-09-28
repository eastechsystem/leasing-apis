package com.allane.leasing.repository;

import org.springframework.data.repository.CrudRepository;

import com.allane.leasing.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

}
