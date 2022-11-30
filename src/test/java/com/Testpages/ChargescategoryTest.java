package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.Chargescategory;
import javapages.Homepage;
import javapages.HospitalChargers;
import javapages.Loginpage;
import javapages.Patientpage;

public class ChargescategoryTest extends Basepage{
	public Homepage hpp;
	public Loginpage loginpage;
	public Patientpage patientpage;
    public HospitalChargers hospitalcharges;
    public Chargescategory cg;
    
	public ChargescategoryTest() throws IOException {
		super();
		
	}
	@BeforeMethod()
	public void Launchapplication() throws IOException {
		initlization();
		loginpage = new Loginpage();
	}
	 @Test 
	    public void verifysearchfunction() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		hospitalcharges=hpp.HospitalLink();
	    cg=hospitalcharges.clickonchargecategory();
	    boolean result=cg.searchfunction("kare clouds");
	    Assert.assertEquals(result, true);
	}
	@Test
	    public void verifyformdetails() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		hospitalcharges=hpp.HospitalLink();
	cg=hospitalcharges.clickonchargecategory();
	//String result=
			cg.formdetails("kanakala sai", "Abcdefgh","Investigations");
	//Assert.assertEquals(result, "Record Saved Successfully");
		
	}

}
