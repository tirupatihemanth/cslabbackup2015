package cs13b027_lab1_2;

import java.util.Scanner;

public class Student extends People {

	//Class represting students of iitm
	private Date admissionDate;
	private String rollNumber;
	private Hostel hostel;
	private double cgpa;
	private short semester;
	private short creditsEarned;
	private TeachingClassEmployee facultyAdvisor;
	
	//constructor for student class
	public Student(TeachingClassEmployee facultyAdvisor) {
		Scanner input = new Scanner(System.in);
		System.out.println("Admission Date");
		new Date();
		System.out.print("Roll Number: ");

		while (!setRollNumber(input.nextLine())) {
			System.out.println("Enter a valid Roll Number: ");
		}

		System.out.print("Hostel: ");
		while (!setHostel(input.nextLine())) {
			System.out.println("Enter Valid Hostel Name: ");
		}

		System.out.print("cgpa: ");
		setCgpa(input.nextDouble());
		System.out.print("Semester: ");

		while (!setSemester(input.nextShort())) {
			System.out.println("Enter a valid semester number: ");
		}

		System.out.print("Credits Earned: ");
		setCreditsEarned(input.nextShort());
		
		this.facultyAdvisor = facultyAdvisor;
		
		checkCreditsEarned();
		
	}

	private void checkCreditsEarned() {
		if (creditsEarned < 15 * (semester - 1)) {
			sendMail();
		}
	}

	//private method for auto mail
	private void sendMail(){
		
		try{
			facultyAdvisor.setMessage(message);
			facultyAdvisor.setSubject(subject);
			facultyAdvisor.setSender(getName());
		}
		catch(NullPointerException e){
			System.out.println("you haven't been allocated faculty Advisor. Aborting the auto mail feature");
			return;
		}
		
		String message = "I "+getName()+" with "+getRollNumber()+" don't meet the credit requirement.";
		style("Auto Generated Mail");
		System.out.println("A message is automatically sent to FacAd as this Record don't meet the credit requirements");
		System.out.println("To: " + getFacultyAdvisor());
		System.out.println("Subject: " + "Regarding Credit Requirements");
		System.out.println("Message Body");
		System.out.println("\t" + message);
		style();
	}
	
	//public method for custom mail
	public void sendMail(TeachingClassEmployee facAd) {

		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String subject, message, cc;
		System.out.println("Subject: ");
		subject = input.nextLine();
		System.out.println("CC: ");
		cc = input.nextLine();
		System.out.println("Message Body: ");
		message = input.nextLine();
		style("Sending Mail");
		System.out.println("To: " + getFacultyAdvisor());
		System.out.println("CC: " + cc);
		System.out.println("Subject: " + subject);
		System.out.println("Message Body");
		System.out.println("\t" + message);
		facAd.setMessage(message);
		facAd.setSubject(subject);
		facAd.setSender(this.getName());
		style();

	}

	private String sender;
	private String subject;
	private String message;

	//public method to check the latest received mail
	public void receiveMail() {
		style("Received Mail");
		if (sender.equals("")) {
			System.out.println("Nothing to see here Move Along :)");
			style();
			return;
		}
		System.out.println("From: " + getSender());
		System.out.println("Subject: " + getSubject());
		System.out.println("Message Body");
		System.out.println("\t" + getMessage());
		style();
	}

	//getters and setters
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private enum Hostel {
		saraswathi, tapti, godavari, krishna, cauvery, mahanadhi, tamaraparini, sharavathi, sarayu, sabarmathi
	};


	//public method for long bio
	public void longBio() {

		style("Long Bio");
		data();
		style();

	}

	//storing the common data
	public void data() {

		System.out.println("\tName: " + getName());
		System.out.println("\tRoll Number: " + getRollNumber());
		System.out.println("\tFather's Name: " + getFathersName());
		System.out.println("\tMother's Name: " + getMothersName());
		System.out.println("\tNationality: " + getNationality());
		System.out.println("\tGender: " + getGender());
		System.out.println("\tDepartment: " + getDepartment());
		System.out.println("\tAdmission Date: " + getAdmissionDate());
		System.out.println("\tFaculty Advisor: " + getFacultyAdvisor());
		System.out.println("\tCGPA: " + getCgpa());
		System.out.println("\tSemester: " + getSemester());
		System.out.println("\tCredits Earned: " + getCreditsEarned());

	}

	///getters and setters
	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public boolean setRollNumber(String rollNumber) {
		if (rollNumber.length() == 8) {
			this.rollNumber = rollNumber;
			return true;
		} else {
			return false;
		}
	}

	public Hostel getHostel() {
		return hostel;
	}

	public boolean setHostel(String hostel) {
		for (Hostel h : Hostel.values()) {
			if (h.toString().equalsIgnoreCase(hostel)) {
				this.hostel = h;
				return true;
			}
		}

		return false;
	}

	public double getCgpa() {
		return cgpa;
	}

	public boolean setCgpa(double cgpa) {
		if (cgpa > 1.0 && cgpa < 10.0) {
			this.cgpa = cgpa;
			return true;
		} else {
			return false;
		}
	}

	public short getSemester() {
		return semester;
	}

	public boolean setSemester(short semester) {
		if (semester < 1 || semester > 12) {
			return false;
		} else {
			this.semester = semester;
			return true;
		}
	}

	public short getCreditsEarned() {
		return creditsEarned;
	}

	public void setCreditsEarned(short creditsEarned) {
		this.creditsEarned = creditsEarned;
	}

	public TeachingClassEmployee getFacultyAdvisor() {
		return facultyAdvisor;
	}

	public void setFacultyAdvisor(TeachingClassEmployee facultyAdvisor) {
		this.facultyAdvisor = facultyAdvisor;
	}

}
