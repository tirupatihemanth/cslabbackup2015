package cs13b027_lab1_2;

import java.util.Scanner;

public class Employee extends People {

	private String employeeId;
	private Date dateOfJoining;
	String designation;
	
	public void Employee(){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Employee Id: ");
		setEmployeeId(input.nextLine());
		System.out.println("Date Of Joining:");
		new Date();
		System.out.print("Designation: ");
		setDesignation(input.nextLine());
		
	}
	
	public void data(){
		
		System.out.println("\tName: " + getName());
		System.out.println("\tEmplyee Id: " + getEmployeeId());
		System.out.println("\tFather's Name: " + getFathersName());
		System.out.println("\tMother's Name: " + getMothersName());
		System.out.println("\tNationality: " + getNationality());
		System.out.println("\tGender: " + getGender());
		System.out.println("\tDepartment: " + getDepartment());
		System.out.println("\tDate Of Joining: " + getDateOfJoining());
		System.out.println("\tDesignation: "+getDesignation());
	}

	public void longBio() {
		
		style("Long Biography");
		data();
		style();
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}
