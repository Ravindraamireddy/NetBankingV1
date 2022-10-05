package com.NetBankingV1.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerpage

{

	WebDriver ldriver;

	public AddCustomerpage(WebDriver rdriver)
	{

		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}


	@FindBy(how = How.XPATH, using="//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement lnknewCustomer;

	@FindBy(how = How.NAME, using="name")
	@CacheLookup
	WebElement Customername;

	@FindBy(how = How.NAME, using="rad1")
	@CacheLookup
	WebElement radgender;

	@FindBy(how = How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;	

	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement txtaddr;	

	@FindBy(how = How.NAME, using="city")
	@CacheLookup
	WebElement txtcity;	

	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement txtstate;

	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement txtpin;	

	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtphno;	

	@FindBy(how = How.NAME, using="emailid")
	@CacheLookup
	WebElement txtmail;	

	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement txtpassword;	

	@FindBy(how = How.NAME, using="sub")
	@CacheLookup
	WebElement clicksubmit;	


	public void clicknewcustomer() 

	{

	lnknewCustomer.click();
	}

	public void Customername(String cname) 

	{

		Customername.sendKeys(cname);
	}


	public void radgender(String gender) 

	{
		radgender.click();

	}
	public void custdob(String mm,String dd,String yy) 

	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);

	}


	public void custaddr(String cadd) 

	{
		txtaddr.sendKeys(cadd);

	}

	public void custcity(String cty) 

	{
		txtcity.sendKeys(cty);

	}	


	public void custstate(String cstate) 

	{
		txtstate.sendKeys(cstate);

	}
	public void custpno(String pno) 

	{
		txtpin.sendKeys(String.valueOf(pno));

	}
	public void custphno(String tno) 

	{
		txtphno.sendKeys(tno);

	}

	public void custemail(String mail) 

	{
		txtmail.sendKeys(mail);

	}

	public void custpassward(String pwd) 

	{
		txtpassword.sendKeys(pwd);

	}

	public void custclick() 

	{
		clicksubmit.click();

	}

}
