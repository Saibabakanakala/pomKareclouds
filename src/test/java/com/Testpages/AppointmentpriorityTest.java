package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.Appointmentpriotity;
import javapages.BedGroup;
import javapages.Bedpage;
import javapages.Frontoffice;
import javapages.Homepage;
import javapages.Loginpage;


public class AppointmentpriorityTest extends Basepage {
	public Homepage hpp;
	public Loginpage loginpage;
    public Bedpage bedpage;
    public BedGroup bedgrouppage;
    public Frontoffice off;
    public Appointmentpriotity app;
    


	public AppointmentpriorityTest() throws IOException {
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
		off=hpp.Frontofficelink();
        app =off.clickonAppointmentlink();
        
	    boolean result=app.searchfunction("Urgent");
	    Assert.assertEquals(result, true);

}
	 @Test 
	    public	 void verifyformdetails() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		off=hpp.Frontofficelink();
     app =off.clickonAppointmentlink();
     
	   app.clickonformdetails("Urgent");
	

}
}