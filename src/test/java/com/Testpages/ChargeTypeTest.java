package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.ChargeType;
import javapages.Homepage;
import javapages.HospitalChargers;
import javapages.Loginpage;
import javapages.Patientpage;

public class ChargeTypeTest extends Basepage {
	public Homepage hpp;
	public Loginpage loginpage;
	public Patientpage patientpage;
    public HospitalChargers hospitalcharges;
    public ChargeType chargetype;

	public ChargeTypeTest() throws IOException {
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
	   chargetype=hospitalcharges.clickonchargeType();
	boolean result=chargetype.searchfunction("Operation Theatre");
	Assert.assertEquals(result, true);
		
	}
	@Test
	public void verifyformdetails() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		hospitalcharges=hpp.HospitalLink();
		chargetype=hospitalcharges.clickonchargeType();
		

		chargetype.formdetails("kanakala sai");
	}
}
