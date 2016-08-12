package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LightingPage {
	WebDriver driver;
	
	public LightingPage(WebDriver ldriver)
	{
		
		this.driver=ldriver;
	}
	
	@FindBy( xpath =".//*[@id='oneHeader']/div[2]/div[1]/div[1]/a") WebElement sidebar;
	
	@FindBy(xpath=("//li[@id='actionCard_Lead']/a/div/div[2]/div"))WebElement Action ;

	//@FindBy(xpath =("//div[@title='New']"))WebElement TabNew ;
	
	//@FindBy(xpath =("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']"))WebElement NextTab;

	
	
	 public void sidebarLink()
		{
		 sidebar.click();
		}
	
	
	
	 public void ActionDateLink()
		{
		 Action.click();
		 
		 driver.findElement(By.cssSelector("div[title=\"New\"]")).click();
			
			driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
				 
		
		
		}
	
	
	 
	 
	 
	 
	 
}
