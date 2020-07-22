package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearch extends CommonMethods {
	@Then("verify table is displayed")
	public void verify_table_is_displayed() {
		Assert.assertEquals(true, viewEmp.isTableDisplayed());
	}

	@Then("get first name from table")
	public void get_first_name_from_table() {
	}

	@When("get data from db")
	public void get_data_from_db() {
	}

	@Then("verify first name from ui against db")
	public void verify_first_name_from_ui_against_db() {
		//Assert.assertEquals(DBSteps.dbData, );

	}
}
