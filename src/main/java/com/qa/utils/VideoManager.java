package com.qa.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;

import io.appium.java_client.screenrecording.CanRecordScreen;

public class VideoManager {
    private static TestUtils utils = new TestUtils();

    public static void startRecording(){
    	utils.log().info("Starting recording");
    	
        ((CanRecordScreen) DriverManager.getDriver()).startRecordingScreen();
    }

    public static void stopRecording(String scenarioName) throws IOException {
    	Properties props = new PropertyManager().getProps();
    	TestUtils utils = new TestUtils();
        String media = ((CanRecordScreen) DriverManager.getDriver()).stopRecordingScreen();
        
        String dir = "videos" + File.separator + props.getProperty("udid") + "_" + props.getProperty("avd") + "_"
				+ File.separator + utils.dateTime() + File.separator + "TestVideo";

        File videoDir = new File(System.getProperty("user.dir") + File.separator + dir);

        synchronized(videoDir){
            if(!videoDir.exists()) {
                videoDir.mkdirs();
            }
        }
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(videoDir + File.separator + "video" + ".mp4");
            stream.write(Base64.decodeBase64(media));
            stream.close();
            utils.log().info("video path: " + videoDir + File.separator + "video" + ".mp4");
        } catch (Exception e) {
            utils.log().error("error during video capture" + e.toString());
        } finally {
            if(stream != null) {
                stream.close();
            }
        }
    }
}
