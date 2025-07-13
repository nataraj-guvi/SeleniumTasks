package task10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragnDropProgram {
	WebDriver driver;
	String color, text, url = "https://jqueryui.com/droppable/";
	WebElement drag, drop;

	public void openbrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void draganddrop() {
		driver.navigate().to(url);
		driver.switchTo().frame(0);
		drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).perform();
		color = drop.getCssValue("background-color");
		System.out.println(color);
		if (color.contains("rgba(255, 250, 144, 1")) {
			System.out.println("Color matched with yellow");
		}
		text = drop.getText();
		System.out.println(text);
		if (text.equals("Dropped!")) {
			System.out.println("Drag and Drop Working");
		} else {
			System.out.println("Drag and Drop not Working");
		}
		driver.quit();
	}

	public static void main(String[] args) {
		DragnDropProgram obj = new DragnDropProgram();
		obj.openbrowser();
		obj.draganddrop();

	}

}
