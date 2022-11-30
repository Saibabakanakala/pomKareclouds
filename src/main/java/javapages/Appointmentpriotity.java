package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kareclouds.page.Basepage;

public class Appointmentpriotity extends Basepage {

	public Appointmentpriotity() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[normalize-space()='Appointment Priority List']")
	WebElement Appointmenttitle;
	
	@FindBy(xpath="//input[@placeholder='Search...']")
	WebElement searchbar;
	
	@FindBy(xpath="//a[normalize-space()='Add Priority']")
	WebElement Addpriority;
	
	@FindBy(xpath="//input[@id='appoint_priority']")
	WebElement Priority;
	
	@FindBy(xpath="//button[@id='formaddbtn']")
	WebElement savebtn;

	public String checkpagetitle() {
		// TODO Auto-generated method stub
		return Appointmenttitle.getText();
		
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
	   public void clickonformdetails(String priority) throws IOException {
	    	
		   Addpriority.click();
		   Priority.sendKeys(priority);
	    	
	    	savebtn.click();
		
	    }
    
}
