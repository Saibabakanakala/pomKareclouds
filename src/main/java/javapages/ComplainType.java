package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kareclouds.page.Basepage;

public class ComplainType extends Basepage {

	public ComplainType() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Complain Type']")
	WebElement complainType;
	
    @FindBy(xpath="//input[@placeholder='Search...']")
    WebElement searchbar;
    
    @FindBy(xpath="//a[normalize-space()='Food quality']")
    WebElement searchdata;
    
    @FindBy(xpath="//a[normalize-space()='Add Complain Type']")
    WebElement AddcomplainType;
    
    @FindBy(xpath="//input[@id='description']")
    WebElement cmp;
    
    @FindBy(xpath="//textarea[@id='description']")
    WebElement Description;
    
    @FindBy(xpath="//button[@id='formaddbtn']")
    WebElement savebtn;
	
	
	
	public String checkpagetitle() {
		return complainType.getText();
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
    public void clickonformdetails(String name,String des) throws IOException {
    	
    	AddcomplainType.click();
    	cmp.sendKeys(name);
    	Description.sendKeys(des);
    	savebtn.click();
	
    }
}
