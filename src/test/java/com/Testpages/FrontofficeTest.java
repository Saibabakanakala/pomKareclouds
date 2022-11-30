package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.Appointmentpriotity;
import javapages.ComplainType;
import javapages.Frontoffice;
import javapages.Homepage;
import javapages.Loginpage;
import javapages.Source;

public class FrontofficeTest extends Basepage {
	public Homepage hpp;
	public Loginpage loginpage;
    public Frontoffice frontofficepage;
    public ComplainType complaintype;
    public Source source;
    public Appointmentpriotity app;

	public FrontofficeTest() throws IOException {
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
		frontofficepage=hpp.Frontofficelink();
	    boolean result=frontofficepage.searchfunction("Visit");
	    Assert.assertEquals(result, true);
	}
	 @Test 
	    public void verifycomplaintypelink() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		frontofficepage=hpp.Frontofficelink();
		complaintype=frontofficepage.clickoncomplainType();
		 String result=complaintype.checkpagetitle();
	    Assert.assertEquals(result, "Complain Type List");

}
	 @Test 
	    public void verifysourcepagelink() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		frontofficepage=hpp.Frontofficelink();
		source=frontofficepage.clickonsourcelink();
		String result=source.checkpagetitle();
	    Assert.assertEquals(result, "Source");
         
	 }
	 @Test 
	    public void verifyAppointmentlink() throws IOException {
		hpp=loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		frontofficepage=hpp.Frontofficelink();
		app=frontofficepage.clickonAppointmentlink();
		String result=app.checkpagetitle();
	    Assert.assertEquals(result, "Appointment Priority List");
      
	 }
}
