package serial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @author <Your name>
 *
 */
public class StudentPersist {

	/**
	 * @param list 
	 * @param args
	 */
	public static void persist(List<StudentDetails> list) {
		// TODO Write the list Object to a file called "student.txt".
		FileOutputStream output = null;
		
		try {
			output = new FileOutputStream(System.getProperty("user.dir")+"/student.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ObjectOutputStream writes objects to the specified outputstream here as we are writing to a file we use FileOutputStream
		
		ObjectOutputStream objectStream = null;
		
		try {
			objectStream = new ObjectOutputStream(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(StudentDetails student:list){
			try {
				objectStream.writeObject(student);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			objectStream.flush();
		} catch (IOException e) {
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
