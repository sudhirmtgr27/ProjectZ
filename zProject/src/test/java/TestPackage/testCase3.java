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

public class testCase3 extends BasePageClass
{
	/*1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket*/

	ZProjectHomePage homePage;
	ZProjectShopPage shopPage;
	utilityFilezProject utilityfile;
	String TestCaseID="102";

	@BeforeMethod
	public void setUp()
	{
		OpenBrowser();
		homePage =new ZProjectHomePage(driver);
		shopPage = new ZProjectShopPage(driver);
		utilityfile=new utilityFilezProject();

	}


	@Test(priority=1)
	public void VerifyCurrectSelectionOfArrivals()
	{
		homePage.ClickOnShopLink();
		shopPage.ClickOnHomeLink();
		List<WebElement> arrivals=homePage.ListOfNewArrivalsLink();
		for(WebElement arival:arrivals)
		{
			if(arival.getText().contains("Mastering JavaScript"))
			{
				arival.click();
				break;
			}

		}

	}

	@Test(priority=2)
	public void verifyNavigateTOCorrectArrival()
	{homePage.ClickOnShopLink();
	shopPage.ClickOnHomeLink();
	List<WebElement> arrivals=homePage.ListOfNewArrivalsLink();
	for(WebElement arival:arrivals)
	{
		if(arival.getText().contains("Mastering JavaScript"))
		{
			arival.click();
			break;
		}

	}
	String actTitle=driver.getTitle();
	String expTitle="Mastering JavaScript – Automation Practice Site";
	Assert.assertEquals(actTitle, expTitle,"title not match..");
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
