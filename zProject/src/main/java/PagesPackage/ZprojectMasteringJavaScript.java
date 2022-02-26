package PagesPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZprojectMasteringJavaScript 
{
	@FindBy(xpath="//a[text()='Description']") private WebElement DescriptionLink;
	@FindBy(xpath="//a[contains(text(),'Reviews')]") private WebElement ReviewsLink;
	@FindBy(xpath="//button[@type='submit']") private WebElement addToKartBtn;
	@FindBy(xpath="//img[@title='Mastering JavaScript']") private WebElement Booklogo;
	@FindBy(xpath="//div[@id='tab-description']//h2") private WebElement BookDesciption;
	@FindBy(xpath="//a[@class='wpmenucart-contents' and @title='View your shopping cart']")
	private WebElement viewKartLink;
	
	@FindBy(xpath="//div[@id='comments']//h2[@class='woocommerce-Reviews-title']")
	private WebElement Reviewtitle;
	
	public ZprojectMasteringJavaScript(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickOnDescriptionLink()
	{
		DescriptionLink.click();
	}
	
	public void ClickOnReviewsLink()
	{
		ReviewsLink.click();
	}
	
	
	public void ClickOnaddToKartBtn()
	{
		addToKartBtn.click();
	}
	
	public boolean MasteringJavaScriptbookLogo()
	{
		boolean logoStatus=Booklogo.isDisplayed();
		return logoStatus;
		
	}
	
	public boolean BookDesciptionStatus()
	{
		boolean status=BookDesciption.isDisplayed();
		return status;
	}
	
	public String ClickOnviewKartLink()
	{
		String values=viewKartLink.getText();
		return values;
	}
	
	public String ReviewStatus()
	{
		String reviewStatus=Reviewtitle.getText();
		return reviewStatus;
		
	}
	
}
