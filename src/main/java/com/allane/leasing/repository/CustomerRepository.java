package com.allane.leasing.repository;

import org.springframework.data.repository.CrudRepository;

import com.allane.leasing.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
