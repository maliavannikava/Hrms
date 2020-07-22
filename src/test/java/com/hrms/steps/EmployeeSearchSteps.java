package com.hrms.steps;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods{

	@Given("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {
		jsClick(dashboard.PIM);
	}

	@When("user enters valid employee id {string}")
	public void user_enters_valid_employee_id(String empId) {
		sendText(viewEmp.empID, empId);
	}

	@When("click on search button")
	public void click_on_search_button() {
		jsClick(viewEmp.searchBtn);
	}

	@Then("user sees employee information is displayed")
	public void user_sees_employee_information_is_displayed() {
		System.out.println("Employee is displayed");	
	}

	@When("user enters valid employee name and last name")
	public void user_enters_valid_employee_name_and_last_name() {
		sendText(viewEmp.empName, "Bishnu1");
	}
}
