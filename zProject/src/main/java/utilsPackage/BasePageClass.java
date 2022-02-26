package utilsPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePageClass 
{
	public static WebDriver driver;
	
	public void OpenBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://practice.automationtesting.in/");
	}
	
	public void TearDown()
	{
		driver.close();
	}
	
	
	
	
	
}
