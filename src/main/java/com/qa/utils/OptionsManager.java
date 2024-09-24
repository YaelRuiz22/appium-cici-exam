package com.qa.utils;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.options.BaseOptions;

public class OptionsManager {
	
	public BaseOptions<?> getOptions() throws IOException {
		Properties props = new PropertyManager().getProps();
		return new UiAutomator2Options()
				.setUdid(props.getProperty("udid"))
				.setAvd(props.getProperty("avd"))
				.setAvdLaunchTimeout(Duration.ofSeconds(180))
				.setApp(props.getProperty("androidAppLocation"))
				.setAppPackage(props.getProperty("androidAppPackage"))
				.setAppActivity(props.getProperty("androidAppActivity"))
				;
	}
}
