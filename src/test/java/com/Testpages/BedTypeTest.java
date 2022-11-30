package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.BedType;
import javapages.Bedpage;
import javapages.Homepage;
import javapages.Loginpage;

public class BedTypeTest extends Basepage{
	public Homepage hpp;
	public Loginpage loginpage;
    public Bedpage bedpage;
    public BedType bedtype;
	public BedTypeTest() throws IOException {
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
		bedtype=bedpage.clickonbedtypelist();
	    boolean result=bedtype.searchfunction("Standard");
	    Assert.assertEquals(result, true);
	}
	 @Test 
	    public void verifyformdetails() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		bedpage=hpp.BedLink();
		bedtype=bedpage.clickonbedtypelist();
	  bedtype.formdetails("sai");
	
	}

}
