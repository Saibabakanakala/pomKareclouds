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
import javapages.Source;

public class SourceTest extends Basepage{
	public Homepage hpp;
	public Loginpage loginpage;
	public Frontoffice frontoffice;
    public ComplainType complaintype;
    public Source source;
	public SourceTest() throws IOException {
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
		frontoffice=hpp.Frontofficelink();
		source=frontoffice.clickonsourcelink();
	    boolean result=source.searchfunction("From visitors");
	    Assert.assertEquals(result, true);
	}
	 @Test
		public void verifyformdetails() throws IOException {
			hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
			frontoffice=hpp.Frontofficelink();
			source= frontoffice.clickonsourcelink();
			source.formdetails("kanakala sai","VIP");
		}
}
