package Flight;

import java.util.Scanner;

public class DepartureDate {
	private int day;
	private int month;
	private int year;
	
	
	public DepartureDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day1 = sc.nextInt();
		int month1 = sc.nextInt();
		int year1 = sc.nextInt();
		
		while (day1 > 31 || month1 > 12 || year1 > 2026) {
			System.out.println("Invalid, please enter again.");
			day1 = sc.nextInt();
			month1 = sc.nextInt();
			year1 = sc.nextInt();
		}
	}
	
}
