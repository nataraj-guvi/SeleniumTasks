package com.testjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wikipedia {
	WebDriver driver;
	String url = "https://www.wikipedia.org/", title;
	WebElement search, history;

	public void openbrowser() {
		driver = new ChromeDriver();
	}
	public void browseroperations() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.navigate().to(url);
			driver.manage().window().maximize();
			search = driver.findElement(By.xpath("//input[@id='searchInput']"));
			search.sendKeys("Artificial Intelligence");
			search.sendKeys(Keys.RETURN);
			Thread.sleep(5000);
			history = driver.findElement(By.linkText("History of artificial intelligence"));
			history.click();
			title = driver.getTitle();
			System.out.println(title);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			driver.quit();
		}
	}
	public static void main(String[] args) {
		Wikipedia obj = new Wikipedia();
		obj.openbrowser();
		obj.browseroperations();

	}

}
