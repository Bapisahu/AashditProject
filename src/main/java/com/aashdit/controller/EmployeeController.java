package com.aashdit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aashdit.entity.AddressDTO;
import com.aashdit.entity.Employee;
import com.aashdit.service.EmployeeService;

import java.util.Date;
import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }
	@RequestMapping("/viewEmployee")
	public String viewEmployee(@RequestParam("id")long id,Model model) {
	  Employee employee = employeeService.getEmployeeById(id);
	  List<AddressDTO> listOfAddress = employeeService.getAddressDataByEmployeeId(id);
		model.addAttribute("employee", employee);
		model.addAttribute("listOfAddress", listOfAddress);
		return "view_employee";
	}
	@RequestMapping("/editEmployee")
	public String editEmployee(@RequestParam("id")long id,Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "edit_employee";
	}
	
	@RequestMapping("/saveEmployee")
	public String saveEmployee(@RequestParam("dateOfBirth") @DateTimeFormat(pattern = "MM-dd-yyyy") Date dateOfBirth,@RequestParam("gender") String gender) {
		employeeService.saveOneEmployee(dateOfBirth,gender);
		return "edit_employee";
}
	
	@RequestMapping("/employeeAddressInfo")
	public String editEmployeeAddress(@RequestParam("id")long id,Model model) {
		  AddressDTO addressDTO = employeeService.getAddressById(id);
		model.addAttribute("addressDTO", addressDTO);
		return "edit_address";
	}
	
	@RequestMapping("/saveAddress")
	 public String saveAddress(@ModelAttribute("addressDTO") AddressDTO addressDTO,Model model) {
		Long employeeId = employeeService.saveAddress(addressDTO);
		
		
		Employee employee = employeeService.getEmployeeById(employeeId);
		  List<AddressDTO> listOfAddress = employeeService.getAddressDataByEmployeeId(employeeId);
			model.addAttribute("employee", employee);
			model.addAttribute("listOfAddress", listOfAddress);
			return "view_employee";
    }
}

