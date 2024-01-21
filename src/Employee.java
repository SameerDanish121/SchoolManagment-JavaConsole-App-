import java.sql.ResultSet;
import java.util.Scanner;

import myprojectt.DSA;
public class Employee {

	public static void main(String[] args) {
		int id;
		String name;
		String designation;
		int salary;
		String adress;
		int phone;
		String CompanyName;
		String NIC;
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("Enter 1 to save data");
			System.out.println("Enter 2 to update data");
			System.out.println("Enter 3 to delete data");
			System.out.println("Enter 4 to view data");
			choice=sc.nextInt();
			if(choice==1) {
				System.out.println("Enter student id");
				id=sc.nextInt();
				System.out.println("Enter name");
				name=sc.next();
				System.out.println("Enter designation ");
				designation=sc.next();
				System.out.println("Enter SALARY ");
				salary=sc.nextInt();
				System.out.println("Enter ADRESS ");
				adress=sc.next();
				System.out.println("Enter PHONE NUMBER ");
				phone=sc.nextInt();
				System.out.println("Enter cOMPANYnAME ");
				CompanyName=sc.next();
				System.out.println("Enter CnIC ");
				NIC=sc.next();
		try {
			DSA objMgr=new DSA();
			String query=String.format("insert into employee values('%s','%s','%s','%s','%s','%s','%s','%s')",id,name,designation,salary,adress,phone,CompanyName,NIC);
			objMgr.insertUpdateDelete(query);
			System.out.println("Data Saved !");
		}catch(Exception e) {e.printStackTrace();}
	}else if(choice==2) {
		try {
			DSA d=new DSA();
			System.out.println("Enter the id of employee you want to update");
			int sid=sc.nextInt();
			System.out.println("Enter student id");
			id=sc.nextInt();
			System.out.println("Enter name");
			name=sc.next();
			System.out.println("Enter designation ");
			designation=sc.next();
			System.out.println("Enter SALARY ");
			salary=sc.nextInt();
			System.out.println("Enter ADRESS ");
			adress=sc.next();
			System.out.println("Enter PHONE NUMBER ");
			phone=sc.nextInt();
			System.out.println("Enter cOMPANYnAME ");
			CompanyName=sc.next();
			System.out.println("Enter CnIC ");
			NIC=sc.next();
			String query="UPDATE employee set id='"+id+"',name='"+name+"',designationn='"+designation+"',salary='"+salary+"',adress='"+adress+"',phoneNumber='"+phone+"',companyName='"+CompanyName+",CNIC='"+NIC+"' where id='"+sid+"'";
			d.insertUpdateDelete(query);
			
		}catch(Exception e) {}
		
	}else if(choice==3) {
		try {
			DSA d=new DSA();
			System.out.println("Enter the id of employee you want to update");
			int sid=sc.nextInt();
			String q="DELETE FROM employee where id='"+sid+"'";
			d.insertUpdateDelete(q);
			
			}catch(Exception e) {}
	}else if(choice==4) {
		try {
			DSA db=new DSA();
			String query="select *from employee";
			ResultSet res=db.select(query);
			while(res.next()) {
				System.out.println("Employee id:"+res.getInt(1));
				System.out.println("Name is:"+res.getString(2));
				System.out.println("designation :"+res.getString(3));
				System.out.println("Salary is:"+res.getInt(4));
				System.out.println("Adress  is:"+res.getString(5));
				System.out.println("PhoneNumber is:"+res.getInt(6));
				System.out.println("Company name  is:"+res.getString(7));
				System.out.println("CNIC  is:"+res.getInt(8));
			}
		}catch(Exception e) {}
	}
			}while(true);}}

