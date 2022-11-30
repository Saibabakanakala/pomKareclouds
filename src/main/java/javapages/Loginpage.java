package javapages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kareclouds.page.Basepage;

public class Loginpage extends Basepage {

	public Loginpage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
			}
	@FindBy(name="username")
    WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(className="btn")
	WebElement loginbtn;
	
	@FindBy(className="forgot")
	WebElement forgotbtn;
	
	@FindBy(className="alert-danger")
	WebElement invaliderrormessage;
	
	public Homepage loginfunction(String uname,String pass) throws IOException {
		username.clear();
		username.sendKeys(uname);
		password.clear();
		password.sendKeys(pass);
		loginbtn.click();
		Homepage homepage=new Homepage();
		return homepage;
		
	}
	public Forgotpasswordpage forgotfunction() throws IOException {
		forgotbtn.click();
		Forgotpasswordpage fpp=new Forgotpasswordpage();
		return fpp;
		
	}
	
	public String invaliderrormessage() {
		return invaliderrormessage.getText();
		
	}
	
}
