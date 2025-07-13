package task10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerProgram {
	WebDriver driver;
	String selectedDate,url = "https://jqueryui.com/datepicker/";
	WebElement iframe, dateselect, nextbutton, date;

	public void openbrowser() {
		driver = new ChromeDriver();
	}

	public void datepicksteps() {
		driver.manage().window().maximize();
		driver.navigate().to(url);
		iframe = driver.findElement(By.xpath("//iframe[contains(@src,'datepicker')]"));
		driver.switchTo().frame(iframe);
		dateselect = driver.findElement(By.xpath("//input[@id='datepicker']"));
		dateselect.click();
		nextbutton = driver.findElement(By.xpath("//a[@title='Next']"));
		nextbutton.click();
		date = driver.findElement(By.xpath("//a[@data-date='22']"));
		date.click();
		selectedDate=dateselect.getAttribute("value");
		System.out.println(selectedDate);
		//driver.quit();
		
	}

	public static void main(String[] args) {
		DatePickerProgram obj=new DatePickerProgram();
		obj.openbrowser();
		obj.datepicksteps();

	}

}
