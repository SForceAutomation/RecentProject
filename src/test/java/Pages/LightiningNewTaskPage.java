package Pages;

import java.util.List;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LightiningNewTaskPage {
	WebDriver driver;
	
	
	public LightiningNewTaskPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}	
	
    @FindBy(xpath ="//span[contains(.,'Subject')]/following::input[@class=input][maxlength=255]")  WebElement Subject;
    
	@FindBy( xpath ="//span[contains(.,'Due Date')]/following::input[1]") WebElement DueDate;
	@FindBy( xpath ="//span[contains(.,'Comments')]/following::input[1]") WebElement Comments;
	@FindBy( xpath ="//img[@title='Asset']") WebElement Relatedto;
	@FindBy( xpath ="//img[@alt='Consumer']") WebElement Name;
	@FindBy( xpath ="//a[@aria-label='Status']")WebElement Status;
	@FindBy( xpath ="//a[@aria-label='Priority']") WebElement Priority;
	@FindBy( xpath ="//button[@title='Cancel']") WebElement Cancel;
	@FindBy( xpath ="//button[@title='Save']") WebElement Save;
	
	
	public void other() throws InterruptedException
	{
	Subject.sendKeys("test");
	Comments.sendKeys("tet33");
		
	selectRandomInitial("//a[@aria-label='Status']");
	selectRandomInitial("//a[@aria-label='Priority']");
		Save.click();
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
	
	
	
	
}
