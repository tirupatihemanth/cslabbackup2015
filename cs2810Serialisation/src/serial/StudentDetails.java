package serial;
/**
 * @author <Your name>
 *
 */
import java.io.Serializable;

public class StudentDetails implements Serializable,Comparable<StudentDetails>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8465116787318420577L;
	private String name;
	private int age;
	private String gender;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public String getgender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setgender(String gender) {
		this.gender = gender;
	}
	@Override
	public int compareTo(StudentDetails student) {
		// TODO Auto-generated method stub
		
		return getName().compareToIgnoreCase(student.getName());
		
	}
	
	public String toString(){
		return "Name: "+getName()+"\n"+"Gender: "+getgender()+"\n"+"Age: "+getAge();
	}
	
}
