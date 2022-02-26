package PagesPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZProjectShopPage 
{
	@FindBy(xpath="//a[text()='Home']") private WebElement HomeLink;
	
	
	public ZProjectShopPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void ClickOnHomeLink()
	{
		HomeLink.click();
	}
	
	
	
	
	
	
	
	
}
