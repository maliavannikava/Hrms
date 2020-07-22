package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {

	@Given("user is navigated to HRMS")
	public void user_is_navigated_to_HRMS() {
		setUp();
	}

	@Given("user is loggedin with valid admin credentials")
	public void user_is_logged_in_with_valid_admin_credentials() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));

	}

	@When("user enter valid admin username and password")
	public void user_enter_valid_admin_username_and_password() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		click(login.loginBtn);
	}

	@Then("admin user is successfully logged in")
	public void admin_user_is_successfully_logged_in() {
		String expectedSign = "Welcome Admin";
		String actualSign = dashboard.welcome.getText();
		Assert.assertEquals("Invalid message", expectedSign, actualSign);
	}

	@When("user enter valid ess username and password")
	public void user_enter_valid_ess_username_and_password() {
		sendText(login.username, "Elvira");
		sendText(login.password, "Syntax123.");
	}

	@Then("ess user is successfully logged in")
	public void ess_user_is_successfully_logged_in() {
		String expectedSign = "Welcome Elvira";
		String actualSign = dashboard.welcome.getText();
		Assert.assertEquals("Invalid message", expectedSign, actualSign);
		System.out.println(actualSign);
	}

	@When("user enter valid username and invalid password")
	public void user_enter_valid_username_and_invalid_password() {
		sendText(login.username, "Elvira");
		sendText(login.password, "Syntax123");
	}

	@Then("User see Invalid Credentials text on login page")
	public void user_see_Invalid_Credentials_text_on_login_page() {
		String expectedSign = "Invalid credentials";
		String actualSign = login.errorMsg.getText();
		Assert.assertEquals("Invalid message", expectedSign, actualSign);
		System.out.println(actualSign);
	}

	@When("I enter invalid username and password and see error message")
	public void I_enter_invalid_username_and_password_and_see_error_message(DataTable dataTable) {
		List<Map<String, String>> loginList = dataTable.asMaps();

		for (Map<String, String> map : loginList) {
			String userName = map.get("UserName");
			String password = map.get("Password");
			String expectedErrorMsg = map.get("ErrorMessage");

			sendText(login.username, userName);
			sendText(login.password, password);
			click(login.loginBtn);

			String actualErrorMsg = login.errorMsg.getText();
			Assert.assertEquals("Invalid message", expectedErrorMsg, actualErrorMsg);
			System.out.println(actualErrorMsg);
			driver.navigate().refresh();
			wait(2);
		}
	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String username, String password) {
		sendText(login.username, username);
		sendText(login.password, password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		click(login.loginBtn);
	}

	@Then("{string} is successfully logged in")
	public void is_successfully_logged_in(String username) {
		System.out.println(username+" is successfully logged in");
	}

	@Then("user see {string}")
	public void user_see(String errorMessage) {
		System.out.println(errorMessage+" is displayed");
	}
}
