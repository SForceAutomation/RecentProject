package Pages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SalesForceLoginPage {

	
	
	WebDriver driver;
	
	public SalesForceLoginPage(WebDriver ldriver)
	{
		
		this.driver=ldriver;
	}
	
	@FindBy(id ="username") WebElement username;
	
	@FindBy(id="password") WebElement password;

	@FindBy(id ="Login") WebElement LoginButton;
	
	//@FindBy(linkText ="Logout") WebElement LogoutButton;
	By signout= By.linkText("Logout");
	
	
	public void loginApplication(String user,String pass) throws InterruptedException
	{
		
		username.sendKeys(user);
		
		password.sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   //Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginButton.click();
	
	}
	
	
	public void verifySignOutLink()
	{
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(signout));	
		
		String text=ele.getText();
		
		Assert.assertEquals(text, "Sign Out","Sign out link not verified properly");
	}


	
	
	
	
}
