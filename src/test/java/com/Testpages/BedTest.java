package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.Bed;
import javapages.Bedpage;
import javapages.ChargeType;
import javapages.Homepage;
import javapages.HospitalChargers;
import javapages.Loginpage;
import javapages.Patientpage;

public class BedTest  extends Basepage {
	public Homepage hpp;
	public Loginpage loginpage;
	public Patientpage patientpage;
    public HospitalChargers hospitalcharges;
    public ChargeType chargetype;
    public Bed be;
    public Bedpage bedpage;
	public BedTest() throws IOException {
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
		bedpage=hpp.BedLink();
	   be=bedpage.clickonBed();
	    boolean result=be.searchfunction("test");
	    Assert.assertEquals(result, true);
	}
	 @Test
		public void verifyformdetails() throws IOException {
			hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
			bedpage=hpp.BedLink();
		    be=bedpage.clickonBed();
		be.formdetails("kanakala sai","VIP","ICU - Ground Floor");
		}

}
