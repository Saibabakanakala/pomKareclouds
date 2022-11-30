package javapages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.kareclouds.page.Basepage;

public class Bedpage extends Basepage {

	public Bedpage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='active']")
	WebElement bedstatus;
	
	@FindBy(xpath="//a[@href='http://kareclouds.com/admin/setup/bed']")
	WebElement Bed;
	
	@FindBy(xpath="//a[normalize-space()='Bed Type']")
	WebElement Bedtype;
	
	@FindBy(xpath="//a[normalize-space()='Bed Group']")
	WebElement Bedgroup;
	
	@FindBy(xpath="//a[normalize-space()='Floor']")
	WebElement floor;
		
	
	 public String pagetitle() {
	 return bedstatus.getText();
	    	
      }

	 public javapages.Bed clickonBed() throws IOException {
		 Bed.click();
		 Bed be=new Bed();
		 return be;
	 }
	 public BedType clickonbedtypelist() throws IOException {
		 Bedtype.click();
		 BedType bed=new BedType();
		 return bed;
	 }
	 public  BedGroup BedGroupList() throws IOException {
		 Bedgroup.click();
		 BedGroup bedgroup=new BedGroup();
		 return bedgroup;
	 }
	 public  Floor Floorlink() throws IOException {
		 floor.click();
		 Floor floorpage=new Floor();
		 return floorpage;
	 }
}	
	
	 
	 
	 
	 
