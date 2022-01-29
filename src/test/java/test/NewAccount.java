package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement NewAccount=driver.findElement(By.xpath("//*[text()='Create New Account']"));
		
		NewAccount.click();
		
		WebElement Month=driver.findElement(By.xpath("//*[@id='month']"));
		
		Select MonthDropDown=new Select(Month);
		
		MonthDropDown.selectByVisibleText("jan");
		
	}

}
