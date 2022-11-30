package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.kareclouds.page.Basepage;

public class Bed extends Basepage {

	public Bed() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[normalize-space()='Bed List']")
	WebElement pagetitle;
	
	@FindBy(xpath="//input[@placeholder='Search...']")
	WebElement searchbar;
	
		@FindBy(xpath="//a[normalize-space()='test']")
	WebElement searchdata;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-sm addbed']")
	WebElement Add;
	
	@FindBy(xpath="//div[@class='row']//input[@name='name']")
	WebElement Name;
	
	@FindBy(xpath="//select[@id='bed_type']")
	WebElement Bedtype;
	
	@FindBy(xpath="//select[@id='bed_group']")
	WebElement Bedgroup;
	
	@FindBy(xpath="//button[@id='addbedbtn']")
	WebElement savebtn;
	
	
   public String checkpagetitle() {
	   return pagetitle.getText();
	   
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
 public void formdetails(String name,String Data,String data) {
	 Add.click();
	 Name.sendKeys(name);
	 Select sel=new Select(Bedtype);
	 sel.selectByVisibleText(Data);
	 Select sele=new Select(Bedgroup);
	 sele.selectByVisibleText(data);
	 savebtn.click();

 }

	
}




   