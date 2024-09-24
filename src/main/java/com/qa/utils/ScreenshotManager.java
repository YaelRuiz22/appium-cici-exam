package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Reporter;

public class ScreenshotManager {
	public static void takeScreenshot(String fileName, String testDate) throws IOException {
		File file = DriverManager.getDriver().getScreenshotAs(OutputType.FILE);
		Properties props = new PropertyManager().getProps();
		TestUtils utils = new TestUtils();
		String imagePath = "Screenshots" + File.separator + props.getProperty("udid") + "_" + props.getProperty("avd")
			+ File.separator + testDate + File.separator 
			+ File.separator + fileName + utils.dateTime() + ".png";
		String completeImagePath = System.getProperty("user.dir") + File.separator + imagePath;
		try {
			FileUtils.copyFile(file, new File(imagePath));
			utils.log().info("Screenshot taken and saved at:" + imagePath);
			Reporter.log("This is the sample screenshot from " + fileName);
			Reporter.log("<a href='" + completeImagePath + "'> <img src='" + completeImagePath + "' height='100' + width='100'/></a>" );
		} catch (Exception e) {
			e.printStackTrace();
			utils.log().fatal("Error while taking screenshot with name" + fileName);
		}
	}
}
