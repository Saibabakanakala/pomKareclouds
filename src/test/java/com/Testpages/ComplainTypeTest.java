package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.ComplainType;
import javapages.Frontoffice;
import javapages.Homepage;
import javapages.Loginpage;

public class ComplainTypeTest extends Basepage{
	public Homepage hpp;
	public Loginpage loginpage;
	public Frontoffice frontoffice;
    public ComplainType complaintype;

	public ComplainTypeTest() throws IOException {
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
		frontoffice= hpp.Frontofficelink();
		complaintype=frontoffice.clickoncomplainType();
	 
	    boolean result=complaintype.searchfunction("Hospital services");
	    Assert.assertEquals(result, true);
	}
	 @Test
		public void verifyformdetails() throws IOException {
			hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
			frontoffice=hpp.Frontofficelink();
			complaintype=frontoffice.clickoncomplainType();
			complaintype.clickonformdetails("kanakala sai","ICU - Ground Floor");
		}
}
