package com.javatpoint.dao;
import java.sql.*;
public class DB {
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","yikun","Zyk1996930");
	}catch(Exception ex){System.out.println(ex);}
	return con;
}
}
