package TestPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import PagesPackage.ZProjectHomePage;
import PagesPackage.ZProjectShopPage;
import utilsPackage.BasePageClass;
import utilsPackage.utilityFilezProject;

public class testCase1 extends BasePageClass
{
/*1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Sliders only
6) The Home page must contains only three sliders*/
	
	ZProjectHomePage homePage;
	ZProjectShopPage shopPage;
	utilityFilezProject utilityfile;
	String TestCaseID="100";
	
	@BeforeMethod
	public void SetUp()
	{
		 OpenBrowser();
		 homePage = new ZProjectHomePage(driver);
		 shopPage = new ZProjectShopPage(driver);
		 utilityfile = new utilityFilezProject();
		
		 
	}
	
	@Test
	public void verifyCountSlider()
	{
		homePage.ClickOnShopLink();
		shopPage.ClickOnHomeLink();
		
		int expCount=0;
		int actCount=homePage.CountSliders();
		Assert.assertEquals(actCount, expCount,"Both result not match.");	
		
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
