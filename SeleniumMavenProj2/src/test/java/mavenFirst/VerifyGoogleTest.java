package mavenFirst;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyGoogleTest {
	public static void main(String args[]) {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("EDGE_HOME"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("In finally");
		}
	}

	WebDriver driver;

	@BeforeMethod
	public void setbrowser() {
//		Properties prop = new Properties();
//		InputStream input = null;
//		input = new FileInputStream("config.properties");
//		prop.load(input);
//		System.setProperty("webdriver.edge.driver", prop.getProperty("EDGE_HOME"));
		try {
			System.setProperty("webdriver.edge.driver", "C:\\testingSoftware\\edgedriver_win644\\msedgedriver.exe");
		} catch (Exception e) {
			System.out.println("Driver problem");
		}
		driver = new EdgeDriver();
		driver.get("http://google.com/");
		driver.manage().window().maximize();
		System.out.println("Opening browser");
	}

	@Test
	public void checkTitle() {
		System.out.println("checking title");
		Assert.assertEquals(driver.getTitle(), "Google");
	}

	@Test(priority = 1)
	public void checklogo() {
		System.out.println("checking logo");
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed());
	}

	@AfterMethod
	public void closeWindow() {
		driver.quit();
	}
}
