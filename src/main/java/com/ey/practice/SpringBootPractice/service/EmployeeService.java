package com.ey.practice.SpringBootPractice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ey.practice.SpringBootPractice.bean.EmployeeBean;
import com.ey.practice.SpringBootPractice.bean.EmployeeSalaryResponseBean;
import com.ey.practice.SpringBootPractice.exception.EmployeeNotFoundException;
import com.ey.practice.SpringBootPractice.exception.SystemDownException;
import com.ey.practice.SpringBootPractice.model.EmployeeEntity;
import com.ey.practice.SpringBootPractice.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	public List<EmployeeBean> getAllEmployee() {
	
		List<EmployeeBean> beanList=new ArrayList<>();		
		List<EmployeeEntity> entityList = employeeRepository.findAll();		
		for (EmployeeEntity currentEmpEntity : entityList) {
			EmployeeBean empBean = new EmployeeBean();
			empBean.setEmployeeid(currentEmpEntity.getEid());
			empBean.setFirstName(currentEmpEntity.getfName());
			empBean.setLastName(currentEmpEntity.getlName());
			empBean.setAddress(currentEmpEntity.getAdd());
			empBean.setCity(currentEmpEntity.getCity());
			if (empBean.getLastName().equalsIgnoreCase("lname2")) {
				empBean.setCaste("Brahmin");
			} else {
				empBean.setCaste("NonBrahmin");
			}
			if (empBean.getEmployeeid() % 200 == 0) {
				empBean.setEmpIdEven(true);
			} else {
				empBean.setEmpIdEven(false);
			}
			beanList.add(empBean);
		}
		String requestUrl = "http://localhost:9090/esalary/getAllEmployeeSalary";
		EmployeeSalaryResponseBean[] resBeans;
		try {
			resBeans = restTemplate.getForObject(requestUrl, EmployeeSalaryResponseBean[].class);
			for(EmployeeSalaryResponseBean currentEsrBean : resBeans)
			{
				for(EmployeeBean currentEmpSalBean : beanList)
				{
					if(currentEsrBean.getEmployeeid()==currentEmpSalBean.getEmployeeid()) {
						currentEmpSalBean.setBalance(currentEsrBean.getSalary());
						break;
					}
			    }
			}
		} catch (Exception e) {
			throw new SystemDownException("Exception while calling to Jar Application");
			}
	
		return beanList;
	}

	public EmployeeBean getEmployeeById(int empId) {
		EmployeeBean empBean = new EmployeeBean();
		try {
			Optional<EmployeeEntity> empEntityNullCheck = employeeRepository.findById(empId);
			if (empEntityNullCheck.isPresent()) {
				EmployeeEntity empEntity = empEntityNullCheck.get();
				empBean.setEmployeeid(empEntity.getEid());
				empBean.setFirstName(empEntity.getfName());
				empBean.setLastName(empEntity.getlName());
				empBean.setAddress(empEntity.getAdd());
				empBean.setCity(empEntity.getCity());
				if (empBean.getLastName().equalsIgnoreCase("lname2")) {
					empBean.setCaste("Brahmin");
				} else {
					empBean.setCaste("NonBrahmin");
				}
				if (empBean.getEmployeeid() % 200 == 0) {
					empBean.setEmpIdEven(true);
				} else {
					empBean.setEmpIdEven(false);
				}
			} else {
				throw new EmployeeNotFoundException("Enter valid employeeid");
			}
		} catch (EmployeeNotFoundException e) {
			log.error("Enter valid employeeid");
			throw new EmployeeNotFoundException("Enter valid employeeid");
		} catch (Exception e) {
			log.error("Not able to find Employee from database");
			throw new EmployeeNotFoundException("Not able to find Employee from database");
		}
		return empBean;
	}
	public EmployeeBean updateEmployee(String firstName, String lastName,int employeeID) {
		employeeRepository.updateEmployee(firstName, lastName,employeeID);
		Optional<EmployeeEntity> empEntityNullCheck = employeeRepository.findById(employeeID);
		EmployeeBean  empBean = new EmployeeBean();
		try {
			EmployeeEntity empEntity = empEntityNullCheck.get();
			empBean.setEmployeeid(empEntity.getEid());
			empBean.setFirstName(empEntity.getfName());
			empBean.setLastName(empEntity.getlName());
			empBean.setAddress(empEntity.getAdd());
			empBean.setCity(empEntity.getCity());
			if (empBean.getLastName().equalsIgnoreCase("lname2")) {
				empBean.setCaste("Brahmin");
			} else {
				empBean.setCaste("NonBrahmin");
			}
			if (empBean.getEmployeeid() % 200 == 0) {
				empBean.setEmpIdEven(true);
			} else {
				empBean.setEmpIdEven(false);
			}
		} catch (Exception e) {
			System.out.println("Enter valid employeeid");		    
		}
		return empBean;
	}

	public void deleteEmployee(int employeeID) {
		employeeRepository.deleteById(employeeID);
		
	}

	public int createEmployee(EmployeeBean eBean) {
		EmployeeEntity empEntity =new EmployeeEntity();
		empEntity.setfName(eBean.getFirstName());
		empEntity.setlName(eBean.getLastName());
		empEntity.setAdd(eBean.getAddress());
		empEntity.setCity(eBean.getCity());
		EmployeeEntity empSave=employeeRepository.save(empEntity);
		return empSave.getEid();
	}
}
