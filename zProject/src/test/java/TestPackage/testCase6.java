package TestPackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PagesPackage.ZProjectHomePage;
import PagesPackage.ZProjectShopPage;
import PagesPackage.ZprojectMasteringJavaScript;
import utilsPackage.BasePageClass;
import utilsPackage.utilityFilezProject;

public class testCase6 extends BasePageClass
{
	/*1) Open the browser
2) Enter the URL ?http://practice.automationtesting.in/?
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
10) Now clock on Reviews tab for the book you clicked on.
11) There should be a Reviews regarding that book the user clicked on*/

	ZProjectHomePage homepage;
	ZProjectShopPage shoppage;
	ZprojectMasteringJavaScript bookpage;
	utilityFilezProject utils;
	String TestCaseID="105";

	@BeforeMethod
	public void setup()
	{
		OpenBrowser();
		homepage=new ZProjectHomePage(driver);
		shoppage=new ZProjectShopPage(driver);
		bookpage=new ZprojectMasteringJavaScript(driver);
		utils=new utilityFilezProject();


	}

	@Test
	public void verifynevigateToBassket()
	{
		homepage.ClickOnShopLink();
		shoppage.ClickOnHomeLink();
		List<WebElement> arrivals=homepage.ListOfNewArrivalsLink();
		utilityFilezProject.SelectFromList(arrivals, "Mastering JavaScript");
		String actTitle=driver.getTitle();
		String expTitle="Mastering JavaScript ? Automation Practice Site";
		Assert.assertEquals(actTitle, expTitle,"Both result not match..");
		

	}
	
	@Test
	public void verifyReviewTabAndNavigate()
	{
		homepage.ClickOnShopLink();
		shoppage.ClickOnHomeLink();
		List<WebElement> arrivals=homepage.ListOfNewArrivalsLink();
		utilityFilezProject.SelectFromList(arrivals, "Mastering JavaScript");
		bookpage.ClickOnReviewsLink();
		String reviewsStat=bookpage.ReviewStatus();
		Assert.assertEquals(reviewsStat,"Reviews");
				
	}


	@AfterMethod
	public void CloseddBrowser(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			utilityFilezProject.getScreenShots(driver, TestCaseID);
		}
		TearDown();
	}

}
