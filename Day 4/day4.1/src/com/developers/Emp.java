package com.developers;
import static java.lang.System.out;

public class Emp {
	private int id; //auto generated 
	private String name;
	private double salary;
	private int deptId;
	//add id generator
	private static int idGenerator;
	//static init block
	static {
		//out.println("Emp : in static init block - 1");
		out.println(idGenerator);//0
		idGenerator=1000;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public Emp(String name, double salary, int deptId) {	
		this.id=idGenerator++;
		this.name = name;
		this.salary = salary;
		this.deptId = deptId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
