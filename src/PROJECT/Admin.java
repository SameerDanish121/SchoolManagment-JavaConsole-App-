package PROJECT;

import java.util.Scanner;
public class Admin {
	Scanner sc=new Scanner(System.in);
	final String Name="SameerDanish";
	 final int ID=333;
	final String Designation="Adminsitrator";
	 public int AdminPass=123456;
	 String UserName=Name+"@BIIT";
	 public void getPass(int a) {
		 this.AdminPass=a;
	 }	
public void Display() {
	System.out.println("");
			System.out.println("          ADMIN INFO           ");
	    System.out.println("^) .NAME : "+Name);
	    System.out.println("^) .ID : "+ID);
	    System.out.println("^) .UserName  :"+UserName);
	    System.out.println("^) .DesiGnation :"+Designation);
	    System.out.println("^) .Password is : "+AdminPass);
	    System.out.println("");
	}
public void setPassword(int pass) {
	// TODO Auto-generated method stub
	this.AdminPass=pass;
}
}

