package cs13b027_lab1_2;

import java.util.Scanner;

public class MTechStudent extends Student {

	//Class represting mtech students
	public MTechStudent(TeachingClassEmployee facultyAdvisor){
		super(facultyAdvisor);
		setFacultyAdvisor(facultyAdvisor);
	}
	public void longBio() {
		style("Long Biography");
		data();
		System.out.println("\tclass: " + "BTech/DD Student");
		style();
	}

	private void checkCreditsEarned() {
		if (getCreditsEarned() < 12 * (getSemester() - 1)) {
			sendMail(getFacultyAdvisor());
		}
	}

}
