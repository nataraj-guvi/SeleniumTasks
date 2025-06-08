package com.testjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlaze {
	WebDriver driver;
	String url = "https://www.demoblaze.com";
	String title;

	public void openbrowser() {
		driver = new ChromeDriver();
	}

	public void browseroperations() {
		try {
			driver.navigate().to(url);
			driver.manage().window().maximize();
			
			title = driver.getTitle();
			System.out.println(title);
			if (title.equals("STORE")) {
				System.out.println("Page Landed on correct website");
			} else {
				System.out.println("Page Landed on correct website");
			}
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	public static void main(String[] args) {
		DemoBlaze obj = new DemoBlaze();
		obj.openbrowser();
		obj.browseroperations();
	}

}
