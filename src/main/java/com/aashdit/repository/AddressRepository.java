package com.aashdit.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aashdit.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByEmployeeId(Long employeeId);
}
