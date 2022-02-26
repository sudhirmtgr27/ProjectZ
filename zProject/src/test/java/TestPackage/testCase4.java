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

public class testCase4 extends BasePageClass
{
	/*1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
10) Click on Description tab for the book you clicked on.
11) There should be a description regarding that book the user clicked on*/
	
	ZProjectHomePage homePage;
	ZProjectShopPage shopPage;
	utilityFilezProject utilityfile;
	ZprojectMasteringJavaScript mjscriptstatus;
	String TestCaseID="103";

	@BeforeMethod
	public void setUp()
	{
		OpenBrowser();
		homePage =new ZProjectHomePage(driver);
		shopPage = new ZProjectShopPage(driver);
		mjscriptstatus=new ZprojectMasteringJavaScript(driver);
		utilityfile=new utilityFilezProject();

	}


	@Test
	public void VerifyDescriptionOfBook()
	{
		homePage.ClickOnShopLink();
		shopPage.ClickOnHomeLink();
		List<WebElement> arrivals=homePage.ListOfNewArrivalsLink();
		utilityFilezProject.SelectFromList(arrivals,"Mastering JavaScript");
		mjscriptstatus.ClickOnDescriptionLink();
		boolean actStatus=mjscriptstatus.BookDesciptionStatus();
		Assert.assertTrue(actStatus,"Description is not available.");

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
