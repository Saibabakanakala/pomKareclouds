package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.kareclouds.page.Basepage;

public class Chargescategory extends Basepage {

	public Chargescategory() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
		
		
	}
	
    @FindBy(xpath="//h3[normalize-space()='Charge Category List']")
    WebElement chargecategoryList;
    
    @FindBy(xpath="//input[@placeholder='Search...']")
    WebElement searchbtn;
    
    @FindBy(xpath="//table[@id='DataTables_Table_0']/tbody/tr/td[contains(text(),'kare clouds')]")
    WebElement data;
     
    @FindBy(xpath="//a[normalize-space()='Add Charge Category']")
    WebElement Addchargecategorybtn;
    
    @FindBy(xpath="//input[@id='type']")
    WebElement Name;
    
    @FindBy(xpath="//form[@id='formadd']//textarea[@name='description']")
    WebElement Description;
    
    @FindBy(xpath="//form[@id='formadd']//select[@name='charge_type']")
    WebElement chargeType;
    
    @FindBy(xpath="//button[@id='formaddbtn']")
    WebElement savebtn;
    
    @FindBy(className="toast-message")
	WebElement successmes;
    
    
    
    public String pagetitle() {
    	return chargecategoryList.getText();
    	
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
         public void formdetails(String name,String des,String data) {
    	 Addchargecategorybtn.click();
    	 Name.sendKeys(name);
    	 Description.sendKeys(des);
    	 Select sel=new Select(chargeType);
    	 sel.selectByVisibleText(data);
    	 savebtn.click();
    	//return successmes.getText();
    	 
     }
     
}
