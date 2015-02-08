package readandreverse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * @author Tirupati Hemanth Kumar CS2810- File Reading Assignment
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
			outputStream = new FileOutputStream(System.getProperty("user.dir")
					+ "/Output.txt");
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

		
		
		
		/*
		 * InputStreamReader takes in stream and as we need to take it from a
		 * file use FileInputStream as we use System.In for Standard Input
		 * Stream Using InputStreamReader as it has other features of setting
		 * charset and encoding that you use etc., As buffered Reader buffers
		 * the ouputs of readers and increase efficiency it takes in some reader
		 * Similarly OuptputSreamWriter is used for greater scope of
		 * improvements in future in regards to char set and encoding
		 */
		
		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(
				inputStream));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(
				outputStream));
		String line = null;

		try {

			while ((line = input.readLine()) != null) {
				//System.out.println(reverse(line));
				 output.write(reverse(line)+"\n");
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

	public static String reverse(String input) {

		// TODO Find a word-unit reverse of the input string and return.
		// input =
		// "The \"CS2810 lab\" got cancelled due to an India-Pakistan match.";
		// input = "a\"b c\"d e \"f g h \"d e.";
		// input = "\"a b c\".";
		//input = "Ram is a very. Good boy.";

		//input = "\"hello hi\".";
		//input = "ICC has confirmed. It's not bad performance, India has just been 'rested' from the Carlton Series finals.";
		char c = input.charAt(input.length()-1);
		input = input.substring(0, input.length()-1);
		String[] str = input.split("\"");
		
/*		for (String temp : str) {
			System.out.println("temp: " + temp);
		}
*/
		
		String output = "";
		int length = str.length;
		String[] temp;

		for (int i = length - 1; i >= 0; i--) {

			if (str[i].equals(null) || str[i].equals(" ")) {
				continue;
			}
			
			if (i % 2 == 0) {
				temp = str[i].split(" ");
				
				for (int j = temp.length-1; j>=0 ; j--) {
					
					if(temp[j].contains(".") || temp[j].contains("?")){
						if(j>0){
							temp[j-1] = capitalise(temp[j-1]);
							//System.out.print(temp[j-1]+" ");
							if(j<temp.length-1){
								
								if(temp[j+1].length()>1){
									if(temp[j+1].charAt(1)>97){
										temp[j+1] = temp[j+1].toLowerCase();
									}
								}
								else{
									temp[j+1] = temp[j+1].toLowerCase();
								}
								
							}
						}
					}
					
					
					if( i == 0 && j == 0){
						
						if(temp[j].length()>1){
							
							if(temp[j].charAt(1)>97){
								temp[j] = temp[j].toLowerCase();
							}
							
						}
						else{
							temp[j] = temp[j].toLowerCase();
						}
						
						if(!Character.isAlphabetic(temp[j].charAt(temp[j].length()-1))){
							temp[j] = temp[j].substring(0, temp[j].length()-1);
						}
						//output+=temp[j]+" ";
						//output+=capitalise(temp[j])+" ";
						
					}
					else if(i == length-1 && j == temp.length-1){
						temp[j] = capitalise(temp[j]);
						if(temp[j].equals("")){
							continue;
						}
						//output+=temp[j]+" ";
					}
					else{
						//output+=temp[j]+" ";
					}
					
				}
				
				for(int j = temp.length-1;j>=0;j--){
					output+=temp[j]+" ";
				}

			} else {
				output += "\"" + str[i] + "\" ";
			}
		}

		output = output.substring(0, output.length() - 1);
		output += c;
		return output;

	}

	
	private static String capitalise(String str) {
		// TODO Auto-generated method stub
		// System.out.println(str);

		if (str.equals("")) {
			return str;
		}

		if (Character.isAlphabetic(str.charAt(0))) {
			if (str.length() > 1) {
				str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
			} else {
				str = "" + Character.toUpperCase(str.charAt(0));
			}
			return str;
		} else
			return str;
	}
	
	

}
