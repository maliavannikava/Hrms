package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StoringData {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void dbMetadata() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id, name, country_code from ohrm_location");

		List<Map<String, String>> listOfData = new ArrayList<>();

		Map<String, String> mapData;

		while (rs.next()) {
			mapData = new LinkedHashMap<>();
			mapData.put("Location id", rs.getObject("id").toString());
			mapData.put("Office name", rs.getObject("name").toString());
			mapData.put("Country code", rs.getObject("country_code").toString());

			listOfData.add(mapData);
		}
		System.out.println(listOfData);
		rs.close();
		st.close();
		conn.close();
	}

	@Test
	public void retrieveAndStoreDataEnhanced() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_hob_title");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		List<Map<String, String>> listData = new ArrayList<>();
		Map<String, String> mapData;

		while (rs.next()) {
			mapData = new LinkedHashMap<>();
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
				mapData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			}
			listData.add(mapData);
		}
		System.out.println(listData);
	}

	// display the information from nationality table,
	// but display id as "nationality id", name as "nationality"
	@Test
	public void test() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id, name, from ohrm_nationality");

		List<Map<String, String>> listOfData = new ArrayList<>();

		Map<String, String> mapData;

		while (rs.next()) {
			mapData = new LinkedHashMap<>();
			mapData.put("Nationality id", rs.getObject("id").toString());
			mapData.put("Nationality", rs.getObject("name").toString());

			listOfData.add(mapData);
		}
		System.out.println(listOfData);
		System.out.println();
		rs.close();
		st.close();
		conn.close();
	}
}
