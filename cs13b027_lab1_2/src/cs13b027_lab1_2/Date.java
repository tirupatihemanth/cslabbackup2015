package cs13b027_lab1_2;

import java.util.Scanner;

public class Date {

	//class for Encoding Date
	private short year;
	private short month;
	private short date;
	
	public Date(){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Year: ");
		setYear(input.nextShort());
		System.out.println("Month: ");
		setYear(input.nextShort());
		System.out.println("Date: ");
		setYear(input.nextShort());
		
	}

	public Date(short month, short year) {
		this((short) 1, month, year);
	}

	public Date(short year) {
		this((short) 1, (short) 1, year);
	}

	public Date(short date, short month, short year) {

		this.date = date;
		this.month = month;
		this.year = year;

	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public short getMonth() {
		return month;
	}

	public void setMonth(short month) {
		this.month = month;
	}

	public short getDate() {
		return date;
	}

	public void setDate(short date) {
		this.date = date;
	}
	
	public String toString(){
		String dateString = ""+date+"/"+month+"/"+year;
		return dateString;
	}

}
