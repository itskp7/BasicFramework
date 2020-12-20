package tests;

import org.testng.annotations.Test;

import data.DataFile;
import data.Xls_Reader;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	LoginPage lp = new LoginPage();
	
	Xls_Reader d = new Xls_Reader("C:\\testing\\NikulTest.xlsx");
	
	DataFile df = new DataFile();  // dataFile is a class we have made
	
	//String correctEmail = d.getCellData("Data1", 1, 2);
	//String wrongPassword = d.getCellData("Data1", 2, 2);
	//String wrongEmail = d.getCellData("Data1", 1, 3);
	//String passwordErrMsg = d.getCellData("Data1", 4, 2);
	//String emailErrMsg = d.getCellData("Data1", 3, 2);
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.openBrowser();
	  lp.openYahoo();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
  }
  
  @Test
  public void LoginWithWrongPasswordTest() throws InterruptedException {
	  lp.enterEmail(df.correctEmail);  ////see this //also first it was direct values in double quotes no string was made
	  lp.enterPassword(df.wrongPassword);
	  
	  //String expectedErrMsg = df.passwordErrMsg;
	  //String actualErrMsg = lp.readPasswordError();
	  Assert.assertEquals(lp.readPasswordError(),df.passwordErrMsg );  
	  
  }
  
  @Test
  public void LoginWithWrongEmailTest() throws InterruptedException {
	  lp.enterEmail(df.wrongEmail);
	  //String expectedErrMsg = df.emailErrMsg;
	  //String actualErrMsg = lp.readEmailError();
	  Assert.assertEquals(lp.readEmailError(),df.emailErrMsg ); 
	  
  }

}
