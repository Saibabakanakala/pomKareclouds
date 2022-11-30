package javapages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kareclouds.page.Basepage;

public class Homepage  extends Basepage{

	public Homepage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="logo-lg")
	WebElement logo;
	
	@FindBy(xpath="//span[contains(text(),'Setup')]")
	WebElement setup;
	
	@FindBy(xpath="//a[normalize-space()='Patient']")
	WebElement patientLink;
	
	@FindBy(xpath="//a[normalize-space()='Hospital Charges']")
	WebElement Hospitalcharges;
	
	@FindBy(xpath="//a[@href='http://kareclouds.com/admin/setup/bed/status'][normalize-space()='Bed']")
	WebElement Bed;
	
	@FindBy(xpath="//a[@href='http://kareclouds.com/admin/visitorspurpose']")
	WebElement Frontoffice;
	
    public boolean logocheck() {
      return logo.isDisplayed();
    }
    public Patientpage selectpatientLink() throws IOException {
    	Actions ac=new Actions(driver);
    	ac.moveToElement(setup).click().build().perform();
    	ac.moveToElement(patientLink).click().build().perform();
    	Patientpage patientpage=new Patientpage();
    	return patientpage;
    }
    public HospitalChargers HospitalLink() throws IOException {
    	Actions ac=new Actions(driver);
    	ac.moveToElement(setup).click().build().perform();
    	ac.moveToElement(Hospitalcharges).click().build().perform();
    	HospitalChargers hoc=new HospitalChargers();
    	return hoc;
    }
    public Bedpage BedLink() throws IOException {
    	Actions ac=new Actions(driver);
    	ac.moveToElement(setup).click().build().perform();
    	ac.moveToElement(Bed).click().build().perform();
    	Bedpage bp=new Bedpage();
    	return bp;
}
    public Frontoffice Frontofficelink () throws IOException {
    	Actions ac=new Actions(driver);
    	ac.moveToElement(setup).click().build().perform();
    	ac.moveToElement(Frontoffice).click().build().perform();
    	Frontoffice fo=new Frontoffice();
    	return fo;
    	
    }
    
}
    
    
      