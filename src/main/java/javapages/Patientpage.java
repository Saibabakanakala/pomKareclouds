package javapages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kareclouds.page.Basepage;

public class Patientpage extends Basepage {

	public Patientpage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}
	String result;
//----------------------------page elements--------------------------------
	@FindBy(id = "addp")
	WebElement Addpatient;
	
	@FindBy(xpath = "//h3[@class='box-title titlefix']")
	WebElement PageTitle;
	
	@FindBy(xpath="//div[@id='DataTables_Table_0_filter']//input")
	WebElement searchbtn;
	
	@FindBy(linkText="Disabled Patient List")
	WebElement Disabledpatient;

	//--------------------------------form elements---------------------------------------------------------------
	@FindBy(id = "name")
	WebElement Name;

	@FindBy(xpath = "//div[@class='col-lg-6 col-md-6 col-sm-6']//input[@name='guardian_name']")
	WebElement gurdianname;

	// @FindBy(id = "addformgender")
	// WebElement gender;

	@FindBy(xpath = "//input[@id='birth_date']")
	WebElement Dateofbirth;

	@FindBy(id = "age_year")
	WebElement Year;

	@FindBy(id = "age_month")
	WebElement month;

	@FindBy(xpath = "//div[@class='col-sm-3']//select[@name='blood_group']")
	WebElement BloodGroup;

	@FindBy(xpath = "//*[@id=\"formaddpa\"]/div[1]/div/div/div/div/div[4]/div/div[2]/div/select")
	WebElement MaritalStatus;

	@FindBy(xpath ="//input[@id='file']")
	WebElement Patientphoto;

	@FindBy(id = "number")
	WebElement PhoneNumber;

	@FindBy(id="addformemail")
	WebElement Email;

	@FindBy(xpath ="//div[@class='col-lg-12 col-md-12 col-sm-12']//div[@class='row']//input[@name='address']")
	WebElement Address;

	@FindBy(xpath= "//textarea[@id='note']")
	WebElement Remarks;

	@FindBy(xpath= "//div[@class='col-lg-12 col-md-12 col-sm-12']//div[@class='row']//textarea[@name='known_allergies']")
	WebElement AnyKnownAllergies;

	@FindBy(xpath="//button[@id='formaddpabtn']")
	WebElement savebutton;

	@FindBy(className="toast-message")
	WebElement sucessbtn;
	@FindBy(id = "addformgender")
	WebElement gender;
	boolean flag = false;

	private String month1;

	private String day;

	
	public String checkpageTitle() {
		return PageTitle.getText();
	}


	public String enterFormDetails(String name, String Gurdianname, String Gender,String month1, String day, 
			String bloodgroup, String maritalStatus,String filepath,String no,String mail,String address,String remarks,String anyknown) {

		Addpatient.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(Name));
		Name.sendKeys(name);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOf(gurdianname));
		gurdianname.sendKeys(Gurdianname);
		Select sel = new Select(gender);
		sel.selectByVisibleText(Gender);
		Dateofbirth.click();	
		while (true) {
			String data = driver.findElement(By.xpath("//div[@class='datepicker-days']//table[@class='table table-condensed']//thead//tr//th[@class='datepicker-switch']")).getText();
			if (data.equalsIgnoreCase(month1)) {
				driver.findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[contains(text()," +day+")]")).click();
				break;
			}else {
			driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr/th[@class='prev']")).click();		
			}	
	}
	Select sel2 = new Select(BloodGroup);
	sel2.selectByVisibleText(bloodgroup);
	Select sel3 = new Select(MaritalStatus);
	sel3.selectByVisibleText(maritalStatus);
	Patientphoto.sendKeys(filepath);
	PhoneNumber.sendKeys(no);
	Email.sendKeys(mail); 
	Address.sendKeys(address);
	Remarks.sendKeys(remarks);
	AnyKnownAllergies.sendKeys(anyknown);
	savebutton.click();
	String mes=sucessbtn.getText();
	return mes;
	}
	
	
	public String searchFunction(String patientid) {
		searchbtn.sendKeys(patientid);
	String data=driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[text()="+patientid+"]")).getText();
		if(data.equalsIgnoreCase(patientid)) {
			System.out.println(data);
			
			result=data;
		}
		
		return result;
	}
		
	
	public javapages.Disabledpatient disabledpatient() throws IOException {
	Disabledpatient.click();
	Disabledpatient dp=new Disabledpatient();
	return dp;
	}
	
	
}