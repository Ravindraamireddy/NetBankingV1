package com.NetBankingV1.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.NetBankingV1.PageObjectModel.AddCustomerpage;
import com.NetBankingV1.PageObjectModel.LoginPage;

public class TC_AddCustomer_003 extends BaseClass


{
	@Test

	public void AddCustomer() throws Exception
	{

		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("ENTER USERNAME");
		lp.setpassward(password);
		logger.info("ENTER PASSWORD");
		lp.Clicksubmit();
		Thread.sleep(3000);

		AddCustomerpage addcustomer= new AddCustomerpage(driver);
		addcustomer.clicknewcustomer();
		
		logger.info("NewCustomer details");
	
		addcustomer.Customername("Ravi");
		addcustomer.radgender("male");
		addcustomer.custdob("20","12","77");
		Thread.sleep(3000);
		addcustomer.custaddr("11");
		addcustomer.custcity("Hyderabad");
		addcustomer.custstate("Telagana");
		addcustomer.custpno("500097");
		addcustomer.custphno("9959941234");
		String mail=Randomestring()+"@gmail.com";
		addcustomer.custemail(mail);
		addcustomer.custpassward("abcd");
		addcustomer.custclick();
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)

		{
			logger.info("Testcase is passed");
			Assert.assertTrue(true);	

		}
		else
		{
			logger.info("Test case is failed");
			Capaturescreen(driver, "AddCustomerpage");
			Assert.assertTrue(false);

		}
	}

	public String Randomestring()
	{
		String genratestring=RandomStringUtils.randomAlphabetic(8);
		return genratestring;
	}

}
