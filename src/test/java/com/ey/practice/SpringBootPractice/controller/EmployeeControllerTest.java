package com.ey.practice.SpringBootPractice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.web.servlet.MockMvc;

import com.ey.practice.SpringBootPractice.bean.EmployeeBean;
import com.ey.practice.SpringBootPractice.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class EmployeeControllerTest {
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@Mock
	private EmployeeService employeeService;
	
	private MockMvc mockMVC;
	
	@Test
	public void getAllEmployeesTest()
	{ 
		List<EmployeeBean> empList=new ArrayList<EmployeeBean>();
		empList.add(new EmployeeBean(100, "Mishra","Debashis", "KSNagar", "BMPR", "Brahmin",true, false, 12000));
		empList.add(new EmployeeBean(200, "Panda","Shibashis", "KSNagar", "BMPR", "nonBrahmin",true, false, 22000));
		empList.add(new EmployeeBean(300, "Parddgdnda","dfg", "KSNafdgfgar", "BMPR", "nonBrahmin",true, false, 12000));
		when(employeeService.getAllEmployee()).thenReturn(empList);
		assertEquals(empList.size(),employeeController.getAllEmployee().size());
	}
	@Test
	public void getEmployeeByIdTest()
	{ 
		EmployeeBean empBean=new EmployeeBean(100, "Mishra","Debashis", "KSNagar", "BMPR", "Brahmin",true, false, 12000);
		when(employeeService.getEmployeeById(anyInt())).thenReturn(empBean);
		
		assertEquals("Mishra",employeeController.getEmployeeById(200).getLastName());
		assertEquals(12000,employeeController.getEmployeeById(200).getBalance());
	}



}
