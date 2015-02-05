package cs13b027_lab1_2;

import java.util.Scanner;

//class represting any teaching class employee
public class TeachingClassEmployee extends Employee {
	

	//function to print the long bio
	public void longBio() {
		style("Long Biography");
		data();
		System.out.println("\tclass: " + "Teaching Class");
		style();
	}

	private String sender;
	private String subject;
	private String message;

	//functionality to send mail to any person
	public void sendMail(Student student) {

		Scanner input = new Scanner(System.in);
		String subject, message, cc;
		System.out.println("Subject: ");
		subject = input.nextLine();
		System.out.println("CC: ");
		cc = input.nextLine();
		System.out.println("Message Body: ");
		message = input.nextLine();
		style("Sending Mail");
		System.out.println("To: " + student.getName());
		System.out.println("CC: " + cc);
		System.out.println("Subject: " + subject);
		System.out.println("Message Body");
		System.out.println("\t" + message);
		student.setMessage(message);
		student.setSubject(subject);
		student.setSender(this.getName());
		style();

	}

	//functioniality to receive mail
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
	
	//getters and setters from here

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

}
