package javapages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kareclouds.page.Basepage;

public class Forgotpasswordpage extends Basepage{

	public Forgotpasswordpage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="form-username")
	WebElement ForgotEmail;
	
	@FindBy(className="btn")
	WebElement submitbtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement errormessage;
	

public void forgotfunction(String email) {
	ForgotEmail.sendKeys(email);
	submitbtn.click();
     
}
public String Errorvalidation() {
	return errormessage.getText();
	

}

}
