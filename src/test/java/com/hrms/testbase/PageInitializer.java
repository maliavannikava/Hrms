package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashBoardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.pages.ViewEmployeePageElements;

public class PageInitializer extends BaseClass{
	
	public static LoginPageElements login;
	public static DashBoardPageElements dashboard;
	public static PersonalDetailsPageElements pdetails;
	public static AddEmployeePageElements addEmp;
	public static ViewEmployeePageElements viewEmp;
	
	public static void initialize() {
	
		login=new LoginPageElements();
		dashboard=new DashBoardPageElements();
		pdetails=new PersonalDetailsPageElements();
		addEmp=new AddEmployeePageElements();
		viewEmp=new ViewEmployeePageElements();
		
	}
}
