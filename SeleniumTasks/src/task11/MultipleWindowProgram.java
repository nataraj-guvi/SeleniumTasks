package task11;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindowProgram {
	WebDriver driver;
	WebDriverWait wait;
	String ogwindow, titlevalue, url = "https://the-internet.herokuapp.com/windows";
	WebElement clickHereLink;
	boolean NewWindowVerified = false;
    boolean OriginalWindowActive = false;
	public void openBrowser() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();

	}
	public void windows() {
		try {
			
			driver.navigate().to(url);
			ogwindow = driver.getWindowHandle();
			clickHereLink = driver.findElement(By.linkText("Click Here"));
			clickHereLink.click();
			Set<String> allWindows = driver.getWindowHandles();
			for (String windowHandle : allWindows) {
				if (!windowHandle.equals(ogwindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			titlevalue = driver.getTitle();
			if (titlevalue.equals("New Window")) {
				NewWindowVerified=true;
				System.out.println("Verify the New window open is "+NewWindowVerified);
			}
			driver.close();
			driver.switchTo().window(ogwindow);
			titlevalue = driver.getTitle();
			OriginalWindowActive=true;
			System.out.println("Verify the Original window Active is "+OriginalWindowActive);
		}

		catch (Exception e) {
			System.out.println(" Exception occurred: " + e.getMessage());
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
	public static void main(String[] args) {
		MultipleWindowProgram obj = new MultipleWindowProgram();
		obj.openBrowser();
		obj.windows();

	}

}
