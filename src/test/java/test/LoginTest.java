package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class LoginTest {
	WebDriver driver;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		LoginTest obj=new LoginTest();
//		
//		obj.setup();
//		obj.testcase1();
//		obj.cleanup();
//		}
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	
	@BeforeMethod
	public void setup() throws IOException {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		 driver=new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		FileInputStream fis= new FileInputStream("Example.xlsx");
		wbook= new XSSFWorkbook(fis);
		sheet= wbook.getSheet("data");
		
	}
	@Test
    @Parameters({"username","password"})
	public void testcase1(String username, String password) {

		WebElement LoginLink=driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		
		WebElement Username=driver.findElement(By.name("user_login"));
		WebElement Password=driver.findElement(By.id("password"));
		WebElement Remember=driver.findElement(By.className("rememberMe"));
		
		WebElement LoginBtn=driver.findElement(By.name("btn_login"));
		
		String excelUsername=sheet.getRow(0).getCell(0).getStringCellValue();
		String excelPassword=sheet.getRow(0).getCell(1).getStringCellValue();
		
		Username.sendKeys(excelUsername);
		Password.sendKeys(excelPassword);
		Remember.click();
		
		LoginBtn.click();
		
		WebElement Error=driver.findElement(By.className("error_msg"));
		
		String ActError=Error.getText();
		String ExpError="The email or password you have entered is invalid.";
		
//		if(ActError.equals(ExpError)) {
//			System.out.println("Tc passed");
//		}
//		else {
//			System.out.println("Tc failed");
//		}
		
		Assert.assertEquals(ActError, ExpError);
		
		
		List<WebElement> Links=driver.findElements(By.tagName("a"));
		System.out.println(" total links " + Links.size() );
		
		
	}
	@AfterMethod
	public void cleanup() {
		driver.quit();
		
		
	}

}
