package com.hrms.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class LoginPageElements extends CommonMethods{
	
	@FindBy(id="txtUsername")
	public static WebElement username;
	
	@FindBy(name="txtPassword")
	public static WebElement password;
	
	@FindBy(id="btnLogin")
	public static WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	public static WebElement logo;
	
	@FindBy (id="spanMessage")
	public static WebElement errorMsg;
	
	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	//if  we keep element as private then we will need to create piblic getters 
	//and setters so we could access page elements from test classes
	
	//setter
	public void sendUsername(String uid) {
		sendText(username, uid);
	}
	
	//getter
	public WebElement getUsername() {
		return username;
	}
	
	public void login(String uid, String pwd) {
		sendText(username, uid);
		sendText(password, pwd);
		click(loginBtn);
	}
}
