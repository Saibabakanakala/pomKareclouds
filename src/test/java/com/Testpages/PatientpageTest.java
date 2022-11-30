package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.Disabledpatient;
import javapages.Homepage;
import javapages.Loginpage;
import javapages.Patientpage;
;

public class PatientpageTest extends Basepage {
	public PatientpageTest() throws IOException {
		super();
	}

	public Loginpage loginpage;
	public Homepage homepage;
	public Patientpage patientpage;
    public Disabledpatient dp;	
	@BeforeMethod()
	public void Launchapplication() throws IOException {
		initlization();
		loginpage = new Loginpage();
	}
	//
	@Test
	public void verifyFormDetails() throws IOException {
		homepage=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		patientpage=homepage.selectpatientLink();
		
String result=patientpage.enterFormDetails("sai","xyz","Male","December 1996","10","A+","Single","C:\\Users\\Hp\\OneDrive\\Pictures\\Saved Pictures\\che-ga2c749531_1280.png","123456787",
				"sainaidukanakala@gmail.com","2-67 Amalapuram","sai","saikanakala");
		Assert.assertEquals(result, "Record Saved Successfully");
		
	}
	@Test
	public void VerifyDiabledPatientLink() throws IOException {
		homepage=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		patientpage=homepage.selectpatientLink();
		dp=patientpage.disabledpatient();
		String data=dp.checkPageTitle();
		Assert.assertEquals(data, "Disabled Patient List");
	}
	@Test 
	public void verifysearchfunction() throws IOException {
		homepage=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		patientpage=homepage.selectpatientLink();
		String data=patientpage.searchFunction("1007");
		Assert.assertEquals(data, "1007");
		
	}
	
  @AfterMethod 
  public void teardown() {
	 // driver.close();
	  
  }
  
  
}
