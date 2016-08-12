package Pages;


import java.util.List;



import java.util.Random;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.Calendar;
import java.util.GregorianCalendar;



public class NewConsumerPage {
	WebDriver driver;
	
	int dayOfYear;
	int year;
	
	public NewConsumerPage(WebDriver ldriver)
	{
		
		this.driver=ldriver;
	}
	
	
	// Lead Information 
    @FindBy(id ="name_firstlea2") WebElement Firstname;
	
	@FindBy(id="name_lastlea2") WebElement Lastname;

	@FindBy(id ="00N63000000XWYG") WebElement PrefferedName;
	
	@FindBy(id ="00N63000000YAx2") WebElement market;
	@FindBy(id ="00N63000000XWY1") WebElement DOB;
	@FindBy( xpath ="//a[@tabindex='9']") WebElement DateLink;
	
	@FindBy( xpath ="//input[@id='00N63000000YAx2']") WebElement Market;
	
	// 
	
	//
	//================================================
	
	
	 
	//=====================================
	public void Leadinformation (String First,String Last,String Prefred) throws InterruptedException
	{
		
		Firstname.sendKeys(First);
		Lastname.sendKeys(Last);
		
		PrefferedName.sendKeys(Prefred);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   //Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//name initial
		selectRandomInitial("name_salutationlea2");
		//gender
		selectRandomInitial("00N63000000XWY5");
		//ActionType
		selectRandomInitial("00N63000000XWXr");
		//LeadStatus
		selectRandomInitial("lea13");
		//source
		selectRandomInitial("lea5");
		//ContactInformation("00N63000000XWY1",));
		  
		
	}
	
	
	public void selectRandomInitial(String Name)throws InterruptedException
	 {
	 //Object of the Drop down list
	 WebElement drpDwnList = driver.findElement(By.id(Name));
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
	
	//=====================================
	
	public void ContactInformation(String idname,CharSequence uname)throws InterruptedException
	{
		driver.findElement(By.id(idname)).sendKeys(uname);
		
	}
	
	
	
	public void dateofbirthone(String Name)throws InterruptedException 
	
	{
        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1900, 2010);

        gc.set(Calendar.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
 // driver.findElement(By.id("00N63000000XWY1")).sendKeys(gc.get(Calendar.MONTH)+ 1 + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));
     driver.findElement(By.id(Name)).sendKeys(gc.get(Calendar.MONTH)+ 1 + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));       
       // System.out.println(gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH));
        System.out.println(gc.get(Calendar.MONTH) + 1 + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));
    
       
        
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
    public void ActionDateLink()
	{
    	DateLink.click();
	}
	
   

    
public void CorporateleadTrackingInformation(String ID)throws InterruptedException
	{
		driver.findElement(By.id("00N63000000XWYN'])")).sendKeys(ID);
        dateofbirthone("00N63000000XWYO");	 
		
	}


public void ProfessionalInformation()
	{
		driver.findElement(By.id("00N63000000XWY4")).sendKeys("FullTime");
		driver.findElement(By.id("00N63000000YAx7")).sendKeys("900000");
		driver.findElement(By.id("00N63000000XWY3")).sendKeys("NYLife");
		driver.findElement(By.id("00N63000000XWYE")).sendKeys("Architect");
		
		}
    

public void Relationshipformation(String idname,CharSequence uname)throws InterruptedException
{
	driver.findElement(By.id(idname)).sendKeys(uname);
	
}


public void Additionalinformation(String idname,CharSequence uname)throws InterruptedException
{
	driver.findElement(By.id(idname)).sendKeys(uname);
	
}
    
	
}
