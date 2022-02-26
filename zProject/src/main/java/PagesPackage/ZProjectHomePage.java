package PagesPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZProjectHomePage 
{
	int count;
	@FindBy(xpath="//a[text()='Shop']") private WebElement ShopLink;
	@FindBy(xpath="/a[text()='My Account']") private WebElement MyAccountLink;
	@FindBy(xpath="//ul[@class='products']//li") private List<WebElement> NewArrivalsLink;
	@FindBy(xpath="//link[contains(text(),'slider')]") private List<WebElement> Sliders;
	
	
	
	public ZProjectHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void ClickOnShopLink()
	{
		ShopLink.click();
	}
	
	public void ClickOnMyAccountLink()
	{
		MyAccountLink.click();
	}
	
	public List<WebElement>  ListOfNewArrivalsLink()
	{
		return NewArrivalsLink;
	
	}
	
	public int CountSliders()
	{
		for(WebElement slider : Sliders)
		{
			count++;
		}
		return count;
	}
	
}
