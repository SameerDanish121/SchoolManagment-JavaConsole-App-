package PROJECT;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Student extends Person {
	Attendance a;
	Subject s;
	result r;
	
	
public String Section;
String[] Subject=new String[5];
public Student() {
}
public void getSubject(Subject t) {
	this.s=t;
}
public Student(Student s2) {
	a=new Attendance();
	r=new result();
	name=s2.name;
	ID=s2.ID;
	Section=s2.Section;
	Username=s2.Username;
	password=s2.password;
	Subject[0]=s2.Subject[0];
	Subject[1]=s2.Subject[1];
	Subject[2]=s2.Subject[2];
	Subject[3]=s2.Subject[3];
	Subject[4]=s2.Subject[4];
	a.absents=s2.a.absents;
	a.attendedLecture=s2.a.attendedLecture;
	a.percentage=s2.a.percentage;
	for(int i=0;i<a.c.length;i++) {
	a.c[i]=s2.a.c[i];
	}
	r.totalMarks=s2.r.totalMarks;
	r.obtainedMarks=s2.r.obtainedMarks;
	r.percentage=s2.r.percentage;
	r.Remarks=s2.r.Remarks;
}
public  String setSection() {
	return Section;
}
public void Input()
{
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Student INFO");
    super.Input1();
    System.out.println("Enter SECTION : ");
    Section=sc.nextLine();
    System.out.println("The Subject are as follow SUBJECT  : ");
    s.DisplaySubject();
    for(int i2=0;i2<Subject.length;i2++) {
    System.out.println("Enter Subject : "+(i2+1)+"..");
    System.out.println("Enter the ID OF YOUR SELECTED SUBJECT  : ");
	int SelectedSID=sc.nextInt();
    Subject[i2]=s.ChoseByID(SelectedSID);
    }
    insertReportCard();
    }
public void Display()
{
	 System.out.println("              ~STUDENT INFO IS AS ABOVE~           ");
     super.Display1();
     System.out.println("^) .Section  :"+Section);
     System.out.println("^) .Subjects :"+Arrays.toString(Subject));
     System.out.println("");
}
public void GetData(int i,String n,String u,int p,String s1,String s2,String s3,String s4,String s5,int al,int ab,double ap,int tm,int om,double rp,String rem,String sec) {
	a=new Attendance();
	r=new result();
	this.ID=i;
	this.name=n;
	this.Username=u;
	this.password=p;
	this.Section=sec;
	this.Subject[0]=s1;
	this.Subject[1]=s2;
	this.Subject[2]=s3;
	this.Subject[3]=s4;
	this.Subject[4]=s5;
	this.a.attendedLecture=al;
	this.a.absents=ab;
	this.a.percentage=ap;
	this.r.totalMarks=tm;
	this.r.obtainedMarks=om;
	this.r.percentage=rp;
	this.r.Remarks=rem;
	if(a.absents==0) {
		for(int i1=0;i1<32;i1++) {
		this.a.c[i1]='p';
		}
	}else if(a.attendedLecture==0) {
		for(int i2=0;i2<32;i2++) {
			this.a.c[i2]='a';
			}
	}else {
		for(int i3=0;i3<a.absents;i3++) {
			this.a.c[i3]='a';
			}
		for(int i4=a.absents;i4<32;i4++) {
			this.a.c[i4]='p';
			}
	}
	
}
public void getPass(int pass) {
	this.password=pass;
}
public void insertReportCard() {
	a=new Attendance();
	r=new result();
	a.input();
	r.inputResult1(Subject);
}
public void DisplayReportCard() {
	System.out.println("             ~REPORT CARD~        ");
	System.out.println(" ");
	System.out.println("        ~Attendance INFO~        ");
	a.displayA();
	System.out.println("        ~RESULT INFO~        ");
	r.Display();
}
}