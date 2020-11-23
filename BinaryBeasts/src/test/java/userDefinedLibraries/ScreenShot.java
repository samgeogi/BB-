package userDefinedLibraries;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenShot {
	public static void screenShot(WebDriver driver) {
		File obj = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// Now copy the screenshot to desired location using copyFile method
			FileUtils.copyFile(obj, new File(
					"C:\\Users\\AMMU\\Desktop\\anjana\\WorkSpace\\BinaryBeasts\\ScreenShot\\"
							+ System.currentTimeMillis() + ".png"));
		} catch (IOException exp) {
			System.out.println(exp.getMessage());
		}

	}
}
