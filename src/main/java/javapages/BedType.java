package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kareclouds.page.Basepage;

public class BedType extends Basepage{

	public BedType() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath="//h3[normalize-space()='Bed Type List']")
    WebElement BedtypeList;
    
    @FindBy(xpath="//input[@placeholder='Search...']")
    WebElement searchbar;
    
    @FindBy(xpath="//a[normalize-space()='Standard']")
    WebElement searchdata;
    
    @FindBy(xpath="//a[@class='btn btn-primary btn-sm addbed']")
    WebElement Add;
    
    @FindBy(xpath="//input[@id='invoice_no']")
    WebElement Name;
    
    @FindBy(xpath="//button[@id='addbedtypebtn']")
    WebElement savebtn;
    
    
    public String Checkpagetitle() {
    	return BedtypeList.getText();
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
   public void formdetails(String name) {
   	
  	 Add.click();
  	Name.sendKeys(name);
  	 savebtn.click();
  	 
  	 
  }
   }