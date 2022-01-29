package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		List<WebElement> Rows=driver.findElements(By.xpath("//*[@id='customers']/tbody/tr"));
		System.out.println("total rows are "+Rows.size());
		
		List<WebElement> Columns=driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/th"));
		System.out.println("total rows are "+Columns.size());
		
		WebElement GetText=driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[4]/td[1]"));
		//System.out.println("Text are " + GetText.getText());
		
		for(int index=2; index<=Rows.size(); index++) {
			WebElement data1=driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+ index +"]/td[1]"));
			WebElement data2=driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+ index +"]/td[2]"));
			WebElement data3=driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+ index +"]/td[3]"));
			
			System.out.println(data1.getText() + "\t\t" + data2.getText() + "\t\t" + data3.getText());
			
			WebElement Scrollto=driver.findElement(By.xpath("//*[text()='Table Rows']"));
			
			JavascriptExecutor obj=(JavascriptExecutor)driver;
			obj.executeScript("arguments[0].scrollIntoView()",Scrollto);
			
		}
	}

}
