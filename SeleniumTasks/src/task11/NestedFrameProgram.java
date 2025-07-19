package task11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NestedFrameProgram {
	WebDriver driver;
	WebDriverWait wait;
	String url = "http://the-internet.herokuapp.com/nested_frames";
	String left, middle, right, bottom, title;
	int frameCount;
	boolean verify = false;

	public void openBrowser() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

	public void nestedFrame() {
		try {
			driver.navigate().to(url);
			driver.switchTo().frame("frame-top");
			frameCount = driver.findElements(By.xpath("//frame")).size();
			if (frameCount == 3) {
				verify = true;
				System.out.println("Verify the there are " + frameCount + " frames in the page is: " + verify);
			} else {
				System.out.println("There is no three frames in the page");
			}
		} catch (Exception e) {
			System.out.println("Failed to switch to frame-top or count inner frames: " + e.getMessage());
		}
		try {
			driver.switchTo().frame("frame-left");
			left = driver.findElement(By.xpath("//html/body[contains(text(),'LEFT')]")).getText();
			if (left.equals("LEFT")) {
				verify = true;
				System.out.println("LEFT frame has a text value as " + left + " is " + verify);
			}
		} catch (Exception e) {
			System.out.println("Failed to switch to frame-Left: " + e.getMessage());
		}
		try {
			driver.switchTo().parentFrame();
			driver.switchTo().frame("frame-middle");
			middle = driver.findElement(By.xpath("//html/body/div[contains(text(),'MIDDLE')]")).getText();
			if (middle.equals("MIDDLE")) {
				verify = true;
				System.out.println("MIDDLE frame has a text value as " + middle + " is " + verify);
			}
		} catch (Exception e) {
			System.out.println("Failed to switch to frame-Middle: " + e.getMessage());
		}
		try {
			driver.switchTo().parentFrame();
			driver.switchTo().frame("frame-right");
			right = driver.findElement(By.xpath("//html/body[contains(text(),'RIGHT')]")).getText();
			if (right.equals("RIGHT")) {
				verify = true;
				System.out.println("RIGHT frame has a text value as " + right + " is " + verify);
			}
		} catch (Exception e) {
			System.out.println("Failed to switch to frame-Right: " + e.getMessage());
		}
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frame-bottom");
			bottom = driver.findElement(By.xpath("//html/body[contains(text(),'BOTTOM')]")).getText();
			if (bottom.equals("BOTTOM")) {
				verify = true;
				System.out.println("BOTTOM frame has a text value as " + bottom + " is " + verify);
			}
		} catch (Exception e) {
			System.out.println("Failed to switch to frame-Bottom: " + e.getMessage());
		}
		try {
			driver.switchTo().defaultContent();
			title = driver.getTitle();
			System.out.println("The Title of the frame is: " + title);
		} catch (Exception e) {
			System.out.println("Failed to switch to frame-Top: " + e.getMessage());
		} finally {
			driver.quit();
			System.out.println("Browser Instance closed.");
		}
	}

	public static void main(String[] args) {
		NestedFrameProgram obj = new NestedFrameProgram();
		obj.openBrowser();
		obj.nestedFrame();
	}

}
