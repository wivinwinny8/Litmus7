package studentReportCard;
import java.util.Scanner;

class Student {
	Scanner scan=new Scanner(System.in);
	String name;
	int rollNo;
	double marks[]=new double[5];
	String grade;
	double total,average;
	void inputDetails() {
		System.out.print("enter name:");
		name=scan.next();
		System.out.print("enter roll number:");
		rollNo=scan.nextInt();
		System.out.println("enter marks for the 5 subjects");
		for(int i=0;i<5;++i) {
			System.out.print("subject " + (i+1)+":");
			marks[i]=scan.nextDouble();
		}
		
		//calculate total
		for(double n: marks) {
			total=total+n;
		}
		
		//calculate average
		for(double n:marks) {
			average+=n;
		}
		average=average/5;
		
		//calculate grade
		if (average>=90){
			grade="A";
		}
		else if(average>=75) {
			grade="B";
		}
		else if(average>=60) {
			grade="C";
		}
		else if(average>=50) {
			grade="D";
		}
		else {
			grade="F";
		}
	}
	
	double calculateTotal() {
		return total;
	}
	
	double calculateAverage() {
		return average;
	}
	
	String getGrade() {
		return grade;
	}
	
	void printReportCard() {
		System.out.println("---Report Card---");
		System.out.printf("name:%s\nroll number:%d\ntotal marks:%.2f\naverage marks:%.2f\ngrade:%s\n",name,rollNo,total,average,grade);
		
	}
}

class studentApp{
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.print("enter the number of students:");
		int n;
		n=scan.nextInt();
		Student s[]=new Student[n];
		for(int i=0;i<n;++i) {
			System.out.println("enter details of student "+(i+1));
			s[i]=new Student();
			s[i].inputDetails();
		}
		for(int i=0;i<n;++i) {
			s[i].printReportCard();
		}
	}
}

