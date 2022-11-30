package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.BedGroup;
import javapages.Bedpage;
import javapages.Homepage;
import javapages.Loginpage;

public class BedGroupTest extends Basepage{
	public Homepage hpp;
	public Loginpage loginpage;
    public Bedpage bedpage;
    public BedGroup bedgrouppage;
    
	public BedGroupTest() throws IOException {
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
		bedgrouppage=bedpage.BedGroupList();
	    boolean result=bedgrouppage.searchfunction("VIP Ward");
	    Assert.assertEquals(result, true);
	}
	 @Test 
	    public void verifyformdetails() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		bedpage=hpp.BedLink();
		bedgrouppage=bedpage.BedGroupList();
				bedgrouppage.formdetails("sai","Special floor","abcdefgh");
	
	}
}
