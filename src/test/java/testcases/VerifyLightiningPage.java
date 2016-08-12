package testcases;








import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LightingNewConsumer;
import Pages.LightingPage;
import Pages.LightiningNewTaskPage;
import Pages.SalesForceLoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import lib.ExcelDataConfig;


public class VerifyLightiningPage
{

	WebDriver driver;
	ExcelDataConfig config;
	
	int ran;
	@BeforeMethod
	public void setUP()
	{
		 driver=BrowserFactory.getBrowser("Chrome");
		 
		 driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test(dataProvider="testdata")
	public void verifylogin(String u,String p,String city,String state ,String Pstreet,String pcountry) throws InterruptedException
	{
		SalesForceLoginPage home=PageFactory.initElements(driver, SalesForceLoginPage.class);
		home.loginApplication(u,p);
		
		//LightingPage home1=PageFactory.initElements(driver, LightingPage.class);
		
		//home1.sidebarLink();
		//home1.ActionDateLink();
		//LightiningNewTaskPage TNew = PageFactory.initElements(driver, LightiningNewTaskPage.class);
		
		//driver.findElement(By.xpath("//a[@alt='Toggle SideBar']")).click();
		//driver.findElement(By.xpath("//li[@id='actionCard_Task']/a/div/div[2]/div")).click();
		
			
		//driver.findElement(By.xpath("//button[@data-action='NewTask']")).click();
		
		//driver.findElement(By.xpath("//span[starts-with(.,'Subject')]/following::input[@class='input'][@maxlength='255']")).
			
		//driver.findElement(By.xpath("//span[contains(.,'Subject')]")).isDisplayed();
		//driver.findElement(By.xpath("//span[contains(.,'Subject')]")).sendKeys("test");
		
		//driver.findElement(By.xpath("//span[contains(.,'Subject')]/following::input[@class='input'][@maxlength='255']")).isDisplayed();
		
		//TNew.other();
		
	
		 LightingNewConsumer  NConsumer =PageFactory.initElements(driver, LightingNewConsumer.class);
		
		 driver.findElement(By.xpath("//a[@alt='Toggle SideBar']")).click();
		 driver.findElement(By.xpath("//li[@id='actionCard_Lead']/a/div/div[2]/div")).click();
		 driver.findElement(By.cssSelector("div[title=\"New\"]")).click();
			
			driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		 
		NConsumer.CreateNew();
		
		NConsumer.DropDownlistItem();
		NConsumer.ContactInformation(Pstreet, city, state, pcountry);
		NConsumer.ProfessionalInformation();
		NConsumer.Relationshipinformation();
		NConsumer.other();
		
		NConsumer.saveNew();
		
		
		
	}
	
	
	
	



	
	
	
	
	
	
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed(){
		{
			
			
			
				
			
			
			File fileObj = new File("ApplicationTestData\\AppData.xlsx");
			String dirPath = fileObj.getAbsolutePath();
			System.out.println(dirPath);
			
			//ExcelDataConfig input = null;;
			config = new ExcelDataConfig(dirPath);
			
			//config = new ExcelDataConfig("C:\\Users\\t15juo8\\Desktop\\GitEclipse\\com.SalesForce.hybrid\\ApplicationTestData\\AppData.xlsx");
			
			//int rows = config.getRowCount(0);
			int rows = 2;
			Object[][] data = new Object[rows-1][6];
			for(int i=1 ;i<rows;i++)
				
			{

			data[i-1][0]= config.getData(0,i,0);
			data[i-1][1] = config.getData(0,i,1);
			
			data[i-1][2] = config.getData(0,i,2);
			data[i-1][3] = config.getData(0,i,3);
			
			data[i-1][4] = config.getData(0,i,4);
			
			data[i-1][5] = config.getData(0,i,5);
			
			}
	//=============================================================
			return data;
		
		}
	
	
	
	
	
	
	
	
}
}