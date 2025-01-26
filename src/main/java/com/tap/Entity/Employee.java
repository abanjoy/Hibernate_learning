package com.tap.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="eId")
	private int empId;
	@Column(name="name")
	private String name;
	@Column(name="desig")
	private String desig;
	@Column(name="salary")
	private int salary;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", desig=" + desig + ", salary=" + salary + "]";
	}
	public Employee(int empId, String name, String desig, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.desig = desig;
		this.salary = salary;
	}
	
	
}
