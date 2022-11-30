package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.kareclouds.page.Basepage;

public class HospitalChargers extends Basepage {

	public HospitalChargers() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[normalize-space()='Charges Details']")
	WebElement chargesdetails;
	
	@FindBy(xpath="//a[normalize-space()='Add Charge']")
	WebElement Addchargebtn;
	
	@FindBy(xpath="(//select[@name='charge_type'])[1]")
	WebElement chargeType;
	
	@FindBy(xpath="//select[@id='charge_category']")
	WebElement chargecategory; 
	
	@FindBy(xpath="(//input[@name='code'])[1]")
	WebElement code;
	
	@FindBy(xpath="//input[@id='standard_charge']")
	WebElement standardcharge;
	
	@FindBy(xpath="//button[normalize-space()='Apply to all']")
	WebElement Applytoall;
	
	@FindBy(xpath="(//textarea[@name='description'])[1]")
	WebElement Description;
	
	@FindBy(xpath="//button[@id='formaddbtn']")
	WebElement savebtn;
	
	@FindBy(xpath="//div[@id='toast-container']//div[@class='toast-message']//p")
	WebElement errormessage;
	
	@FindBy(xpath="//input[@placeholder='Search...']")
	WebElement searchbar;
	
	@FindBy(xpath="//a[normalize-space()='Charge Category']")
	WebElement chargecategorylink;
	
	@FindBy(xpath="//a[normalize-space()='Doctor OPD Charge']")
	WebElement Doctoropdcharge;
	
	@FindBy(xpath="//a[normalize-space()='Charge Type']")
	WebElement chargeTypelink;
	
	
	
	public String formdetailswithemptyfield(String chargetype,String Code,String standardcharges,String des) throws InterruptedException {
		Addchargebtn.click();
		Thread.sleep(200);
		Select sel=new Select(chargeType);
		sel.selectByVisibleText(chargetype);
		code.sendKeys(Code);
		standardcharge.sendKeys(standardcharges);
		Applytoall.click();
		Description.sendKeys(des);
		savebtn.click();
		String mes=errormessage.getText();
		return mes;
	}
	
	
	public String pagetitle() {
		return chargesdetails.getText();
		
	}
	boolean flag;
	public boolean searchfunction(String data) {
		searchbar.sendKeys( data);
		List<WebElement> columsndata=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td"));
		for(WebElement ele:columsndata) {
			if(data.equalsIgnoreCase(ele.getText())) {
			flag=true;
		}
			
	}
		return flag;
	}
	public Chargescategory clickonchargecategory() throws IOException {
		chargecategorylink.click();
		Chargescategory chargescategory=new Chargescategory();
		return chargescategory;
	}
	public DoctorsOpdCharge clickondoctoropdcharge() throws IOException {
		Doctoropdcharge.click();
		DoctorsOpdCharge opd=new DoctorsOpdCharge();
	return opd;
	}
	public ChargeType clickonchargeType() throws IOException {
		 chargeTypelink.click();
		 ChargeType ct=new ChargeType();
		 return ct;
	}
}

    
