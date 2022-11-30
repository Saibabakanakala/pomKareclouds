package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kareclouds.page.Basepage;

public class ChargeType extends Basepage {

	public ChargeType() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[@class='box-title titlefix']")
	WebElement checkpagetitle;
	
	@FindBy(xpath="//input[@type='search']")
    WebElement searchbtn;
	
	@FindBy(xpath="//td[normalize-space()='Supplier']")
	WebElement searchdata;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-sm charge_type']")
	WebElement AddchargeType;
	
	@FindBy(xpath="//input[@id='type']") 
	WebElement chargeType;
	
	@FindBy(xpath="//button[@id='formaddbtn']")
	WebElement savebtn;
	
	 public String pagetitle() {
	    	return checkpagetitle.getText();
	    
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
	    public void formdetails(String sai) {
	    	
	    	 AddchargeType.click();
	    	 chargeType.sendKeys(sai);
	    	 savebtn.click();
	    	 
	    	 
	    }
}
	    
	    
	    
	    
	    