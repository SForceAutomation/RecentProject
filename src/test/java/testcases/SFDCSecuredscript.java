package testcases;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import lib.ExcelDataConfig;

//import lib.ExcelDataConfig;
//import lib.ExcelDataConfig;

public class SFDCSecuredscript
{

	WebDriver driver;
	ExcelDataConfig config;
	
	int user ;
	int Password;
	
	@BeforeMethod
	public void setUP()
	{
		 driver=BrowserFactory.getBrowser("Chrome");
		 
		 driver.get(DataProviderFactory.getConfig().getSecuredApplicationUrl());
		
	}
	
	
	
	@Test
	public void testHomePage() throws InterruptedException
	{
		
		String user = "";
		System.out.println("Enter the Username :");
		Scanner scomand = new Scanner(System.in);
		user = scomand .next();
		scomand .close();
		
		
		String Password = "";
		System.out.println("Enter the password :");
		Scanner Tcommand = new Scanner(System.in);
		Password = Tcommand.next();
		Tcommand.close();
		
		driver.findElement(By.id("username")).sendKeys(user);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//=============================================================
	
		WebElement consumerKey  =  driver.findElement(By.xpath("//span[@id='appsetup:setupForm:details:oauthSettingsSection:consumerKeySection:consumerKey']"));
		
		System.out.println( "ConsumerKey = "+ consumerKey.getText());
		
		//============================================================================
		//Click to Reveal 
		
		driver.findElement(By.xpath("//a[contains(.,'Click to reveal')]")).click();
		System.out.println("After click on the Click To Reveal : below is the consumersecret#");
		//============================================================================
			
		WebElement consumersecret = driver.findElement(By.xpath("//*[starts-with(@id,'ctrDiv')]"));
		System.out.println("ConsumerSecret= " + consumersecret.getText());
		
		//=======================================================================================
		WebElement SandboxCode = driver.findElement(By.xpath("//span[@class='pageMsg textOnly normalImportance']"));
		System.out.println("SandboxCode = " + SandboxCode.getText());
		
        
    }  
        
	
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}
}



	

