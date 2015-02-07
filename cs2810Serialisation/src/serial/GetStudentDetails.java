package serial;
/**
 * @author <Tirupati Hemanth Kumar>
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GetStudentDetails {

	/**
	 * @param args
	 */
	public static void retrieve() {
		// TODO Retrieve the object written in the file "student.txt"
		
		FileInputStream input = null;
		try {
			input = new FileInputStream(System.getProperty("user.dir")+"/student.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectInputStream objectStream = null;
		try {
			
			objectStream = new ObjectInputStream(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<StudentDetails> students = new ArrayList<StudentDetails>();
		
		StudentDetails student;
		try {
			while((student = (StudentDetails)objectStream.readObject())!=null){
				students.add(student);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			objectStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
