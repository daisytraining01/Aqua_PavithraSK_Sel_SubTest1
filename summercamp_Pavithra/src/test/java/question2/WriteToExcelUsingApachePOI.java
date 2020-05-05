package question2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteToExcelUsingApachePOI {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Testing Softwares\\Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/sql/sql_syntax.asp");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
		driver.manage().window().maximize();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']//tr"));

		File src = new File("./testdata/test.xlsx");
		FileInputStream fis = new FileInputStream(src);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh1 = wb.getSheetAt(0);

		for (int i = 0; i < rows.size(); i++) {

			List<WebElement> columns = rows.get(i).findElements(By.tagName("th"));

			for (int j = 0; j < columns.size(); j++) {
				String data = columns.get(j).getText().toString();
				sh1.getRow(i).createCell(j).setCellValue(data);

			}

		}

		for (int i = 1; i < rows.size(); i++) {

			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < columns.size(); j++) {
				String data = columns.get(j).getText().toString();
				sh1.getRow(i).createCell(j).setCellValue(data);

			}

		}
		
		FileOutputStream fout=new FileOutputStream(new File("location of file/filename.xlsx"));
		 wb.write(fout);
		 fout.close();

	}

}
