package utility;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniunOperations
{
public static WebDriver driver=null;
	
	public static Hashtable<String,Object> outputParameters=new Hashtable<String,Object>();
	
	
	
	
	//browser launch
	public static Hashtable<String,Object> browserLaunch(Object[]inputParameters)
	{
		
		try {
		String bName =(String) inputParameters[0];
		String exePath=(String) inputParameters[1];	
		
			if(bName.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", exePath);
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
			}else if(bName.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", exePath);
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
			}
			outputParameters.put("STATUS","PASS");
			outputParameters.put("MESSAGE", "Action:browserLaunch, Input Given:"+inputParameters[0].toString());
			
		}catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Action:browserLaunch, Input Given:"+inputParameters[0].toString());
				
		}
		return outputParameters;
	}
	
	
	//open Application
	public static Hashtable<String,Object> openApplication(Object[]inputParameters)
	{
		try {
		String url =(String) inputParameters[0];
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			outputParameters.put("STATUS","PASS");
			outputParameters.put("MESSAGE", "Action:openApplication, Input Given:"+inputParameters[0].toString());
			
		}catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Action:openApplication, Input Given:"+inputParameters[0].toString());
		}
		return outputParameters;
	
	}
	
	//SendKey
	public static Hashtable<String,Object> sendkey(Object[]inputParameters)
	{
		try {
			String xPath=(String) inputParameters[0];
			String text=(String) inputParameters[1];
			
			driver.findElement(By.xpath(xPath)).sendKeys(text);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			outputParameters.put("STATUS","PASS");
			outputParameters.put("MESSAGE", "Action:sendkey, Input Given:"+inputParameters[1].toString());

		}catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Action:sendkey, Input Given:"+inputParameters[1].toString());
		}
		return outputParameters;
	}
	
	//Click
	
	public static Hashtable<String,Object> click(Object[]inputParameters)
	{
		try {
			String xPath=(String) inputParameters[0];
			
			driver.findElement(By.xpath(xPath)).click();;
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			outputParameters.put("STATUS","PASS");
			outputParameters.put("MESSAGE", "Action:click, Input Given:"+inputParameters[0].toString());

		}catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Action:click, Input Given:"+inputParameters[0].toString());
		}
		return outputParameters;
	}
	
	//dropdown
	public static Hashtable<String,Object> dropdown(Object[]inputParameters)
	{
		try {
			String xPath=(String) inputParameters[0];
			String value=(String) inputParameters[1];
			
			Select d =new Select(driver.findElement(By.xpath(xPath)));
			        d.selectByVisibleText(value);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			outputParameters.put("STATUS","PASS");
			outputParameters.put("MESSAGE", "Action:dropdown, Input Given:"+inputParameters[1].toString());

		}catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Action:dropdown, Input Given:"+inputParameters[1].toString());
		}
		return outputParameters;
	}
	
	//Mouseover
	public static Hashtable<String,Object> moveToElement(Object[]inputParameters)
	{
		try {
			String xPath=(String) inputParameters[0];
			
			Actions act =new  Actions(driver);
			WebElement move=driver.findElement(By.xpath(xPath));
			        act.moveToElement(move).build().perform();
			        System.out.println("Successfully moved to given element");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			outputParameters.put("STATUS","PASS");
			outputParameters.put("MESSAGE", "Action:moveToElement, Input Given:"+inputParameters[0].toString());

		}catch(Exception e)
		{
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Action: moveToElement, Input Given:"+inputParameters[1].toString());
		}
		return outputParameters;
	}
	
	//Validation
	
	public static Hashtable<String,Object> validation(Object[]inputParameters)
	{
		try {
			String Given=(String) inputParameters[0];
			String xPath=(String) inputParameters[1];
			String Actual=driver.findElement(By.xpath(xPath)).getText();
			
			if(Given.equalsIgnoreCase(Actual))
			{
				System.out.println("Test case Pass");
				outputParameters.put("STATUS","PASS");
				outputParameters.put("MESSAGE", "Action:Validation, Input Given:"+inputParameters[0].toString());
			}else
			{
				System.out.println("Test case Fail");
				outputParameters.put("STATUS","FAIL");
				outputParameters.put("MESSAGE", "Action: Validation, Input Given:"+inputParameters[0].toString());
			}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			outputParameters.put("STATUS","PASS");
			outputParameters.put("MESSAGE", "Action:Validation, Input Given:"+inputParameters[1].toString());

		}catch(Exception e)
		{
			System.out.println("Test case Fail");
			outputParameters.put("STATUS","FAIL");
			outputParameters.put("MESSAGE", "Action:Validation, Input Given:"+inputParameters[1].toString());
		}
		return outputParameters;
	}
	
       //close
	public static void close()
	{
		driver.close();
	}




}
	



