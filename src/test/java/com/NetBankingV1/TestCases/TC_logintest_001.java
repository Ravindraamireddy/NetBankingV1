package com.NetBankingV1.TestCases;

import static org.testng.Assert.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NetBankingV1.PageObjectModel.LoginPage;

public class TC_logintest_001 extends BaseClass
{

	@Test

	public void logintest() throws IOException
	{
		
		logger.info("url opened");


		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("ENTERED USER NAME");

		lp.setpassward(password);
		logger.info("ENTERED PASSWORD");

		lp.Clicksubmit();
	//	System.out.println(driver.getTitle());

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{

			assertTrue(true);
			logger.info("Login Passed");

		}
		else
		{
			Capaturescreen(driver,"logintest");
			assertTrue(false);
			logger.info("Login Failed");

		}
	}

}
