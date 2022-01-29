package testngExample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 extends BaseClass {
	
	
	

	@Test(priority=0, description="this is personal loan test",groups= {"Sanity"})


	public void LoanTest() {
		System.out.println("Inside Loan Test");
	}
	
	@Test
	public void LoanTest1() {
		System.out.println("Inside Loan Test1");
	}
	

	@Test
	public void Creditcard() {
		System.out.println("Inside CC Test");
	}

}
