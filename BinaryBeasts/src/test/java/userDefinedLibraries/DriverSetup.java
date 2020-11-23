package userDefinedLibraries;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class DriverSetup {
	public static WebDriver driver;
	public static String exePath;
	public static String url = "https://www.urbanladder.com/";
	public static String browsertype;
	public static WebDriver driverInstantiation(String browser) {
		browsertype = browser;
		if (browsertype.equalsIgnoreCase("chrome")) {
			exePath = "C:\\Users\\AMMU\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			exePath = "C:\\Program Files\\Selenium\\edgedriver_win64\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", exePath);
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().deleteAllCookies();
		return driver;
	}
}
