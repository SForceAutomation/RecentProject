
package testcases;




//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.pcslogin;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyPcsLoginpageTest
{

	
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest   logger;
	
	
	@BeforeMethod
	
	public void setUP()
	{
		 
		 report=new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		 
		 logger=report.startTest("Verify Test Login");
		 
		 driver=BrowserFactory.getBrowser("Chrome");
		 
		 driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		 
		 logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testHomePage()
	{
	
	 
	 //home.clickOnSigninLink();
	 
	 pcslogin login=PageFactory.initElements(driver, pcslogin.class);
	 
       	
	 login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	 
	 String title=login.getApplicationTitle();
	 System.out.println(title);
	 
	}
	
	

	@AfterMethod
	public void tearDown()
	{
		 BrowserFactory.closeBrowser(driver);
	}
	
	
}
