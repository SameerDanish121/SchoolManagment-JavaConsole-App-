package PROJECT;

import java.util.Scanner;
public class Teacher extends Person {
	String subject;
	Subject se;
	public Teacher(){
		
	}
	public void getSubejct(Subject j) {
		this.se=j;
	}
	public Teacher(Teacher t) {
		name=t.name;
		ID=t.ID;
		Username=t.Username;
		password=t.password;
		subject=t.subject;
	}
	public void Input()
	{
	    Scanner s = new Scanner(System.in);
	    super.Input1();
	    System.out.println("Subject Selection is as follow  : ");
	    System.out.println("Press 1 to GET Subjects from list");
	    System.out.println("Press 2 to Enter Your Required Subject");
	    int l=s.nextInt();
	    if(l==1) {
	    	 se.DisplaySubject();
	    System.out.println("Enter Subject : 1+");
	    System.out.println("Enter the ID OF YOUR SELECTED SUBJECT  : ");
		int SelectedSID=s.nextInt();
	    subject=se.ChoseByID(SelectedSID);}else if(l==2){
	    	System.out.println("Enter the Name OF YOUR SELECTED SUBJECT  : ");
	    	subject=s.next();
	    }else
	    	System.out.println("Enter a valid choice");
	    }
	public void Display()
	{
	System.out.println("THE TEACHER INFO IS AS ABOVE");
	 super.Display1();
	 System.out.println("^).THE Subject is : "+subject);
	}
	public void setPassword(int pass) {
		// TODO Auto-generated method stub
		this.password=pass;
	}
	}
