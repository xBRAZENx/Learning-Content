package com.Searching.test;

public class Employee {


	 private int empId;
	    private String empName;
	    private String designation;
	    private Department department;

	    public Employee(int empId, String empName, String designation, Department department) {
	        this.empId = empId;
	        this.empName = empName;
	        this.designation = designation;
	        this.department = department;
	    }

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		@Override
		public String toString() {
			return "Employees [empId=" + empId + ", empName=" + empName + ", designation=" + designation
					+ ", department=" + department + "]";
		}
		
}
