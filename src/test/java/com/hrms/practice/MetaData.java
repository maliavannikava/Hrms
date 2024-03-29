package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class MetaData {
	
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void dbMetadata() throws SQLException{
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData=conn.getMetaData();
		String driverName=dbMetaData.getDriverName();
		String dbVersion=dbMetaData.getDatabaseProductVersion();
		System.out.println(driverName);
		System.out.println(dbVersion);
	}
	
	@Test
	public void rsMetaData() throws SQLException{
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from hs_hr_employees where emp_number=14688");
		ResultSetMetaData rsMetadata=(ResultSetMetaData) rs.getMetaData();
		int colNumbers=rsMetadata.getColumnCount();
		System.out.println(colNumbers);
		String colName1=rsMetadata.getColumnName(1);
		System.out.println(colName1);
		
		for(int i=1; i<colNumbers; i++) {
			String colNames=rsMetadata.getColumnName(i);;
			System.out.println(colNames);
		}
	}
}
