package com.cucumber.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class util {



	// print message
	public static void message(String string) throws Exception {
		System.out.println(string);
		System.out.println("for test");
	}

	// click button and wait for seconds
	public static void clickAndWait(WebElement element, int seconds)
			throws Exception {
		try {
			element.click();
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// direct delay for seconds
	public static void delay(int seconds) throws Exception {
		try {
			System.out.println("wait " + seconds + " seconds");
			Thread.sleep(seconds * 2 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// get webElmement by ID, name, xpath
	public static WebElement getElement(WebDriver driver, String type,
			String value) throws Exception {
		try {
			WebElement element;

			if (type.toUpperCase().equals("ID")) {
				element = driver.findElement(By.id(value));
				return element;
			} else if (type.toUpperCase().equals("NAME")) {
				element = driver.findElement(By.name(value));
				return element;
			} else if (type.toUpperCase().equals("XPATH")) {
				element = driver.findElement(By.xpath(value));
				return element;
			} else if (type.toUpperCase().equals("CLASS")) {
				element = driver.findElement(By.className(value));
				return element;
			} else if (type.toUpperCase().equals("PARTLINK")) {
				element = driver.findElement(By.partialLinkText(value));
				return element;
			} else if (type.toUpperCase().equals("TEXT")) {
				String value2 = "//*[text()='" + value + "']";
				element = driver.findElement(By.xpath(value2));
				return element;
			} else {
				util.message("input type or value is not correct");
				return null;
			}

		} catch (Exception e) {
			System.out.println("Cannot find element, time out");
			return null;

		}

	}

	// get webElmement by ID, name, xpath
	public static List<WebElement> getElementList(WebDriver driver,
			String type, String value) throws Exception {
		try {
			List<WebElement> elementList;

			if (type.toUpperCase().equals("IDLIST")) {
				elementList = driver.findElements(By.id(value));
				return elementList;
			} else if (type.toUpperCase().equals("NAMELIST")) {
				elementList = driver.findElements(By.name(value));
				return elementList;
			} else if (type.toUpperCase().equals("XPATHLIST")) {
				elementList = driver.findElements(By.xpath(value));
				return elementList;
			} else if (type.toUpperCase().equals("CLASSLIST")) {
				elementList = driver.findElements(By.className(value));
				return elementList;
			} else if (type.toUpperCase().equals("PARTLINKLIST")) {
				elementList = driver.findElements(By.partialLinkText(value));
				return elementList;
			} else if (type.toUpperCase().equals("TEXTLIST")) {
				String value2 = "//*[text()='" + value + "']";
				elementList = driver.findElements(By.xpath(value2));
				return elementList;
			} else {
				util.message("input type or value is not correct");
				return null;
			}



		} catch (Exception e) {
			System.out.println("Cannot find element, time out");
			return null;

		}
	}

	// get webElmement list by class
	public static String getElementTitleByClass(WebDriver driver,
			String className, int number) throws Exception {
		try {
			List<WebElement> itemList = driver.findElements(By
					.className(className));
			String item = itemList.get(number).getAttribute("title");

			return item;
		} catch (Exception e) {
			System.out.println("Cannot find element, time out");
			return null;

		}
	}

	// change Location filter with name
	public static void changeLocationWithName(WebDriver driver,
			String locationName) throws Exception {
		try {
			util.clickElementByClassAndIndex(driver, "sapUiTfValueHelpIcon", 0);
			util.delay(35);
			util.clickElementByClassAndIndex(driver, "sapUiSearchFieldIco", 0);
			util.getElement(driver, "CLASS", "sapUiTf").sendKeys(locationName);
			KeyboardAction.clickEnter(driver);

			// util.getElement(driver, "XPATH",
			// "//*[@id='__xmlview2--container--locationFilterValueHelpDialog--table-rowsel0']").click();
			util.clickElementByClassAndIndex(driver, "sapUiTableRowHdr", 0);

			util.clickElementByClassAndIndex(driver, "sapUiBtnNorm", 0);
			util.delay(15);
		} catch (Exception e) {
			System.out.println("Cannot find element, time out");
		}
	}

	// change resource filter with name
	public static void changeResourceWithName(WebDriver driver,
			String resourceFilter) throws Exception {
		try {
			util.clickElementByClassAndIndex(driver, "sapUiTfValueHelpIcon", 1);
			util.delay(35);
			util.clickElementByClassAndIndex(driver, "sapUiSearchFieldIco", 0);
			util.getElement(driver, "CLASS", "sapUiTf")
					.sendKeys(resourceFilter);
			KeyboardAction.clickEnter(driver);
			util.clickElementByClassAndIndex(driver, "sapUiTableRowHdr", 0);
			util.clickElementByClassAndIndex(driver, "sapUiBtnNorm", 0);
			util.delay(15);
		} catch (Exception e) {
			System.out.println("Cannot find element, time out");

		}
	}

	// change multi-attribute filter
	public static void multiAttributeWithName(WebDriver driver,
			String multAttributeName) throws Exception {
		try {
			util.clickElementByClassAndIndex(driver, "sapUiTfValueHelpIcon", 2);
			util.delay(15);
			util.clickElementByClassAndIndex(driver, "sapUiSearchFieldIco", 0);
			util.getElement(driver, "CLASS", "sapUiTf").sendKeys(
					multAttributeName);
			KeyboardAction.clickEnter(driver);
			util.clickElementByClassAndIndex(driver, "sapUiTableRowHdr", 0);
			util.clickElementByClassAndIndex(driver, "sapUiBtnNorm", 0);
			util.delay(15);
		} catch (Exception e) {
			System.out.println("Cannot find element, time out");

		}
	}

	// click class item by index
	public static void clickElementByClassAndIndex(WebDriver driver,
			String className, int number) throws Exception {
		try {
			List<WebElement> itemList = driver.findElements(By
					.className(className));
			WebElement item = itemList.get(number);
			item.click();
			util.delay(5);

		} catch (Exception e) {
			System.out.println("Cannot find element, time out");

		}

	}

	// click class item by index
	public static WebElement getElementByClassAndIndex(WebDriver driver,
			String className, int number) throws Exception {
		try {
			List<WebElement> itemList = driver.findElements(By
					.className(className));
			WebElement item = itemList.get(number);

			return item;
		} catch (Exception e) {
			System.out.println("Cannot find element, time out");
			return null;

		}
	}

	public static String inputNumberPlusOne(String number) throws Exception {
		try {
			int num = Integer.parseInt(number);
			int newNum = num + 1;
			String stockNew = Integer.toString(newNum);

			return stockNew;
		} catch (Exception e) {

			System.out.println("Cannot find element, time out");
			return null;

		}
	}

	public static String getItemNumber(String string) throws Exception {
		try {
			int start = string.indexOf("(");
			int end = string.indexOf(")");
			String number = string.substring(start + 1, end);
			return number;
		} catch (Exception e) {
			System.out.println("Cannot find element, time out");
			return null;

		}
	}

	public static String getCurrentTime() throws Exception {
		try {
			Date date = new Date();// create a time object and get current time
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");// set time format
			String str = sdf.format(date);// change type of time to required type
			return str;
		} catch (Exception e) {
			System.out.println("Cannot find element, time out");
			return null;

		}
	}

}