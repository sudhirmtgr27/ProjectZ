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
import utilsPackage.BasePageClass;
import utilsPackage.utilityFilezProject;

public class testCase2 extends BasePageClass 
{
/*1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals*/

	ZProjectHomePage homePage;
	ZProjectShopPage shopPage;
	utilityFilezProject utilityfile;
	String TestCaseID="101";
	
	@BeforeMethod
	public void setUp()
	{
		OpenBrowser();
		homePage =new ZProjectHomePage(driver);
		shopPage = new ZProjectShopPage(driver);
		utilityfile=new utilityFilezProject();
		
	}
	
	
	@Test
	public void VerifyArrivals()
	{
		homePage.ClickOnShopLink();
		shopPage.ClickOnHomeLink();
		List<WebElement> arrivals=homePage.ListOfNewArrivalsLink();
		int actArrivalCount=arrivals.size();
		System.out.println("actArrivalCount : "+actArrivalCount);
		int expArrivalCount=3;
		System.out.println("expArrivalCount : "+expArrivalCount);
		Assert.assertEquals(actArrivalCount, expArrivalCount,"match not found..");
	}
	
	
	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			utilityFilezProject.getScreenShots(driver, TestCaseID);
		}
		TearDown();
	}
		
}

