package com.litmus7.studentreportcard;

import java.util.Scanner;

//creating an enum of grades
enum grades {
	A("Excellent"), B("Good"), C("Average"), D("Pass"), F("Fail");

	private String description;

	grades(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static grades getGrade(double average) {
		if (average >= 90) {
			return A;
		} else if (average >= 75) {
			return B;
		} else if (average >= 60) {
			return C;
		} else if (average >= 50) {
			return D;
		} else {
			return F;
		}
	}
}

//implementing student class
public class Student {
	Scanner scan = new Scanner(System.in);
	private String name;
	private int rollNo;
	private double marks[] = new double[5];
	private double total, average;
	private grades grade;

//reads input details of the student
	public void inputDetails() {
		System.out.print("enter name:");
		name = scan.next();
		System.out.print("enter roll number:");
		rollNo = scan.nextInt();
		System.out.println("enter marks for the 5 subjects");
		for (int i = 0; i < 5; ++i) {
			System.out.print("subject " + (i + 1) + ":");
			marks[i] = scan.nextDouble();
		}

		// calculate the total marks of the student
		for (double n : marks) {
			total = total + n;
		}

		// calculate the average marks of the student
		for (double n : marks) {
			average += n;
		}
		average = average / 5;

		// calculate the grade of the student
		grade = grades.getGrade(average);
	}

//calculateTotal() returns the total marks
	public double calculateTotal() {
		return total;
	}

//calculateAverage() returns the average marks
	public double calculateAverage() {
		return average;
	}

//printReportCard() prints the student report card with student name, roll number, total marks, average marks and grade
	public void printReportCard() {
		System.out.println("---Report Card---");
		System.out.printf("name:%s\nroll number:%d\ntotal marks:%.2f\naverage marks:%.2f\ngrade:%s\ndescription:%s\n",
				name, rollNo, total, average, grade.toString(), grade.getDescription());

	}
}

// implementing StudentApp class which contains main() method
class StudentApp {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("enter the number of students:");
		int n;
		n = scan.nextInt();
		Student students[] = new Student[n];
		for (int i = 0; i < n; ++i) {
			System.out.println("enter details of student " + (i + 1));
			students[i] = new Student();
			students[i].inputDetails();
		}
		for (int i = 0; i < n; ++i) {
			students[i].printReportCard();
		}
	}
}
