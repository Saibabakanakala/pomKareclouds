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


public class HospitalchargesTest extends Basepage {

	public HospitalchargesTest() throws IOException {
		super();
	
	}
	public Loginpage loginpage;
	public Homepage homepage;
	public HospitalChargers hospitalcharges;
	public Chargescategory cg;
    
	@BeforeMethod()
	public void Launchapplication() throws IOException {
		initlization();
		loginpage = new Loginpage();
	}
	@Test
	public void verifyformdetails() throws IOException, InterruptedException {
				homepage=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
				hospitalcharges=homepage.HospitalLink();
			String mes=hospitalcharges.formdetailswithemptyfield("Tests","12345","300","bloodtest");
	         Assert.assertEquals(mes,"The Charge Category field is required." );
	}
	@Test 
	public void verifysearchfunction() throws IOException {
		homepage=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		hospitalcharges=homepage.HospitalLink();
	boolean result=hospitalcharges.searchfunction("xray");
	Assert.assertEquals(result, true);
		
	}
	@Test
	public void verifychargecategorylink() throws IOException {
		homepage=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		hospitalcharges=homepage.HospitalLink();
	    cg=hospitalcharges.clickonchargecategory();
		 String Result=cg.pagetitle();
		 Assert.assertEquals(Result, "Charge Category List");
	}

}
