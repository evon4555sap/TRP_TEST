package com.cucumber.PageObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PlanCreationPage extends AbstractPage{

	public PlanCreationPage(WebDriver driver) {
		super(driver);
	}

	public PlanCreationPage setName(String Name){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = sdf.format(date);
		String newName = Name + "_" + str; 
		
		driver.findElement(By.xpath("//input[@class='sapUiTf sapUiTfBack sapUiTfBrd sapUiTfReq sapUiTfStd uppercase']")).sendKeys(newName);
		return new PlanCreationPage(driver);

	}


	public PlanCreationPage setDescription(String Description){
		driver.findElement(By.xpath("//input[@class='sapUiTf sapUiTfBack sapUiTfBrd sapUiTfStd']")).sendKeys(Description);
		return new PlanCreationPage(driver);
	}
	
	public PlanCreationPage setLocationFilter(String LocationFilter) throws Exception{
		driver.findElement(By.xpath("//*[@role='button'][@class='sapUiTfValueHelpIcon sapUiTfValueHelpRegularIcon']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@role='presentation'][@class='sapUiSearchFieldIco']")).click();
		driver.findElement(By.xpath("//*[@type='search'][@class='sapUiTf sapUiTfInner']")).sendKeys(LocationFilter);
		Actions actionObject1 = new Actions(driver);
		actionObject1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='sapUiTableRowHdr'][@title='Click to Select']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='OK'][@class='sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd']")).click();
		Thread.sleep(5000);
		return new PlanCreationPage(driver);
	}
	
	
	public PlanCreationPage setResourceFilter(String ResourceFilter) throws Exception{
		List<WebElement> valueHelp = driver.findElements(By.xpath("//*[@role='button'][@class='sapUiTfValueHelpIcon sapUiTfValueHelpRegularIcon']"));
		valueHelp.get(1).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@role='presentation'][@class='sapUiSearchFieldIco']")).click();
		driver.findElement(By.xpath("//*[@type='search'][@class='sapUiTf sapUiTfInner']")).sendKeys(ResourceFilter);
		Actions actionObject2 = new Actions(driver);
		actionObject2.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='sapUiTableRowHdr'][@title='Click to Select']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='OK'][@class='sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd']")).click();
		Thread.sleep(5000);
		return new PlanCreationPage(driver);
	}
	
	
	public PlanCreationPage clickAddButton() throws InterruptedException{
		driver.findElement(By.xpath("//button[text()='Add'][@role='button']")).click();
		Thread.sleep(5000);
		return new PlanCreationPage(driver);
	}
	
	public PlanCreationPage selectOneScheduledPlan(String ScheduledPlanName) throws Exception{
		driver.findElement(By.xpath("//*[@class='sapUiSearchFieldIco'][@role='presentation']")).click();
		driver.findElement(By.xpath("//*[@type='search'][@class='sapUiTf sapUiTfInner']")).sendKeys(ScheduledPlanName);
		Actions actionObject3 = new Actions(driver);
		actionObject3.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='sapUiTableRowHdr'][@title='Click to Select']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='OK'][@class='sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd']")).click();
		Thread.sleep(5000);
		return new PlanCreationPage(driver);
	}
	
	
	public MessagePage saveAndFinishCreation() throws Exception{
		driver.findElement(By.xpath("//button[text()='Save'][@class='sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd']")).click();
		Thread.sleep(5000);
		return new MessagePage(driver);
	}
	
	
}
