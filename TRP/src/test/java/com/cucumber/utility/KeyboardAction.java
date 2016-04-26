package com.cucumber.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardAction {

	//http://www.51testing.com/html/18/631118-861557.html
	
	
	public static void clickEnter(WebDriver driver) throws Exception{
		
		// trigger enter from Keyboard
		Actions actionObject2 = new Actions(driver);
		actionObject2.sendKeys(Keys.ENTER).perform();
		util.delay(5);
		
	}

	
	public static void clickSpace(WebDriver driver) throws Exception{
		
		// trigger enter from Keyboard
		Actions actionObject2 = new Actions(driver);
		actionObject2.sendKeys(Keys.SPACE).perform();
		util.delay(5);
		
	}
	
	public static void refreshPage(WebDriver driver) throws Exception{
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();
		util.delay(5);
		
	}
	
	
	public static void closePage(WebDriver driver) throws Exception{
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.ALT).sendKeys(Keys.F4).keyUp(Keys.ALT).perform();
		util.delay(5);
		
	}
	
	public static void keysControlShiftAlt(WebDriver driver, int number) throws Exception{
		
		 Actions action = new Actions(driver); 
		 
		 switch(number){
			 case 1: action.keyDown(Keys.CONTROL);// 按下 Ctrl 键
			 break;
			 
			 case 2: action.keyDown(Keys.SHIFT);// 按下 Shift 键
			 break;
			 
			 case 3: action.keyUp(Keys.ALT);// 释放 Alt 键
			 break;
			 
			 default:System.out.println("only CONTROL, SHIFT AND ALT is supported");
		 }
		 
		util.delay(5);
	}
	
	public static void mouseClick(WebDriver driver, WebElement element) throws Exception{
		
		 Actions action = new Actions(driver);
		 action.click(element);// 鼠标左键点击指定的元素
	}
	
	
	
	public static void doubleClick(WebDriver driver, WebElement element) throws Exception{
		
		Actions action = new Actions(driver); 
		action.doubleClick(element);// 鼠标双击指定的元素
		util.delay(5);
	}

	public static void dragAndDropByTarget(WebDriver driver, WebElement source, WebElement target) throws Exception{
		
		 Actions action = new Actions(driver); 
			// 鼠标拖拽动作，将 source 元素拖放到 target 元素的位置。
			 action.dragAndDrop(source,target);

	}
	
	public static void dragAndDropByPoint(WebDriver driver, WebElement source, int xOffset, int yOffset) throws Exception{
		
		 Actions action = new Actions(driver); 
			// 鼠标拖拽动作，将 source 元素拖放到 (xOffset, yOffset) 位置，其中 xOffset 为横坐标，yOffset 为纵坐标。
			action.dragAndDropBy(source,xOffset,yOffset);

	}

	
	
	
	public static void multiClick(WebDriver driver, WebElement element) throws Exception{
		
		 Actions action = new Actions(driver); 
		 action.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).perform();
		 util.delay(5);

	}

	
}
