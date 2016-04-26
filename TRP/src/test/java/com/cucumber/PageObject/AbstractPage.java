package com.cucumber.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractPage {

	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage navigateToTRP(){
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
    	driver.manage().window().maximize();
		driver.get("http://10.58.121.251:8000/sap/tm/trp/ui/#/home");
		return new LandingPage(driver);
	}
	
	
	public void closeDriver(){
		driver.quit();
	}
}
