package PROJECT;

import java.util.Scanner;
public class result {
public String Remarks;
public int totalMarks;
public int obtainedMarks;
public double percentage;
Scanner sc=new Scanner(System.in);
public result() {
	Remarks=null;
	totalMarks=0;
	obtainedMarks=0;
	totalMarks=0;
	percentage=0;
}
	public double examPer() {
		percentage=(obtainedMarks*100)/totalMarks;
		return percentage;
	}
	public void Display() {
		System.out.println("^)The Total Marks of Exam Are :"+totalMarks);
		System.out.println("^)THE STUDENT OBTAINED TOTAL:"+obtainedMarks);
		System.out.println("^)The Percentage of Student is:"+examPer());
		System.out.println("^)The Remarks of Student Are as Follow:"+Remarks);
	}
	public void inputResult1(String[] subject) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Remarks for Student");
		Remarks=sc.next();
		System.out.println("Enter the Marks of  for Student");
		for(int i=0;i<subject.length;i++) {
			System.out.println("Enter Total Marks for "+subject[i]+":");
			int enterT=sc.nextInt();
			totalMarks=totalMarks+enterT;
			System.out.println("Enter Obtained Marks for "+subject[i]+":");
		    int enterO=sc.nextInt();
		    obtainedMarks=obtainedMarks+enterO;
		}
		
	}

}
