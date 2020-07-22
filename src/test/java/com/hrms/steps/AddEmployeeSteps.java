package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods{
	
	@Given("user is logged with valid admin credentials")
	public void user_is_logged_with_valid_admin_credentials() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
	}

	@Given("user navigates to AddEmployeePage")
	public void user_navigates_to_AddEmployeePage() {
		dashboard.navigateToAddEmployee();
	}

	@When("user enters employee {string} and {string}")
	public void user_enters_employee_and(String fName, String lName) {
		sendText(addEmp.firstName, fName);
		sendText(addEmp.lastName, lName);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
		jsClick(addEmp.saveBtn);
	}

	@Then("{string} is added successfully")
	public void is_added_successfully(String emp) {
		System.out.println(emp+" is added successfully");
	}

	@When("user enters employee first and last name")
	public void user_enters_employee_first_and_last_name() {
		sendText(addEmp.firstName, "Margarita");
		sendText(addEmp.lastName, "Malevan");
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
		pdetails.employeeId.clear();
	}

	@Then("employee is added successfully")
	public void employee_is_added_successfully() {
		System.out.println("Employee is added successfully");
	}

	@When("user clicks on create login checkbox")
	public void user_clicks_on_create_login_checkbox() {
		jsClick(addEmp.checkboxLoginDetails);
	}
	
	@When("user enters login credentials")
	public void user_enters_login_credentials() {
		sendText(addEmp.username, "Margafred");
		sendText(addEmp.password, "Margafred");
		sendText(addEmp.confirmPassword, "Margafred");
	}
	
	@When("user enters employee {string}, {string} and {string}")
	public void user_enters_employee_and(String fName, String mName, String lName) {
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
	}

	@Then("{string}, {string} and {string} is added successfully")
	public void and_is_added_successfully(String string, String string2, String string3) {
		System.out.println("I added the employee!");
	}
	
	@When ("user enters employee details and clicks on save")
	public void user_enters_employee_details_and_clicks_on_save(DataTable dataTable) {
		List<Map<String, String>> addEmployeeList=dataTable.asMaps();
		
		for(Map<String, String> map:addEmployeeList) {
			
			String fname=map.get("FirstName");
			String mname=map.get("MiddleName");
			String lname=map.get("LastName");
			
			
			sendText(addEmp.firstName, fname);
			sendText(addEmp.middleName, mname);
			sendText(addEmp.lastName, lname);
			click(addEmp.saveBtn);
			
			String actual=pdetails.profilePic.getText();
			String expected=fname+" "+mname+" "+lname;
			//Assert.assertEquals();
			jsClick(dashboard.addEmp);
			wait(5);
		}
	}
	
	@Then("employee is added")
	public void employee_is_added() {
		System.out.println("Employee is added using datatable");
	}
	
	@When("user enters employee data from {string} excel sheet then employee is added")
	public void user_enters_employee_data_from_excel_sheet_then_employee_is_added(String sheetName) {
		ExcelUtility.excelIntoListOfMap(Constants.TESTDATA_FILEPATH, sheetName);
	}
}
