package com.RESTapi.test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_employee")
public class Employee implements Comparable<Employee>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	@NotNull
	private String name;
	
	@Column(name = "age")
	private Long age = 0L;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "email")
	@NotNull
	private String email;
	
	@Column(name = "department")
	private String department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}
	
	
	public void setAge(Long i) {
		this.age = i;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee(Long id, String name, Long age, String location, String email, String department) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.location = location;
		this.email = email;
		this.department = department;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", location=" + location + ", email=" + email
				+ ", department=" + department + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.name.compareToIgnoreCase(o.name);
	}
	
}
