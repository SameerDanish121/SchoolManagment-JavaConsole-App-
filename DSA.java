package myprojectt;


import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
public class DSA {
	public Connection con=null;
	Statement stmt=null;//execute query
	String url=null;
	public DSA() throws SQLException{
		
			//REGISTER DRIVERS
     DriverManager.registerDriver(new SQLServerDriver());
			//initializtion of conncection class object		
     url="jdbc:sqlserver://127.0.0.1;instanceName=MSSQLSERVER;databaseName=mydb;encrypt=true;trustServerCertificate=true;";
			
			 con=DriverManager.getConnection(url,"sa","123456");
				stmt=con.createStatement();
		
			
	}
	public void insertUpdateDelete(String query) throws SQLException{
		
			stmt.execute(query);   
	}
	public ResultSet select(String query) throws SQLException{
		
			ResultSet rs= stmt.executeQuery(query);
		    
			return rs;
		
	}
	
	
	
	
	

}
