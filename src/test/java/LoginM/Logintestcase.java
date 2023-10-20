package LoginM;

import org.testng.annotations.Test;

import GenaricUtility.BaseClass;

public class Logintestcase extends BaseClass
{
  @Test
	public void TC_Login_001() {
		System.out.println("First test case");
		System.out.println(driver.getCurrentUrl());
	}
  
}
