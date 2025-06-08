import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbSignupTest {
	WebDriver driver;
	String lastUrl;
	String url="https://www.facebook.com/login/";
	String currentUrl="https://www.facebook.com/r.php?locale=en_GB&display=page";
	String title;
	public void launchBrowser() {
		driver= new ChromeDriver();
			}
	public void launchApp() {
		driver.get(url);
	}
	public void browseMethods() {
		lastUrl=driver.getCurrentUrl();
		System.out.println("URL is"+lastUrl);
		title=driver.getTitle();
		System.out.println("The title is"+title);
		driver.navigate().to(currentUrl);
		System.out.println("the Current url is"+currentUrl);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FbSignupTest obj=new FbSignupTest();
		obj.launchBrowser();
		obj.launchApp();
		obj.browseMethods();
	}

}
