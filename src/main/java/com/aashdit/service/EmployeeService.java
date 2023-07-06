package com.aashdit.service;

import java.util.Date;
import java.util.List;

import com.aashdit.entity.AddressDTO;
import com.aashdit.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	List<AddressDTO> getAddressDataByEmployeeId(Long employeeId);


	void saveOneEmployee(Date dateOfBirth, String gender);

	AddressDTO getAddressById(long id);

	Long saveAddress(AddressDTO addressDTO);

}
