package com.qa.test;

import org.testng.annotations.Test;

import com.qa.utils.DriverManager;
import com.qa.utils.ScreenshotManager;
import com.qa.utils.ServerManager;
import com.qa.utils.TestUtils;
import com.qa.utils.VideoManager;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BaseTest {
	
	String dateTime;

  @AfterMethod
  public void afterMethod(Method m) {
	  try {
		ScreenshotManager.takeScreenshot(m.getName(), dateTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  @BeforeClass
  public void beforeClass() {
	  TestUtils utils = new TestUtils();
	  try {
		  new ServerManager().startServer();
		  new DriverManager().initializeDriver();
		  dateTime = utils.dateTime();
		  VideoManager.startRecording();
		  waitForVisibility(DriverManager.getDriver().findElement(AppiumBy.id("android:id/button1")));
		  DriverManager.getDriver().findElement(AppiumBy.id("android:id/button1")).click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
  }

  @AfterClass
  public void afterClass() {
	  try {
		VideoManager.stopRecording(null);
	  } catch (IOException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  DriverManager driverManager = new DriverManager();
      if(DriverManager.getDriver() != null){
          DriverManager.getDriver().quit();
          driverManager.setDriver(null);
      }
      ServerManager serverManager = new ServerManager();
      if(serverManager.getServer() != null){
          serverManager.getServer().stop();
      }
  }
  
  public void waitForVisibility(WebElement e) {
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TestUtils.WAIT));
	wait.until(ExpectedConditions.visibilityOf(e));
  }

}
