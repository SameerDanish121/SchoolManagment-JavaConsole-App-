package PROJECT;

import java.util.Arrays;
import java.util.Scanner;
public class Attendance extends Student{
	Scanner sc=new Scanner(System.in);
 final int totalLecture=32;
public int attendedLecture;
int present[]=new int[totalLecture];
char c[]=new char[totalLecture];
public int absents;
public double percentage;
public Attendance() {
	attendedLecture=0;
	absents=0;
	percentage=0;
	
}
public void input() {
	System.out.println("***********Enter Attendance for Student***********");
	System.out.println("Enter 'p' for Present and 'A'for Absent");
 System.out.println("1) to Enter Attendance Consectively");
 System.out.println("2) to Enter ONlY PRESENT,s Reamining Classes Will BE marked Absents");
int l=sc.nextInt();
if(l==1) {
for(int i=0;i<totalLecture;i++) {
		System.out.println("Mark The Attednace for  "+(i+1)+" Class :");
		char c1=sc.next().charAt(0);
		if(c1=='p'||c1=='P') {
			attendedLecture++;
		}else if(c1=='a'||c1=='A') {
			absents++;
		}
			c[i]=c1;
	}}else {
		System.out.println("Enter Numbers OF Prasents");
		int ab=sc.nextInt();
		for(int ko=0;ko<ab;ko++) {
			c[ko]='p';
			attendedLecture++;
		}
		for(int jo=ab;jo<c.length;jo++) {
			c[jo]='a';
			absents++;
		}
	}
}
public double percentage() {
	 this.percentage=(attendedLecture*100)/totalLecture;
	 return this.percentage;
}
public void displayA() {
	System.out.println("");
//	System.out.println("          THE ATTENDANCE INFO IS AS ABOVE       ");
	System.out.println("^) .THE TOTAL Classes you Conducted  ARE = "+totalLecture);
	System.out.println("^) .THE TOTAL Classes you Attended  ARE = "+attendedLecture);
	System.out.println("^) .THE TOTAL ABSENTS MARKED  ARE = "+absents);
	System.out.println("^) .The list of your attended classes in brief = "+Arrays.toString(c));
	System.out.println("^) .YOUR ATTENDANCE PERCENTAGE IS = "+this.percentage()+"%");
	System.out.println("");
}
}
