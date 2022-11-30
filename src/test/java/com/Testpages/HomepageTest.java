package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.Bedpage;
import javapages.Frontoffice;
import javapages.Homepage;
import javapages.HospitalChargers;
import javapages.Loginpage;
import javapages.Patientpage;

public class HomepageTest extends Basepage {
	public Homepage hpp;
	public Loginpage loginpage;
	public Patientpage patientpage;
	public Bedpage bedpage;
    public HospitalChargers hospitalcharges;
    public Frontoffice frontoffice;
	public HomepageTest() throws IOException {
		super();

	}

	@Test
	public void clickonselectpatietlink() throws IOException {
		hpp = loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		patientpage= hpp.selectpatientLink();
		String result = patientpage.checkpageTitle();
		Assert.assertEquals(result, "Patient List");
	}

	@BeforeMethod()
	public void Launchapplication() throws IOException {
		initlization();
		loginpage = new Loginpage();
	}
  @Test
  public void clickonHospitalcharges() throws IOException {
	  hpp = loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
	  hospitalcharges= hpp.HospitalLink();
	 String data= hospitalcharges.pagetitle();
	 Assert.assertEquals(data,"Charges Details");
  }
  @Test
	public void clickonBedlink() throws IOException {
		hpp = loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
		bedpage = hpp.BedLink();
		String result = bedpage.pagetitle();
		Assert.assertEquals(result, "Bed Status");
	}
  @Test
 	public void clickonFrontofficelink() throws IOException {
 		hpp = loginpage.loginfunction("superadmin@gmail.com", "Admin@123");
 		frontoffice = hpp.Frontofficelink();
 		String result = frontoffice.checkpagetitle();
 		Assert.assertEquals(result, "Purpose List");
  
}
}
