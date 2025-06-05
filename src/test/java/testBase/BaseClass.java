package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
public static WebDriver driver;
public Logger logger;
public Properties prop;
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws Exception
	{
		
		FileInputStream file= new FileInputStream("./src//test//resources//config.properties");
		prop=new Properties();
		prop.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			//String huburl=http://local:4444//wd//
			DesiredCapabilities capabilities= new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("no matching os");
				return;
			}
			
			//br
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox": capabilities.setBrowserName("firefox");break;
			default: System.out.println("no matching browser");return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		default: System.out.println("Invalid browser name");return;
		}
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.get("https://demo.nopcommerce.com/register?returnurl=%2F");
		driver.get(prop.getProperty("appUrl"));
		
	}
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomNumeric()
	{
		String numeric=RandomStringUtils.randomNumeric(10);
		return numeric;
	}
	public String randomAlphbets()
	{
		String alphabetic=RandomStringUtils.randomAlphabetic(5);
		return alphabetic;
	}
	public String randomAlphanumeric()
	{
		String generatedAlphabets=RandomStringUtils.randomAlphabetic(4);
		String generatedNumeric=RandomStringUtils.randomNumeric(3);
		return(generatedAlphabets+"@"+generatedNumeric);
	}
	
	public  String captureScreen(String tname)
	{
		String timestamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
		File sourceFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilepath=System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+ timestamp +".png";
		File targetFile=new File(targetFilepath);
		sourceFile.renameTo(targetFile);
		return targetFilepath;
		
		
	}


}
