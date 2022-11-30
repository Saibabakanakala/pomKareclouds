package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kareclouds.page.Basepage;

public class Frontoffice extends Basepage{

	public Frontoffice() throws IOException {
		super();
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//h3[normalize-space()='Purpose List']")
	WebElement PurposeList;
	
	@FindBy(xpath="//input[@placeholder='Search...']")
	WebElement searchbar;
	
	@FindBy(xpath="//a[normalize-space()='Complain Type']")
	WebElement ComplainType;
	
	@FindBy(xpath="//a[normalize-space()='Source']")
	WebElement source;
	
	@FindBy(xpath="//a[normalize-space()='Appointment Priority']")
	WebElement Appointmentpriority;
	
	public String checkpagetitle() {
		return PurposeList.getText();
		
	}
	boolean flag;
	   public boolean searchfunction(String data) {
		   searchbar.sendKeys(data);
		List<WebElement> columsndata=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td"));
		for(WebElement ele:columsndata) {
			if(data.equalsIgnoreCase(ele.getText())) {
			flag=true;
	}    
			
	}
		return flag;
     
	   }
		 public ComplainType clickoncomplainType() throws IOException {
			 ComplainType.click();
			 ComplainType cl=new  ComplainType();
			 return cl;
	}
		 public  Source clickonsourcelink() throws IOException {
			 source.click();
			 Source src=new Source();
			 return src;
		 }
		 public Appointmentpriotity clickonAppointmentlink() throws IOException {
			 Appointmentpriority.click();
			 Appointmentpriotity apm=new Appointmentpriotity();
			 return apm;
}
}