package readandreverse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Tirupati Hemanth Kumar 
 * CS2810- File Reading Assignment
 */
public class StringReader {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Read the file "input.txt". For each line find a word-unit
		// reverse and print it.

		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		
		try {
			outputStream = new FileOutputStream(System.getProperty("user.dir")+"/Output.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			inputStream = new FileInputStream(System.getProperty("user.dir")
					+ "/Input.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}

		// InputStreamReader takes in stream and as we need to take it from a
		// file use FileInputStream as we use System.In for Standard Input
		// Stream
		// Using InputStreamReader as it has other features of setting charset
		// and encoding that you use etc.,
		// As buffered Reader buffers the ouputs of readers and increase
		// efficiency it takes in some reader
		//Similarly OuptputSreamWriter is used for greater scope of improvements in future in regards to char set and encoding
		
		BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(outputStream));
		String line = null;

		try {

			while ((line = input.readLine()) != null) {
				System.out.println(reverse(line));
				//output.write(reverse(line)+"\n");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}

		try {
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String reverse(String input){
		
		// TODO Find a word-unit reverse of the input string and return.
		//input = "The \"CS2810 lab\" got cancelled due to an India-Pakistan match.";
		//input = "a\"b c\"d e \"f g h \"d e.";
		//input = "\"a b c\".";
		String[] str = input.split("\"");
		
		for(String temp: str){
			System.out.println("temp: "+temp);
		}
		
		String output ="";
		int length = str.length;
		str[length-1] = str[length-1].substring(0, str[length-1].length()-1);

		for(int i=length-1;i>=0;i--){
			//System.out.println(str[i]);
			//str[i] = str[i].trim();
			
			if(str[i].equals(null) || str[i].equals(" ")){
				continue;
			}
			if(i%2==0){
				String[] temp = str[i].split(" ");
				for(int j=temp.length-1;j>=0;j--){
					if(j==0){
						output+=temp[0].toLowerCase()+" ";
					}
					else {
						output+=temp[j]+" ";
					}
				}
			}
			else{
				output+="\""+str[i]+"\" ";
			}
		}
		
		output = output.substring(0, output.length()-1);
		output+=".";
		return output;
		
	}

	private static String capitalise(String str){
		// TODO Auto-generated method stub
		// System.out.println(str);
		
		if (str.equals(null)) {
			return null;
		}

		if (Character.isAlphabetic(str.charAt(0))) {
			if (str.length() > 1) {
				str += Character.toUpperCase(str.charAt(0)) + str.substring(1);
			} else {
				str = "" + Character.toUpperCase(str.charAt(0));
			}
			return str;
		} else
			return str;
	}

}
