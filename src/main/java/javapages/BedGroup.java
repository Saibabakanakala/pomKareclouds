package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.kareclouds.page.Basepage;

public class BedGroup extends Basepage {
	

	public BedGroup() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//h3[normalize-space()='Bed Group List']")
	WebElement BedGroupList;
	
	@FindBy(xpath="//input[@placeholder='Search...']")
	WebElement searchbar;
	
	@FindBy(xpath="//a[normalize-space()='VIP Ward']")
    WebElement searchdata;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-sm bedgroup']")
	WebElement Add;
	
	@FindBy(xpath="//form[@id='addward']//input[@name='name']")
	WebElement Name;
	
	@FindBy(xpath="//form[@id='addward']//select[@name='floor']")
	WebElement Floor;
	
	@FindBy(xpath="//form[@id='addward']//textarea[@name='description']")
	WebElement Description;
	
	@FindBy(xpath="//button[@id='addwardbtn']")
	WebElement savebtn;
	
	
	
	
	public String checkpagetitle() {
		return BedGroupList.getText();
				
		
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
	   public void formdetails(String name,String floor,String description) {
	   	
	  	 Add.click();
	  	Name.sendKeys(name);
	  	Select sel=new Select(Floor);
		 sel.selectByVisibleText(floor);
		 Description.sendKeys(description);
	  	 savebtn.click();
	  	 
	   }


}
