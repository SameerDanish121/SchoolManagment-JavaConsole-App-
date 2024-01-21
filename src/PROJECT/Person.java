package PROJECT;

import java.util.Scanner;

public abstract class Person {
	public String name;
	public int ID;
	String Username;
	int  password;
	Person(){
	}
	public void Input1()
	{
	    Scanner s = new Scanner(System.in);
	    System.out.println("^) .Enter  NAME: ");
	    name=s.nextLine();
	    System.out.println("^) .Enter  ID : ");
	    ID=s.nextInt();
	    Username=name+"@BIIT";
	    System.out.println("^)  .Enter  PassWord : ");
	    password=s.nextInt();
	    s.nextLine();}
	public void Display1()
	{
		System.out.println("");
	    System.out.println("^) .NAME = "+name);
	    System.out.println("^) .ID = "+ID);
	    System.out.println("^) .UserName  ="+Username);
	    System.out.println("^) .PassWord  = "+password);
	}
public abstract void Input();
public abstract void Display();
}
