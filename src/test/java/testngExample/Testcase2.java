package testngExample;

import org.testng.annotations.Test;

public class Testcase2 extends BaseClass{
	
	@Test(groups= {"Sanity"})
    public void Insurancetest() {
		System.out.println("inside insurance test");
	}

}
