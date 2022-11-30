package javapages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kareclouds.page.Basepage;

public class Disabledpatient extends Basepage {

	public Disabledpatient() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[contains(text(),'Disabled Patient List ')]")
	WebElement PageTitle;

	public String checkPageTitle() {
	return PageTitle.getText();
	}
}
