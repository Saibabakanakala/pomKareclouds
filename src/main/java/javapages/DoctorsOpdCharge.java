package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.kareclouds.page.Basepage;

public class DoctorsOpdCharge extends Basepage{

	public DoctorsOpdCharge() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h3[normalize-space()='Doctor OPD Charge']")
    WebElement checktitle;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchbtn;
	
	@FindBy(xpath="//td[normalize-space()='Sonia']")
	WebElement searchdetails;
	
	@FindBy(xpath="//a[normalize-space()='Add Charge']")
	WebElement Addchargebtn;
	
	@FindBy(xpath="//form[@id='formadd']//select[@name='doctor']")
	WebElement Doctotsearch;
	
	@FindBy(xpath="//input[@id='standard_charge']")
	WebElement standardcharge;
	
	@FindBy(xpath="//button[@class='plusign']")
	WebElement Applutoall;
	
	@FindBy(xpath="//button[@id='formaddbtn']")
	WebElement savebtn;
	
	public String pagetitle() {
		return checktitle.getText();
		
	}
	 boolean flag;
	    public boolean searchfunction(String data) {
	    	searchbtn.sendKeys(data);
	    	List<WebElement> columsndata=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td"));
			for(WebElement ele:columsndata) {
				if(data.equalsIgnoreCase(ele.getText())) {
	           flag=true;
}
				
				
			}
			return flag;
	    }

	   public void formdetails(String doc,String stand) {
		 
		   Addchargebtn.click();
		   Select sel=new Select(Doctotsearch);
		   sel.selectByVisibleText(doc);
		   standardcharge.sendKeys(stand);
		   Applutoall.click();
		   savebtn.click();
		   
	   }

				
}
				
				
