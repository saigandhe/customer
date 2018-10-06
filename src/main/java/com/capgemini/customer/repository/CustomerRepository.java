package com.capgemini.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.customer.model.Customer;


@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
