package com.ActiTIME.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ActiTIME.Generics.BaseTest;
import com.ActiTIME.Generics.ExcelData;
import com.ActiTIME.Pages.ActiTIMEEnterTimeTrackerPage;
import com.ActiTIME.Pages.ActiTIMELoginPage;

public class VerifyBuildNoTest extends BaseTest
{
 @Test(priority=4)
 public void VerifyBuildno() throws InterruptedException
 {
	// String title = ExcelData.getData(file_path, "TC01", 1, 2);
	String un = ExcelData.getData(file_path, "TC01", 1, 0);
    String pw = ExcelData.getData(file_path, "TC01", 1, 1);
    String title = ExcelData.getData(file_path, "TC01", 1, 2);
    String hptitle = ExcelData.getData(file_path, "TC01", 1, 3);
    ActiTIMELoginPage lp = new ActiTIMELoginPage(driver);
    ActiTIMEEnterTimeTrackerPage ep = new ActiTIMEEnterTimeTrackerPage(driver);
    
     
    // verify title
     lp.verifytitle(title);
 
    // click on login button
    //lp.ClickonLogin();
    
   // verify home page title
      ep.verifytitle(title);
     
    // enter the username
    lp.EnterUsername(un);
    
    // enter password
    lp.EnterPassword(pw);
    
    // click on login
    lp.ClickonLogin();
    
    // click on help button
     ep.ClickonHelp();
     
     try
     {
    	// click on about your actittime
    	    ep.ClickOnACBT();
    	    
    	    Reporter.log("popup is displayed",true);
    	    String text = driver.findElement(By.id("aboutPopup_content")).getText();
    
    if(text.equals("(build 1032_35)"))
    {
       Reporter.log("pass",true);
    }	
    else
    {
    	Reporter.log("Fail",true);
    }
     }
     catch (Exception e) 
     {
		Reporter.log("popup is not displayed",true);
    	}
     Thread.sleep(3000);
     // verify build no
      String abuildno = ep.verifyBuild();
      String ebuildno = ExcelData.getData(file_path, "TC04", 1, 0);
      
      if(abuildno.equals(ebuildno))
      {
    	  Reporter.log("Build No is matching",true);
      }
      else
      {
    	  Reporter.log("Build No is not matching",true);
      }
 
 }
   
 
}
