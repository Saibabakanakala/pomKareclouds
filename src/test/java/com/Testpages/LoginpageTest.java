package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.Forgotpasswordpage;
import javapages.Homepage;
import javapages.Loginpage;

public class LoginpageTest extends Basepage {
	public Loginpage loginpage;
	public Forgotpasswordpage fpp;
	public Homepage home_page;

	public LoginpageTest() throws IOException {
		super();
	}
	@BeforeMethod()
	public void Launchapplication() throws IOException {
		initlization();
		loginpage=new Loginpage();
	}
	@Test
	public void verifyloginfunction() throws IOException {
		home_page=loginpage.loginfunction("superadmin@gmail.com","Admin@123");
		boolean data=home_page.logocheck();
//		Assert.assertEquals(data,true);
		Assert.assertTrue(data);
		
	}
	
	@Test
	public void verifyForgotpassword() throws IOException {
		fpp=loginpage.forgotfunction();
	}
	
	@Test
	public void verifyForgotpasswordFunctionality() throws IOException {
		fpp=loginpage.forgotfunction();
		
	}
	
	@AfterMethod()
	public void teardown() {
		//driver.close
	}
	
	@Test
	public void verifyinvaliderrormessage() throws IOException {
		loginpage.loginfunction("superadmn@gmail.com", "Admin@123");
		String sai=loginpage.invaliderrormessage();
		Assert.assertEquals("Invalid Username or Password", sai);
	}
	
	
	
	
	
	
	
	

}
