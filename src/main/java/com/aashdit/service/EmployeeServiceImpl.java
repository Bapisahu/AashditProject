package com.aashdit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashdit.entity.Address;
import com.aashdit.entity.AddressDTO;
import com.aashdit.entity.Employee;
import com.aashdit.entity.MasterAddressType;
import com.aashdit.repository.AddressDTORepository;
import com.aashdit.repository.AddressRepository;
import com.aashdit.repository.EmployeeRepository;
import com.aashdit.repository.MasterAddressTypeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private EmployeeRepository employeeRepo;
	@Autowired
	private MasterAddressTypeRepository masterAddressTypeRepository;
	@Autowired
	private AddressDTORepository addressDTORepo;
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> findById = employeeRepo.findById(id);
		Employee employee = findById.get();
		return employee;
	}
	@Override
	  public List<AddressDTO> getAddressDataByEmployeeId(Long employeeId) {
        // Fetch addresses by employee ID
        List<Address> addresses = addressRepo.findByEmployeeId(employeeId);

        // Fetch address types
        List<MasterAddressType> addressTypes = masterAddressTypeRepository.findAll();
        // Map the address data
        List<AddressDTO> addressDataList = new ArrayList<>();

        for (Address address : addresses) {
        	AddressDTO addressDTO = new AddressDTO();
        	addressDTO.setLine1(address.getLine1());
        	addressDTO.setLine2(address.getLine2());

            // Find the matching address type for the address
            for (MasterAddressType addressType : addressTypes) {
                if (addressType.getId() == address.getAddressTypeId()) {
                	addressDTO.setAddressType(addressType.getAddressTypeCode());
                    break;
                }
            }

            addressDataList.add(addressDTO);
            addressDTORepo.save(addressDTO);
        }
        return addressDataList;
    }
	@Override
	public void saveOneEmployee(Date dateOfBirth, String gender) {
		Employee employee = new Employee();
		employee.setDateOfBirth(dateOfBirth);
		employee.setGenderId(gender);
		employeeRepo.save(employee);
	}
	@Override
	public AddressDTO getAddressById(long id) {
		Optional<AddressDTO> findById = addressDTORepo.findById(id);
		AddressDTO addressDTO = findById.get();
		return addressDTO;
	}
	@Override
	public Long saveAddress(AddressDTO addressData) {
		   Address address = new Address();
	        address.setLine1(addressData.getLine1());
	        address.setLine2(addressData.getLine2());

	        MasterAddressType addressType = masterAddressTypeRepository.findByAddressTypeCode(addressData.getAddressType());
	        address.setAddressType(addressType);
	        addressRepo.save(address);
	        
	        Long employeeId = address.getEmployeeId();
	         return employeeId;
	    }
		
	}
	 


