package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.Bed;
import javapages.BedGroup;
import javapages.BedType;
import javapages.Bedpage;
import javapages.Floor;
import javapages.Homepage;
import javapages.HospitalChargers;
import javapages.Loginpage;

public class FloorTest extends Basepage{
	public Homepage hpp;
	public Loginpage loginpage;
    public Bedpage bd;
    public Floor floor;

	public FloorTest() throws IOException {
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
		bd=hpp.BedLink();
		floor=bd.Floorlink();
	    boolean result=floor.searchfunction("2nd Floor");
	    Assert.assertEquals(result, true);
	}
	 @Test
		public void verifyformdetails() throws IOException {
			hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
			bd=hpp.BedLink();
		    floor=bd.Floorlink();
		floor.formdetails("kanakala sai","ICU - Ground Floor");
		}


}
