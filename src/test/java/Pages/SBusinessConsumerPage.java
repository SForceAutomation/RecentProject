package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SBusinessConsumerPage {

WebDriver driver;
	
	public SBusinessConsumerPage(WebDriver ldriver)
	{
		
		this.driver=ldriver;
	}
	
	
	@FindBy(id="createNewButton")  WebElement CreateNewButtonLink;
	
	@FindBy(linkText="Consumer")  WebElement ConsumerLink;
	
	//select consumer recortype 
	@FindBy(xpath="//option[contains(.,'Business')]") WebElement consumertype;
	
	
	
	
	public void CreateButton()
	{
		CreateNewButtonLink.click();
	}
	
	public void ClickConsumer()
	{
		ConsumerLink.click();
	}
	
	
}

