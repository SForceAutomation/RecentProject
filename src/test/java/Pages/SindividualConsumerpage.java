package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SindividualConsumerpage {
WebDriver driver;
	
	public SindividualConsumerpage(WebDriver ldriver)
	{
		
		this.driver=ldriver;
	}
	
	
	@FindBy(id="createNewButton") WebElement CreateNewButtonLink;
	
	@FindBy(linkText="Consumer") WebElement ConsumerLink;
	
	//select consumer type 
	@FindBy(xpath="//option[contains(.,'Individual')]") WebElement consumertype;
	
	//click on continue 
	
	@FindBy(xpath=("(//input[@name='save'])[2]")) WebElement continuelink;
	
	
	public void CreateButton()
	{
		CreateNewButtonLink.click();
	}
	
	public void ClickConsumer()
	{
		ConsumerLink.click();
	}
	
	public void ClickConsumerType()
	{
		consumertype.click();
	}
	
	
	public void ClickOnContinue()
	{
		continuelink.click();
	}
	
	
	
}
