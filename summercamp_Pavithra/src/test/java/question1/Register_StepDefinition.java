package question1;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Register_StepDefinition {
	
	public static WebDriver driver;
	HSSFWorkbook wb;
	HSSFSheet sheet;
	FileInputStream fis;
	DateFormat dateFormat;
	Date date;
	
	

	@Given("^the user launches the url$")
	public void the_user_launches_the_url() throws Throwable {
	    
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Softwares\\Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
		driver.manage().window().maximize(); 
	    
	}

	@Then("^the user successfully registers in the site$")
	public void the_user_successfully_registers_in_the_site() throws Throwable {
		
		 fis = new FileInputStream("./testdata/testdata.xlsx");
         wb = new HSSFWorkbook(fis);
         sheet = wb.getSheet("testdata");
         
         for(int count = 1;count<=sheet.getLastRowNum();count++){
             HSSFRow row = sheet.getRow(count);
             
             
             driver.findElement(By.linkText("Register here")).click();             
             Thread.sleep(5000);
             
             WebElement Firstname = driver.findElement(By.name("firstName"));
             Firstname.sendKeys(row.getCell(0).toString());
             
             WebElement LastName = driver.findElement(By.name("lastName"));
             LastName.sendKeys(row.getCell(1).toString());
             
             WebElement Phone = driver.findElement(By.name("phone"));
             Phone.sendKeys(row.getCell(2).toString());
             
             WebElement Email = driver.findElement(By.name("userName"));
             Email.sendKeys(row.getCell(3).toString());
             
             WebElement Address = driver.findElement(By.name("address1"));
             Address.sendKeys(row.getCell(4).toString());
             
             WebElement City = driver.findElement(By.name("city"));
             City.sendKeys(row.getCell(5).toString());
             
             WebElement State = driver.findElement(By.name("state"));
             State.sendKeys(row.getCell(6).toString());
             
             WebElement PostalCode = driver.findElement(By.name("postalCode"));
             PostalCode.sendKeys(row.getCell(7).toString());
             
             WebElement country = driver.findElement(By.name(row.getCell(8).toString()));  
             Select dd = new Select(country); 
             dd.selectByValue(row.getCell(9).toString()); 
             
             WebElement UserName = driver.findElement(By.name("email"));
             UserName.sendKeys(row.getCell(10).toString());
             
             WebElement Password = driver.findElement(By.name("password"));
             Password.sendKeys(row.getCell(11).toString());
             driver.findElement(By.name("confirmPassword")).sendKeys(row.getCell(13).toString());      
             
                  
             //Actions Class
             WebElement submit = driver.findElement(By.name("submit"));
             Actions ac = new Actions(driver);
             ac.click(submit);
             
            
             String success = driver.findElement(By.xpath("(//font/b)[2]")).getText();
             System.out.println(success);
             
             if(success.contains(row.getCell(10).toString()))
             {
                 System.out.println("Registeration Successfull");
             }
             else
             {
                 System.out.println("Registeration Falied");
             }
             
             System.out.println("First Name "+Firstname.getAttribute("value"));
             System.out.println("Last Name "+LastName.getAttribute("value"));
             System.out.println("Phone "+Phone.getAttribute("value"));
             System.out.println("Email "+Email.getAttribute("value"));
             System.out.println("Address "+Address.getAttribute("value"));
             System.out.println("City "+City.getAttribute("value"));
             System.out.println("State "+State.getAttribute("value"));
             System.out.println("Country "+country.getAttribute("value"));
             System.out.println("UserName "+UserName.getAttribute("value"));
             
             dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
     		 date = new Date();
             
             File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     		
     		File dest = new File("D:\\workspace\\Srisha\\Screens\\Result "+ dateFormat.format(date)+".png");
     		FileUtils.copyFile(scr, dest);
         }
		
	    
	}		
		
		

	

}
