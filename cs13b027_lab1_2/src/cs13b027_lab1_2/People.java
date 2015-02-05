package cs13b027_lab1_2;

import java.util.Scanner;

public class People implements Comparable {

	//A class represting any person of IITM
	public People() {
		Scanner input = new Scanner(System.in);
		System.out.print("Full Name: ");
		setName(input.nextLine());
		System.out.print("Father's Name: ");
		setFathersName(input.nextLine());
		System.out.print("Mother's Name: ");
		setMothersName(input.nextLine());
		System.out.print("Country: ");
		while (!setNationality(input.nextLine())) {
			System.out.println("Please enter a valid country: ");
		}

		System.out.print("Gender: ");
		while (!setGender(input.nextLine())) {
			System.out.println("Enter valid gender [male/female/other]: ");
		}

		System.out.print("Department: ");
		setDepartment(input.nextLine());

	}

	//Enum for input verification
	private enum Country {
		india, america, germany, russia, australia, italy, china, indonesia, malasia
	};

	private enum Gender {
		male, M, m, female, f, F, other, o
	};

	private String name;
	private Country nationality;
	private Gender gender;
	private String mothersName;
	private String fathersName;
	private String department;

	//public method for shortBIo
	public void shortBio() {

		style("Short Biography");
		System.out.println("\tName: " + getName());
		System.out.println("\tFather's Name: " + getFathersName());
		System.out.println("\tMother's Name: " + getMothersName());
		System.out.println("\tNationality: " + getNationality());
		System.out.println("\tGender: " + getGender());
		System.out.println("\tDepartment: " + getDepartment());
		style();

	}

	//gettters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public Country getNationality() {
		return nationality;
	}

	public boolean setNationality(String nationality) {
		for (Country country : Country.values()) {
			if (country.toString().equalsIgnoreCase(nationality)) {
				this.nationality = country;
				return true;
			}
		}
		return false;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean setGender(String gender) {
		for (Gender g : Gender.values()) {
			if (g.toString().equals(gender.toLowerCase())) {
				this.gender = g;
				return true;
			}
		}

		return false;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	//Compare function which compares any two objects
	@Override
	public int compareTo(Object object) {
		// TODO Auto-generated method stub
		People person = (People) object;
		String[] nameComponents = person.name.split(" ");
		String nameSpace = " " + name + " ";
		for (int i = 0; i < nameComponents.length; i++) {
			if (!nameSpace.contains(" " + nameComponents[i] + " ")) {
				break;
			} else if (i == nameComponents.length - 1) {
				return 0;
			}
		}
		return 1;
	}
	
	public boolean compareTo(String str){
		
		String[] nameComponents = str.split(" ");
		String nameSpace = " " + name + " ";
		for (int i = 0; i < nameComponents.length; i++) {
			if (!nameSpace.contains(" " + nameComponents[i] + " ")) {
				break;
			} else if (i == nameComponents.length - 1) {
				return true;
			}
		}
		return false;
		
	}

	public String toString() {
		String person = name;
		return person;
	}

	//adds styles to all objects
	public void style(String str) {
		System.out.println("\n*************** " + str
				+ "********************\n");

	}

	public void style() {
		System.out
				.println("\n***************************************************\n");

	}

}
