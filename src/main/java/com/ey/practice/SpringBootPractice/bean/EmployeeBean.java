package com.ey.practice.SpringBootPractice.bean;

public class EmployeeBean {
	
	private int employeeid;
	private String lastName;
	private String firstName; 
	private String address; 
	private String city;
	private String caste ;
	private boolean isNative;
	private boolean isEmpIdEven;
	private int balance;
	
	
	
	public EmployeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public EmployeeBean(int employeeid, String lastName, String firstName, String address, String city, String caste,
			boolean isNative, boolean isEmpIdEven, int balance) {
		super();
		this.employeeid = employeeid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.city = city;
		this.caste = caste;
		this.isNative = isNative;
		this.isEmpIdEven = isEmpIdEven;
		this.balance = balance;
	}


	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public boolean isNative() {
		return isNative;
	}
	public void setNative(boolean isNative) {
		this.isNative = isNative;
	}
	public boolean isEmpIdEven() {
		return isEmpIdEven;
	}
	public void setEmpIdEven(boolean isEmpIdEven) {
		this.isEmpIdEven = isEmpIdEven;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "EmployeeBean [employeeid=" + employeeid + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", address=" + address + ", city=" + city + ", caste=" + caste + ", isNative=" + isNative
				+ ", isEmpIdEven=" + isEmpIdEven + ", balance=" + balance + "]";
	}
	
	
	
	
	
	

}
