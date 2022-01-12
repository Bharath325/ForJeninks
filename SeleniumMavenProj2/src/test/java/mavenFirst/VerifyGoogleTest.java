package mavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyGoogleTest {
	public static void main(String args[]) {

	}

	WebDriver driver;

	@BeforeMethod
	public void setbrowser() {

		System.setProperty("webdriver.edge.driver", "C:\testingSoftware\\edgedriver_win32\\msedgedriver.exe");
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
