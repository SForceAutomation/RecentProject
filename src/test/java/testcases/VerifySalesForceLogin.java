package testcases;






import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.NewConsumerPage;
import Pages.SalesForceLoginPage;
import Pages.SindividualConsumerpage;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import lib.ExcelDataConfig;

//import lib.ExcelDataConfig;
//import lib.ExcelDataConfig;

public class VerifySalesForceLogin
{

	WebDriver driver;
	ExcelDataConfig config;
	int ran;
	@BeforeMethod
	public void setUP()
	{
		// driver=BrowserFactory.getBrowser("Chrome");
		 
		// driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		driver.get(" https://cs4.salesforce.com/app/mgmt/forceconnectedapps/forceAppDetail.apexp?applicationId=06P36000000UGpt&id=0CiP00000008Sq6");
	}
	
	
	@Test(dataProvider="testdata")
	public void testHomePage(String u,String p,String city,String state ,String Pstreet,String pcountry) throws InterruptedException
	{
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat(" MM/dd/HH:mm:ss");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		// System.out.println("Current date and time is " +date1);
		
		SalesForceLoginPage home=PageFactory.initElements(driver, SalesForceLoginPage.class);
		home.loginApplication(u,p);
		SindividualConsumerpage Arrow=PageFactory.initElements(driver, SindividualConsumerpage.class);
		
		Arrow.CreateButton();
		Arrow.ClickConsumer();
		Arrow.ClickConsumerType();
		Arrow.ClickOnContinue();
		
		NewConsumerPage information =PageFactory.initElements(driver, NewConsumerPage.class);
		information.Leadinformation("Selenium"+date1, "Testing","Eclipse");
		information.ContactInformation("name_middlelea2", "Automation");

        //Adding a Random phone Number 
        Random rndNum= new Random();    int rndNum1 = 1;

        for (int nbr = 1; nbr <= 1; nbr++) {
            rndNum1 = rndNum.nextInt();
            System.out.println("Number: " + rndNum1);    }
        
        information.ContactInformation("lea8", "6"+rndNum1);
        information.ContactInformation("lea9", "3"+rndNum1);
        information.ContactInformation("00N63000000XWYL", "AutomationTesting" + date1);
        
        
        //work email
        ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
        information.ContactInformation("00N63000000XWYQ", "work" + ran + "@test.com");
        information.ContactInformation("lea11", "personal" + ran + "@test.com");
       
        
        
		information.ContactInformation("lea16street", Pstreet);
		
		information.ContactInformation("lea16city", city);
		
		information.ContactInformation("lea16state", state);
		information.ContactInformation("lea16zip", "088691");
		
		information.ContactInformation("lea16country", "Yes");
		information.ContactInformation("00N63000000YAx2", pcountry);
        information.dateofbirthone("00N63000000XWY1");
         information.ActionDateLink();
         
       information.CorporateleadTrackingInformation("535353");
	   information.ProfessionalInformation(); 
	
	}
	
	
	
	
	
	
	
	@DataProvider(name="testdata")
	//public Object[][] passData()
	public Object[][] TestDataFeed(){
	{
		
		
		config = new ExcelDataConfig("C:\\Users\\t15juo8\\Desktop\\GitEclipse\\com.SalesForce.hybrid\\ApplicationTestData\\AppData.xlsx");
		
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
		
		//data[i-1][6] = config.getData(0,i,6);
		
		
		}
//=============================================================
		return data;
	
	}

	
	
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		// BrowserFactory.closeBrowser(driver);
	}
}



	

