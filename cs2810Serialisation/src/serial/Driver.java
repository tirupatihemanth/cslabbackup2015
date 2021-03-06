package serial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author <Insert your name>
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Create at least 10 objects of class StudentDetails and set attributes.
		
		Scanner input = new Scanner(System.in);
		ArrayList<StudentDetails> students = new ArrayList<StudentDetails>();
		StudentDetails student;
		for(int i=0;i<10;i++){
			student = new StudentDetails();
			student.setName(input.nextLine());
			student.setgender(input.nextLine());
			student.setAge(input.nextInt());
			input.nextLine();
			students.add(student);
		}
		
		//Persist the objects to a file using the StudentPersist class.
		
		StudentPersist.persist(students);
		
		//Retrieve and print them in a sorted order using the Comparable interface in the GetStudentDetails class.
		
		students.sort(null);
	
		for(StudentDetails stud:students){
			System.out.println(stud);
		}
		
	}

}
