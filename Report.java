package PROJECT;

import java.util.Scanner;

public class Report {
public String Report;
public int no;
public void display() {
	System.out.println(no+"      "+Report);
}
public void input() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Report");
	Report=sc.nextLine();
	Report+=sc.nextLine();
}
public void getNo(int n) {
	this.no=n;
}
}
