package task10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpandLoginGuvi {
	WebDriver driver;
	WebDriverWait wait;
	String name = "natarajasundaram";
	String emailid = "abcd1234567@gmail.com";
	String password = "test@123";
	String mobile = "9865180789";
	String url = "https://www.guvi.in/";
	WebElement signupbtnlink,emailField,successMsg;
	public void openBrowser() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
			}
	public void signupAndLogin() {
		try {
			driver.navigate().to(url);
			
			signupbtnlink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign")));
			signupbtnlink.click();
			driver.findElement(By.id("name")).sendKeys(name);
			emailField = driver.findElement(By.id("email"));
			emailField.sendKeys(emailid);
			String enteredEmail = emailField.getAttribute("value");
			System.out.println("Entered Email: " + enteredEmail);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("mobileNumber")).sendKeys(mobile);
			driver.findElement(By.id("signup-btn")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileDrpDwn")));
			new Select(driver.findElement(By.id("profileDrpDwn"))).selectByVisibleText("Working professional in IT");
			new Select(driver.findElement(By.id("degreeDrpDwn"))).selectByVisibleText("Other");
			driver.findElement(By.id("year")).sendKeys("2016");
			driver.findElement(By.id("details-btn")).click();
			successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Almost Done! Check Your Inbox!')]")));
			if (successMsg.isDisplayed()) {
				System.out.println(" User Registered Successfully!");
			} else {
				System.out.println(" Registration may have failed. Check UI manually.");
			}

			System.out.println("Registration Page Title: " + driver.getTitle());
			driver.navigate().to(url);
			driver.findElement(By.id("login-btn")).click();
			WebElement loginEmailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
			loginEmailField.sendKeys(enteredEmail);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-btn")).click();
			System.out.println("Login attempted with registered credentials.");
			System.out.println("Login Page Title: " + driver.getTitle());

		} catch (Exception e) {
			System.out.println(" Exception occurred: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
				System.out.println("Browser closed.");
			}
		}
	}

	public static void main(String[] args) {
		SignUpandLoginGuvi obj = new SignUpandLoginGuvi();
		obj.openBrowser();
		obj.signupAndLogin();
	}
}
