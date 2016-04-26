package com.cucumber.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlansPage extends AbstractPage{

	public PlansPage(WebDriver driver) {
		super(driver);
	}

	public PlansPage createNewPlan() throws Exception{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Create Plan')]")).click();
		return new PlansPage(driver);
	}
	

	
	public PlanCreationPage selectPlanType(String PlanType){
		driver.findElement(By.xpath("//div[text()='"+PlanType+"'][@class='sapUiMnuItmTxt']")).click();
		return new PlanCreationPage(driver);
	}
	

	
}
