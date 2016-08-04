package com.cucumber.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends AbstractPage {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public void logOnWithUser(String Usr, String Pwd) throws InterruptedException {
		WebElement user = driver.findElement(By.id("xs_username-inner"));
		user.sendKeys(Usr);

		WebElement pwd = driver.findElement(By.id("xs_password-inner"));
		pwd.sendKeys(Pwd);

		WebElement logon = driver.findElement(By.id("logon_button"));
		logon.click();

		Thread.sleep(10000);
	}

	public PlansPage navigateToPlansWoC() throws InterruptedException {
		WebElement allBtn = driver.findElement(By.id("__xmlview0--shell-wsBar-oflt"));
		allBtn.click();
		Thread.sleep(5000);
		driver.findElement(By.id("__item1-__xmlview0--shell-9-overflowItem-txt")).click();
		Thread.sleep(15000);
		return new PlansPage(driver);

	}

}
