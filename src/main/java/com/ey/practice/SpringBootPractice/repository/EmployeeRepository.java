package com.ey.practice.SpringBootPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ey.practice.SpringBootPractice.model.EmployeeEntity;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	  
	  
	  @Transactional
	  @Modifying
	  @Query(value = "UPDATE EMPLOYEE SET FIRST_NAME = ? , LAST_NAME = ? WHERE EMPLOYEE_ID = ?", nativeQuery = true)
	   public void updateEmployee(@Param(value = "firstName") String firstName,  @Param(value = "lastName") String lastName,
			   @Param(value = "employeeID") int employeeID );
}
