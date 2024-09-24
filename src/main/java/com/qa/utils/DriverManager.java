package com.qa.utils;

import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
	private static AppiumDriver driver;
	TestUtils utils = new TestUtils();
	
	public static AppiumDriver getDriver(){
        return driver;
    }
	
	public void setDriver(AppiumDriver driver){
        DriverManager.driver = driver;
    }
	
	public void initializeDriver() throws Exception {
        AppiumDriver driver = null;

        if(driver == null){
            try{
                utils.log().info("initializing Appium driver");
                
                driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new OptionsManager().getOptions());
                        
                utils.log().info("Driver is initialized");
                DriverManager.driver = driver;
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        }

    }
}
