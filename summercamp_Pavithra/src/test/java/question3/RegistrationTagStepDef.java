package question3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationTagStepDef {

	public static WebDriver driver;

	@Given("^the user launch the url$")
	public void the_user_launch_the_url() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "D:\\Testing Softwares\\Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
		driver.manage().window().maximize();

	}

	@When("^the user enters the data$")
	public void the_user_enters_the_data() throws Throwable {

		driver.findElement(By.linkText("REGISTER")).click();

		Thread.sleep(5000);

		driver.findElement(By.name("firstName")).sendKeys("Hello");
		driver.findElement(By.name("lastName")).sendKeys("World");
		driver.findElement(By.name("phone")).sendKeys("9876543210");
		driver.findElement(By.name("userName")).sendKeys("Welcome");

		driver.findElement(By.name("address1")).sendKeys("234");
		driver.findElement(By.name("city")).sendKeys("Bangalore");
		driver.findElement(By.name("state")).sendKeys("Karnataka");
		driver.findElement(By.name("postalCode")).sendKeys("580028");
		WebElement country = driver.findElement(By.name("country"));
		Select dd = new Select(country);
		dd.selectByValue("INDIA");

		driver.findElement(By.name("email")).sendKeys("Maveric123@abc.com");
		driver.findElement(By.name("password")).sendKeys("Maveric123");
		driver.findElement(By.name("confirmPassword")).sendKeys("Maveric123");

	}

	@When("^Click Submit button$")
	public void click_Submit_button() throws Throwable {

		driver.findElement(By.name("submit")).click();

	}

	@Then("^The user should be registered successfully$")
	public void the_user_should_be_registered_successfully() throws Throwable {

		if (driver.getPageSource().contains("Thank you for registering.") == true) {
			System.out.println("User Successfully Registered");
		} else {
			System.out.println("User Registration Failed");
		}
	}

}
