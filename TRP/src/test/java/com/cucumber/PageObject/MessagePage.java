package com.cucumber.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagePage extends AbstractPage {

	public MessagePage(WebDriver driver) {
		super(driver);
	}

	public String getMessage() throws Exception{
		return driver.findElement(By.xpath("//div[@class='sapUiInPlaceMessage sapUiNotifierMessageText']")).getText();
	}
	
}
