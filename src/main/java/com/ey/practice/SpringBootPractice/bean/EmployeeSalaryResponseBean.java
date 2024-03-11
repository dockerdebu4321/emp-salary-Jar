package com.ey.practice.SpringBootPractice.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeSalaryResponseBean {
	
@JsonProperty("employeeid")
private int employeeid;
@JsonProperty("ebalance")
private int  salary;

public int getEmployeeid() {
	return employeeid;
}
public void setEmployeeid(int employeeid) {
	this.employeeid = employeeid;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public EmployeeSalaryResponseBean(int employeeid, int salary) {
	super();
	this.employeeid = employeeid;
	this.salary = salary;
}
public EmployeeSalaryResponseBean() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "EmployeeSalaryResponseBean [employeeid=" + employeeid + ", salary=" + salary + "]";
}

}
