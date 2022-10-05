package com.NetBankingV1.Utlities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig

{
Properties pro;


public ReadConfig()
{ 
	File src= new File("./Configuration/config.properties");
try {
	FileInputStream fis=new FileInputStream(src);
	pro=new Properties();
	pro.load(fis);
	
} 
catch (Exception e) 
{
System.out.println("Exception is"+ e.getMessage());

}

	}

public String geturl() {
	
	String url=pro.getProperty("baseurl");
	return url;
}
public String getusername() {
	
	String username=pro.getProperty("username");
	return username;
}
public String getpassword() {
	
	String password=pro.getProperty("password");
	return password;
}
public String getchormepath() {
	
	String chormepath=pro.getProperty("chromepath");
	return chormepath;
}

public String getfirefoxpath() {
	
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
}
public String getmsedgepath() {
	
	String msedgepath=pro.getProperty("msedgepath");
	return msedgepath;
}







}