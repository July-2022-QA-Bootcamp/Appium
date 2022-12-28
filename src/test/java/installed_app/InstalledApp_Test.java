package installed_app;

import org.testng.annotations.Test;

import base.BaseClass;

public class InstalledApp_Test extends BaseClass{

	@Test
	public void test() {
		int [] arr = {2, 4, 692, 43, 22, 777, 10000, 500};
		calculator.getSumTotal(arr);
	}
}
