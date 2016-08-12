package Pages;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LightingNewConsumer {
	WebDriver driver;
	int ran;
	
	public LightingNewConsumer(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy( xpath ="//a[@aria-label='Salutation']") WebElement Salutation;
	@FindBy( xpath ="//h2[contains(.,'Create Consumer')]/following::input[6]") WebElement Actiondate;
	@FindBy( xpath ="//input[@placeholder='First Name']") WebElement FirstName;
	@FindBy( xpath ="//input[@placeholder='Middle Name']") WebElement MiddleName;
	@FindBy( xpath ="//input[@placeholder='Last Name (required)']") WebElement LastName;
	@FindBy( xpath ="//h2[contains(.,'Create Consumer')]/following::input[4]")WebElement phone;
	@FindBy(xpath ="//input[contains(@placeholder,'Search Relationships')]") WebElement Centerofinfulence;
    @FindBy(xpath ="//span[contains(.,'Sub Source')]/following::textarea[1]") WebElement Subsource;
    @FindBy(xpath ="//a[@aria-label='Source']") WebElement Source;
    @FindBy(xpath ="//a[@aria-label='Action Type']") WebElement ActionType;
    @FindBy(xpath ="//a[@aria-label='Lead Status']") WebElement LeadStatus;
    @FindBy(xpath ="//h2[contains(.,'Create Consumer')]/following::input[5]") WebElement PersonalEmail;
    
    // Company Information 
    
    
    @FindBy(xpath ="//h3[contains(.,'Company Information')]/following::input[1]") WebElement Company;
    @FindBy(xpath ="//h3[contains(.,'Company Information')]/following::input[1]") WebElement NumberofEmployees;
    @FindBy(xpath ="//a[@aria-label='Industry']") WebElement Industry;
    @FindBy(xpath ="//a[@aria-label='Annual Revenue']") WebElement AnnualRevenue;

    // Contact Information
    
    @FindBy(xpath ="//h3[contains(.,'Contact Information')]/following::input[1]") WebElement Mobilephone;
    @FindBy(xpath ="//h3[contains(.,'Contact Information')]/following::input[3]") WebElement Workemail;
    @FindBy(xpath ="//h3[contains(.,'Contact Information')]/following::textarea[1]") WebElement Besttimetocall;
    @FindBy(xpath ="//span[contains(.,'Newsletter Recipient')]/following::input[@type='checkbox']") WebElement Recipient;

    
    // Address 
    
   
    @FindBy( xpath ="//textarea[@placeholder='Street']") WebElement EnterStreet;
    @FindBy( xpath ="//input[@placeholder='City']") WebElement Entercity;
    @FindBy( xpath ="//input[@placeholder='State']") WebElement EnterState;
    @FindBy( xpath ="//input[@placeholder='Zip/Postal Code']") WebElement EnterZipcode;
	@FindBy( xpath ="//input[@placeholder='Country']") WebElement Entercountry;
	
	
	//Buttons 
	
	@FindBy( xpath ="//button[@title='Save']") WebElement Save;
	@FindBy( xpath ="//button[@title='Cancel']") WebElement Cancel;


DateFormat dateFormat = new SimpleDateFormat(" MM/dd/HH:mm:ss");
Date date = new Date();
// Now format the date
String date1= dateFormat.format(date);
	
	public void CreateNew() throws InterruptedException
	{
	    FirstName.sendKeys("Selenium"+date1, "Testing","Eclipse");	
		MiddleName.sendKeys("name_middlelea2", "Automation");
		LastName.sendKeys("AutomationTesting" + date1);
		
		Subsource.sendKeys("Automation");
		//Market.sendKeys("test");
		//Relationships.sendKeys("relation");
		Subsource.sendKeys("subsource");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   //Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//dateofbirthone("//a[contains(@aria-label,'Gender')]/Preceding::input[1]");
		  
	}
	
	
	public void DropDownlistItem()throws InterruptedException
	{
		//gender
               // Action Type 
		
		selectRandomInitial("//a[@aria-label='Gender']");
                // lead status 
		selectRandomInitial("//a[@aria-label='Lead Status']");
		
               // source 
		selectRandomInitial("//a[@aria-label='Source']");
	}

public void ContactInformation(String Pstreet,String city,String state,String pcountry )
	{
	//Adding a Random phone Number 
    Random rndNum= new Random();    int rndNum1 = 1;

    for (int nbr = 1; nbr <= 1; nbr++) {
        rndNum1 = rndNum.nextInt();
        System.out.println("Number: " + rndNum1);    }
	
    Mobilephone.sendKeys("42424245");
	//Phone.sendKeys("6"+rndNum1);
	Besttimetocall.sendKeys("3"+rndNum1);

	 ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	PersonalEmail.sendKeys("Personal" + ran + "@test.com");

	Workemail.sendKeys("work" + ran + "@test.com");

	//SearchAddress.click();

	EnterStreet.sendKeys(Pstreet +ran);

	Entercity.sendKeys(city);

	EnterState.sendKeys(state);

	EnterZipcode.sendKeys("08869");

	Entercountry.sendKeys(pcountry);



		}


public void ProfessionalInformation()
	{
	
	Random rndNum= new Random();    int rndNum1 = 1;

    for (int nbr = 1; nbr <= 1; nbr++) {
        rndNum1 = rndNum.nextInt();
        System.out.println("Number: " + rndNum1);    }
	
    Company.sendKeys("FullTime");
    Industry.sendKeys("Nylife");
NumberofEmployees.sendKeys("6"+rndNum);



		}


public void Relationshipinformation()throws InterruptedException
	{
		
	//Maritalstatus.sendKeys("Married");
	
   //SpouseName.sendKeys("stest"+date1 );
 
   dateofbirthone("//h2[contains(.,'Create Consumer')]/following::input[4]");
	
		}

public void other()
	{
		
        // sub source 
	Subsource.sendKeys("source" +date1);
       // center of influence 
	
      
		}




public void selectRandomInitial(String Name)throws InterruptedException
{
//Object of the Drop down list
WebElement drpDwnList = driver.findElement(By.xpath (Name));
//Using FindElements to create a List object
//List <WebElement> web list = driver.findElements(By.xpath(".//*[@id='drpdwnTopics']/option"));
//Using Select Class to fetch the count
Select objSel = new Select(drpDwnList);
List <WebElement> weblist = objSel.getOptions();
//Taking the count of items
int iCnt = weblist.size();
//Using Random class to generate random values
Random num = new Random();
int iSelect = num.nextInt(iCnt);
//Selecting value from DropDownList
objSel.selectByIndex(iSelect);
//Selected Value
System.out.println(drpDwnList.getAttribute("value"));
}
	
	




public void dateofbirthone(String Name)throws InterruptedException 

{
    GregorianCalendar gc = new GregorianCalendar();

    int year = randBetween(1900, 2010);

    gc.set(Calendar.YEAR, year);

    int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

    gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
// driver.findElement(By.id("00N63000000XWY1")).sendKeys(gc.get(Calendar.MONTH)+ 1 + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));
 driver.findElement(By.xpath(Name)).sendKeys(gc.get(Calendar.MONTH)+ 1 + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));       
   // System.out.println(gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH));
    System.out.println(gc.get(Calendar.MONTH) + 1 + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));

   
    
}
public static int randBetween(int start, int end) {
    return start + (int)Math.round(Math.random() * (end - start));
}


	
public void saveNew()
{
	//save.click();
	}


//button[@title='Save']

	
}






