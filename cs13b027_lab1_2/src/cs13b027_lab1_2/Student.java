package cs13b027_lab1_2;

import java.util.Scanner;

public class Student extends People {

	public Student() {
		Scanner input = new Scanner(System.in);
		System.out.println("Admission Date");
		new Date();
		System.out.print("Roll Number: ");
		
		while(!setRollNumber(input.nextLine())){
			System.out.println("Enter a valid Roll Number: ");
		}
		
		System.out.print("Hostel: ");
		while(!setHostel(input.nextLine())){
			System.out.println("Enter Valid Hostel Name: ");
		}
		
		System.out.print("cgpa: ");
		setCgpa(input.nextDouble());
		System.out.print("Semester: ");
		
		while(!setSemester(input.nextShort())){
			System.out.println("Enter a valid semester number: ");
		}
		
		System.out.print("Credits Earned: ");
		setCreditsEarned(input.nextShort());
		System.out.print("Faculty Advisor: ");
		setFacultyAdvisor(input.nextLine());
		
		if(creditsEarned<15*semester){
			sendMail(facultyAdvisor);
		}
	}

	private void sendMail(String facAdv) {
		
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
		System.out.println("To: "+getFacultyAdvisor());
		System.out.println("CC: "+cc);
		System.out.println("Subject: "+subject);
		System.out.println("Message Body");
		System.out.println("\t"+message);
		
		style();
	}
	
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

	private void receiveMail(){
		style("Received Mail");
		if(sender.equals("")){
			System.out.println("Nothing to see here Move Along");
			style();
			return;
		}
		System.out.println("From: "+ getSender());
		System.out.println("Subject: "+ getSubject());
		System.out.println("Message Body");
		System.out.println("\t"+getMessage());
	}

	private enum Hostel {
		saraswathi, tapti, godavari, krishna, cauvery, mahanadhi, tamaraparini, sharavathi,sarayu,sabarmathi
	};

	private Date admissionDate;
	private String rollNumber;
	private Hostel hostel;
	private double cgpa;
	private short semester;
	private short creditsEarned;
	private String facultyAdvisor;
	private String sender;
	private String subject;
	private String message;
	public void longBio() {
		
		style("Long Bio");
		data();
		style();
		
	}
	
	public void data(){
		
		System.out.println("\tName: " + getName());
		System.out.println("\tRoll Number: "+getRollNumber());
		System.out.println("\tFather's Name: " + getFathersName());
		System.out.println("\tMother's Name: " + getMothersName());
		System.out.println("\tNationality: " + getNationality());
		System.out.println("\tGender: " + getGender());
		System.out.println("\tDepartment: " + getDepartment());
		System.out.println("\tAdmission Date: " + getAdmissionDate());
		System.out.println("\tFaculty Advisor: "+getFacultyAdvisor());
		System.out.println("\tCGPA: "+getCgpa());
		System.out.println("\tSemester: "+getSemester());
		System.out.println("\tCredits Earned: "+getCreditsEarned());

		
	}

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
			if (h.toString().equals(hostel.toLowerCase())) {
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

	public String getFacultyAdvisor() {
		return facultyAdvisor;
	}

	public void setFacultyAdvisor(String facultyAdvisor) {
		this.facultyAdvisor = facultyAdvisor;
	}

}
