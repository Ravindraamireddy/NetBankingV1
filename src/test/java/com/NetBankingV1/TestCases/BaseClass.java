package com.NetBankingV1.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.NetBankingV1.Utlities.ReadConfig;


public class BaseClass 

{
	ReadConfig readconfig= new ReadConfig();
	public String baseurl=readconfig.geturl();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;


	@Parameters("browser")
	
	@BeforeClass
	

	public void Setup(String br)
	{

		logger = LogManager.getLogger("NetBankingV1");

        PropertyConfigurator.configure("log4j.properties");
		if(br.equals("Chrome"))
		{

			System.setProperty("webdriver.chrome.driver",readconfig.getchormepath());
			driver= new ChromeDriver();
			driver.manage().window().maximize();

		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
			driver= new FirefoxDriver();
			driver.manage().window().maximize();


		}
		else if(br.equals("msedge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getmsedgepath());
			driver= new EdgeDriver();
			driver.manage().window().maximize();

		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseurl);


	}
	
	

	@AfterClass
	public void teardown()


	{
		driver.quit();
	}
	
	
	public void Capaturescreen(WebDriver driver, String tname) throws IOException
	{
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"./screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot Taken");
	}
	
		
}