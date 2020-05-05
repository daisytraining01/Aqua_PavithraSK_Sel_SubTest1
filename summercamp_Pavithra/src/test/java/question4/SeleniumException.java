package question4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumException {

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\Testing Softwares\\Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
		driver.manage().window().maximize();

		WebElement linkRegister = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText("REGISTER")));

		linkRegister.click();

		Thread.sleep(5000);

		driver.findElement(By.name("firstName")).sendKeys("Hello");
		driver.findElement(By.name("lastName")).sendKeys("World");
		driver.findElement(By.name("phone")).sendKeys("9876543210");
		driver.findElement(By.name("userName")).sendKeys("Welcome");

		// NosuchElement exception
		try {
			driver.findElement(By.name("address1")).sendKeys("234");
		} catch (NoSuchElementException e) {
			System.out.println("No Element Found");
		}

		driver.findElement(By.name("city")).sendKeys("Bangalore");
		driver.findElement(By.name("state")).sendKeys("Karnataka");
		driver.findElement(By.name("postalCode")).sendKeys("580028");
		WebElement country = driver.findElement(By.name("country"));

		// Elementnotselectible
		try {
			Select dd = new Select(country);
			dd.selectByValue("INDIA");
		} catch (ElementNotSelectableException e) {
			e.getMessage();
		}
		driver.findElement(By.name("email")).sendKeys("Maveric123@abc.com");
		driver.findElement(By.name("password")).sendKeys("Maveric123");
		driver.findElement(By.name("confirmPassword")).sendKeys("Maveric123");

		// Retrying 3 times for staleElement
		for (int i = 0; i < 3; i++) {
			try {
				driver.findElement(By.name("submit")).click();
				break;
			} catch (StaleElementReferenceException e) {
				e.getMessage();

			}
		}

		// NoAlertPresentException
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.out.println("No alert present");
		}

		driver.quit();

	}

}
