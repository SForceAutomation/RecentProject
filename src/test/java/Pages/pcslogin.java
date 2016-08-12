package Pages;


//import java.util.concurrent.TimeUnit;


//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class pcslogin {

	
	WebDriver driver;
	public  pcslogin(WebDriver  ldriver)
	{
		this.driver=ldriver;
		
	}
		
@FindBy(name="USER") WebElement username;

	
@FindBy(name="PASSWORD") WebElement password;

@FindBy(xpath ="//input[@value='Login']") WebElement loginbutton;

@FindBy(xpath="//button[@type='button']") WebElement button;
//@FindBy(xpath="//div[@id='bufferDiv']/ul/li[2]/a/span") WebElement button1;

public void loginApplication(String user,String pass)
{
	
	username.sendKeys(user);
	password.sendKeys(pass);
	loginbutton.click();
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.switchTo().frame("pcsWebFrame");
	button.click();
	//driver.switchTo().frame("pcsWebFrame");
	//button1.click();
	//assertTrue(closeAlertAndGetItsText().matches("^Show Past Due Activities[\\s\\S]$"));
}




public String getApplicationTitle()
{
	 return driver.getTitle();
}








}