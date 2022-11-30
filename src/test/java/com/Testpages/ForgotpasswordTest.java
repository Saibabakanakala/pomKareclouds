package com.Testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kareclouds.page.Basepage;

import javapages.Forgotpasswordpage;
import javapages.Loginpage;

public class ForgotpasswordTest extends Basepage{
	public Loginpage loginpage;
	public Forgotpasswordpage fpp;

	public ForgotpasswordTest() throws IOException {
		super();
		
	}
   @BeforeMethod                   
   public void Launchapplication() throws IOException {
	   initlization();
	   loginpage=new Loginpage();
	   fpp=new Forgotpasswordpage();
   }
   @Test
    public void verifyfppfunction() throws IOException {
	   fpp=loginpage.forgotfunction();
	   fpp.forgotfunction("sainaidukanakala@gmail.com");
   }
   @Test
   public void validationError() throws IOException {
	   fpp=loginpage.forgotfunction();
	   fpp.forgotfunction("sainaidukanakala@gmail.com");
	   String data=fpp.Errorvalidation();
	   Assert.assertEquals(data, "Incorrect Email");
	   
			   
   }
}
