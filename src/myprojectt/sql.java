package myprojectt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import myprojectt.DSA;

public class sql {

	public static void main(String[] args) {
		System.out.println("Enter");
		try {
		DSA d1=new DSA();
		}catch(SQLException e) {
			e.printStackTrace();
		};
		System.out.println("Enter");
//		do {
//			System.out.println("Enter 1 to save data");
//			System.out.println("Enter 2 to update data");
//			System.out.println("Enter 3 to delete data");
//			System.out.println("Enter 4 to view data");
//			choice=sc.nextInt();
//			if(choice==1) {
//				System.out.println("Enter course id");
//				String cid=sc.next();
//				System.out.println("Enter Couse title");
//				String ctitle=sc.next();
//				System.out.println("Enter Course credit ");
//				int credits =sc.nextInt();
//		try {
//			DSA objMgr=new DSA();
//			String query=String.format("insert into course values('%s','%s','%s')",cid,ctitle,credits);
//			objMgr.insertUpdateDelete(query);
//			System.out.println("Data Saved !");
//		}catch(Exception e) {e.printStackTrace();}
//	}else if(choice==4) {
//		try {
//			DSA db=new DSA();
//			String query="Select* from course";
//			ResultSet res=db.select(query);
//			while(res.next()) {
//				System.out.println("Course id:"+res.getString(1));
//				System.out.println("Course Title:"+res.getString(2));
//				System.out.println("Course credit hours:"+res.getInt(3));
//			}
//		}catch(Exception e) {
//		}
//		
//	}
//			}while(true);
		}}

