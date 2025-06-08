package com.testjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleLaunch {
	WebDriver driver;
	String url = "http://www.google.co.in";
	String currentUrl;

	public void openbrowser() {
		driver = new FirefoxDriver();
	}

	public void browseroperations() {
		try {
			driver.navigate().to(url);
			driver.manage().window().maximize();
			
			currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			Thread.sleep(5000);
			driver.navigate().refresh();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
//			driver.close();
		}
	}

	public static void main(String[] args) {
		GoogleLaunch object = new GoogleLaunch();
		object.openbrowser();
		object.browseroperations();
	}

}
