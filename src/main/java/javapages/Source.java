package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.WebSocket;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kareclouds.page.Basepage;

public class Source extends Basepage{

	public Source() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath="//h3[normalize-space()='Source']")
	WebElement source;
	
	@FindBy(xpath="//input[@placeholder='Search...']")
	WebElement searchbar;
	
	@FindBy(xpath="//td[@class='mailbox-name']")
	WebElement searchdata;
	
	@FindBy(xpath="//a[normalize-space()='Add Source']")
	WebElement Addsource;
	
	@FindBy(xpath="//input[@id='description']")
	WebElement sourcename;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement Description;
	
	@FindBy(xpath="//button[@id='formaddbtn']")
	WebElement savebtn;

	public String checkpagetitle() {
		
		return source.getText();
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
     public void formdetails(String name,String des) {
    	 Addsource.click();
    	 sourcename.sendKeys(name);
    	 Description.sendKeys(des);
    	 savebtn.click();
		
     }
     
}
