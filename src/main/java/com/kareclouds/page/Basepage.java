package com.kareclouds.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {
	public static Properties prop;
	public static WebDriver driver;
	
public Basepage() throws IOException {
	prop=new Properties();
	FileInputStream fsi=new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\POMKARECLOUDS\\src\\main\\java\\com\\kareclouds\\configuration\\com.properties");
	prop.load(fsi);
	
}
public static void initlization() {
	String browsername=prop.getProperty("browser");
	System.out.println(browsername);
	if(browsername.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();

}else if(browsername.equalsIgnoreCase("Firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	
}
	

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get(prop.getProperty("url"));
}
	
	
	
	
	
	
}







