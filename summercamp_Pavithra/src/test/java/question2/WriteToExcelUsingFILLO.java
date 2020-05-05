package question2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class WriteToExcelUsingFILLO {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException, Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\Testing Softwares\\Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/sql/sql_syntax.asp");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
		driver.manage().window().maximize();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']//tr"));
		
			
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection("./testdata/testFillo.xlsx");
		
		for (int i = 0; i < rows.size(); i++) {

			List<WebElement> headers = rows.get(i).findElements(By.tagName("th"));
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < columns.size(); j++) {
				String Column = headers.get(j).getText().toString();
				String Value = columns.get(j).getText().toString();
				String strQuery="INSERT INTO sheet1("+Column+") VALUES('"+Value+"')";
				connection.executeUpdate(strQuery);
			}

		}


	}

}
