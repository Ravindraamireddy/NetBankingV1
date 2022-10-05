package com.NetBankingV1.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.NetBankingV1.PageObjectModel.LoginPage;
import com.NetBankingV1.Utlities.XLutil;

public class TC_logintestddt_002 extends BaseClass


{
	@Test (dataProvider="logindata")
	public void loginddt(String user,String pwd) throws Exception
	{
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(user);
		logger.info("UserName Provided");
		lp.setpassward(pwd);
		logger.info("PassWard Provided");
		lp.Clicksubmit();
		Thread.sleep(3000);

		if (IsAlertPresent()==true) 
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			assertTrue(false);
			logger.info("LOGIN FaILED");

		} 
		else 
		{
			assertTrue(true);
			lp.logout();
			logger.info("Login Sucess");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}

	}


	public  Boolean IsAlertPresent()
	{
		try {

			driver.switchTo().alert();
			return true;

		} catch (NoAlertPresentException e) 

		{
			return false;
		}
	}

	@DataProvider(name= "logindata")

	String[][] getData() throws IOException
	{
		String Xlpath= System.getProperty("user.dir")+"/src/test/java/com/NetBankingV1/testdata/LoginData.xlsx";



		int rownum= XLutil.getRowCount(Xlpath, "Sheet1");
		System.out.println(rownum);
		int colnum=  XLutil.getCellCount(Xlpath, "Sheet1", 1)	;
		System.out.println(colnum);
		String loginData[][]= new String[rownum][colnum];

		for (int i = 1; i <=rownum ; i++)
		{
			for (int j = 0; j <colnum ; j++) 
			{
				loginData[i-1][j]= XLutil.getCellData(Xlpath, "Sheet1", i, j);
			}

		}

		return loginData;
	}
}
