package com.ey.practice.SpringBootPractice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.practice.SpringBootPractice.bean.EmployeeBean;
import com.ey.practice.SpringBootPractice.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Employee", description = "Employee management APIs")
@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	

	@Operation(
		      summary = "Retrieve all Employee details",
		      description = "Get all employee details.",
		      tags = { "Employees", "get" })
	@GetMapping(path="/getAllEmployees")
	public List<EmployeeBean> getAllEmployee() {
		List<EmployeeBean> empList = employeeService.getAllEmployee();
				return empList;
	}
	
	@Operation(
		      summary = "Retrieve a Employee by Id",
		      description = "Get a Employee object by specifying its id. The response is Employee object with details.",
		      tags = { "Employees", "get" })
	  @ApiResponses({
		    @ApiResponse(responseCode = "200", description = "Employee with ID not retrived  successfully.", content = { @Content(schema = @Schema(implementation = EmployeeBean.class), mediaType = "application/json") }),
		    @ApiResponse(responseCode = "404", description = "The Employee with given Id was not found.", content = { @Content(schema = @Schema()) }),
		    @ApiResponse(responseCode = "8", description = "Exception while calling to Jar Application.", content = { @Content(schema = @Schema()) })
	  })
	@GetMapping(path="/getEmployeeById")
	public EmployeeBean getEmployeeById(@RequestParam(name="employeeId") int empId) {
		EmployeeBean emp = employeeService.getEmployeeById(empId);
		return emp;
	}

//	http://localhost:8080/employee/updateEmployee?firstName=Debashis&lastName=Mishra&employeeID=100
	
	@Operation(
		      summary = "Update Employee details",
		      description = "update employee details by giving employee ID.",
		      tags = { "Employees", "put" })

	@PutMapping(path = "/updateEmployee")
	public EmployeeBean updateEmployee(@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName, @RequestParam(name = "employeeID") int employeeID) {
		EmployeeBean updatedEmp = employeeService.updateEmployee(firstName, lastName, employeeID);
		return updatedEmp;
	}
	
	@Operation(
		      summary = "delete Employee details by ID",
		      description = "Delete employee details by giving employee ID.",
		      tags = { "Employees", "delete" })
	@DeleteMapping(path="/deleteEmployee")
	public String deleteEmployee(@RequestParam(name="employeeID") int employeeID) {
		employeeService.deleteEmployee(employeeID);
		return "Employee with ID " + employeeID + "  deleted successfully !!!";
	}
	
	@Operation(
		      summary = "Insert Employee details",
		      description = "Create employee details after successfull validation of auth-Key.",
		      tags = { "Employees", "post" })
	
	@PostMapping(path = "/createEmployee")
	public String createEmployee(@RequestHeader(name = "auth-key") String authkey, @RequestBody EmployeeBean eBean) {
		if (authkey.equalsIgnoreCase("1234")) {
			int createdEmpID = employeeService.createEmployee(eBean);
			return "Congratulations Employee has registered successfully !! your employeeid " + createdEmpID
					+ "save it for future purpose";
		} else {
			return "You are not authorised to register a new Employee!!";
		}
	}
	
	
	

}
