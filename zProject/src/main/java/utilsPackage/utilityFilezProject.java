package utilsPackage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class utilityFilezProject 
{
	public static  void getScreenShots(WebDriver driver,String TestCaseID ) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest =new File("C:\\Users\\Hp\\seleniumTutorial\\zProject\\ScreenshotsZProject\\"+TestCaseID+".png");
		FileHandler.copy(source, dest);
	}
	
	
	public static void SelectFromList(List<WebElement> elements,String value)
	{
		for(WebElement ele:elements)
		{
			if(ele.getText().contains(value))
			{
				ele.click();
				break;
			}

		}
		
	}
	
	
	
	
	
}
