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
import javapages.Patientpage;

public class BedpageTest extends Basepage {
	public Homepage hpp;
	public Loginpage loginpage;

    public HospitalChargers hospitalcharges;
    public Bedpage bd;
    public Bed bed;
    public BedType bedtype;
    public BedGroup bedgroup;
    public Floor floor;

	public BedpageTest() throws IOException {
		super();
		
	}
	@BeforeMethod()
	public void Launchapplication() throws IOException {
		initlization();
		loginpage = new Loginpage();
	}
	@Test 
	public void verifyBedlink() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		bd=hpp.BedLink();
	   bed= bd.clickonBed();
	  String data= bed.checkpagetitle();
	Assert.assertEquals(data, "Bed List");
	}
	@Test 
	public void verifyBedTypelink() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		bd=hpp.BedLink();
		bedtype= bd.clickonbedtypelist();
	  String data= bedtype.Checkpagetitle();
	Assert.assertEquals(data, "Bed Type List");
	}
	@Test 
	public void verifyBedGrouplist() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		bd=hpp.BedLink();
		bedgroup= bd.BedGroupList();
	  String data= bedgroup.checkpagetitle();
	Assert.assertEquals(data, "Bed Group List");
	}
	@Test 
	public void verifyFloorlink() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		bd=hpp.BedLink();
		floor= bd.Floorlink();
	  String data= floor.checkpagetitle();
	Assert.assertEquals(data, "Floor List");
	}
	
	
	
	
	
}
