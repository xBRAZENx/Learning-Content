package com.atharva.TestPrograms;

public class Employee {

	private String name;
	private String background;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", background=" + background + "]";
	}
	public Employee(String name, String background) {
		super();
		this.name = name;
		this.background = background;
	}
	
}
