package cs13b027_lab1_2;

public class BtechDDStudent extends Student {

	//class for a btech student
	public BtechDDStudent(TeachingClassEmployee facultyAdvisor){
		super(facultyAdvisor);
		setFacultyAdvisor(facultyAdvisor);
	}
	
	//public method for longBio
	public void longBio() {
		style("Long Biography");
		data();
		System.out.println("\tclass: " + "Btech/DD Student");
		style();
	}

}
