package testngExample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	@BeforeGroups("Sanity")
	public void Beforegroup() {
		System.out.println("Inside before group");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside before Test");
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside before Method");
	}
	
	@AfterMethod	
	public void afterMethod() {
		
		System.out.println("Inside after Method");
			
		}
	@AfterTest
	public void afterTest() {
		System.out.println("Inside After Test");
		
	}
}
