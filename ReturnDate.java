package Flight;

import java.util.Scanner;

public class ReturnDate {
	private int day;
	private int month;
	private int year;

	public ReturnDate(int day, int month, int year) {
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
		int day2 = sc.nextInt();
		int month2 = sc.nextInt();
		int year2 = sc.nextInt();
		
		while (day2 > 31 || month2 > 12 || year2 > 2026) {
			System.out.println("Invalid, please enter again.");
			day2 = sc.nextInt();
			month2 = sc.nextInt();
			year2 = sc.nextInt();
		}
}
}
