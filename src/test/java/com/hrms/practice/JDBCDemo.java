package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class JDBCDemo {
	
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void listTask() throws SQLException{
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successfull");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select*from ohrm_job_title");
		List<String> jobTitles=new ArrayList<>();
		while(rs.next()) {
			jobTitles.add(rs.getObject("job_title").toString());
		}
		System.out.println(jobTitles);
		for(String jt:jobTitles) {
			System.out.println(jt);
		}
	}
}
