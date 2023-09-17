package testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Baseclass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rp;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		     
	     rp = ResourceBundle.getBundle("config"); // properties file
		
		logger = LogManager.getLogger(this.getClass()); // log4j code
		
		if(br.equals("chrome"))
		{
		driver = new ChromeDriver();
		}
		else
		{
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(rp.getString("appurl"));
	//	driver.get("https://demo.opencart.com/index.php"); 
		
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	public String randomstring()
	{
		String generatedstring =RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		
	}
	

	public String randomnumber()
	{
		String generatedstring =RandomStringUtils.randomNumeric(10);
		return generatedstring;
		
	}
	public String randomalphanumeric()
	{
		String str =RandomStringUtils.randomAlphabetic(3);
		String num =RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
		
	}
	
	public String capturescreen (String tname)
	{
		
	String timestamp =	new SimpleDateFormat("YYYYMMDDhhmmss").format(new Date());
	
	TakesScreenshot takescreenshot = (TakesScreenshot) driver;
	File source =  takescreenshot.getScreenshotAs(OutputType.FILE);
	  String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timestamp + ".png";
	  
	  try {
		FileUtils.copyFile(source, new File(destination));
	} catch (IOException e) {
	
		e.printStackTrace();
	}
		
		
		return destination;
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
