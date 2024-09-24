package com.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.qa.utils.DriverManager;

import io.appium.java_client.AppiumBy;

public class TestCase extends BaseTest {
	@Test
	public void validateHamburgerMenu () {
		try {
			waitForVisibility(DriverManager.getDriver().findElement(AppiumBy.id("at.markushi.reveal:id/action")));
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void validateBtn1 () {
		try {
			waitForVisibility(
					DriverManager.getDriver().findElement(
							AppiumBy
							.id("at.markushi.reveal:id/btn_1"))
					);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void validateBtn2 () {
		try {
			waitForVisibility(
					DriverManager.getDriver().findElement(
							AppiumBy
							.id("at.markushi.reveal:id/btn_2"))
					);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void validateBtn3 () {
		try {
			waitForVisibility(
					DriverManager.getDriver().findElement(
							AppiumBy
							.id("at.markushi.reveal:id/btn_3"))
					);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void validateSlowMotionText() {
		try {
			waitForVisibility(
					DriverManager.getDriver().findElement(
							AppiumBy
							.id("at.markushi.reveal:id/slow_motion"))
					);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void validateEnableRevealText() {
		try {
			waitForVisibility(
					DriverManager.getDriver().findElement(
							AppiumBy
							.id("at.markushi.reveal:id/enable_reveal"))
					);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void validateEnableActionsText() {
		try {
			waitForVisibility(
					DriverManager.getDriver().findElement(
							AppiumBy
							.id("at.markushi.reveal:id/enable_actions"))
					);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test(priority = 1)
	public void validateIfRevealAndActionAreChecked() {
		assertEquals(DriverManager.getDriver().findElement(AppiumBy.id("at.markushi.reveal:id/slow_motion")).getAttribute("checked"), "false");
		assertEquals(DriverManager.getDriver().findElement(AppiumBy.id("at.markushi.reveal:id/enable_reveal")).getAttribute("checked"), "true");
		assertEquals(DriverManager.getDriver().findElement(AppiumBy.id("at.markushi.reveal:id/enable_actions")).getAttribute("checked"), "true");
	}
	
	@Test(priority = 2)
	public void validateAfterChangingColor () {
		try {
			DriverManager.getDriver().findElement(AppiumBy.id("at.markushi.reveal:id/slow_motion")).click();
			DriverManager.getDriver().findElement(AppiumBy.id("at.markushi.reveal:id/btn_3")).click();
			assertTrue(true);
		} catch (Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	
	
	
}
