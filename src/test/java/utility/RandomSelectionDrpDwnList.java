package utility;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RandomSelectionDrpDwnList {
	
	WebDriver driver;
	public void selectRandom()
	 {
	 //Object of the Dropdownlist
	 WebElement drpDwnList = driver.findElement(By.xpath(".//*[@id='drpdwnTopics']"));
	 //Using FindElements to create a List object
	 //List <WebElement> weblist = driver.findElements(By.xpath(".//*[@id='drpdwnTopics']/option"));
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
