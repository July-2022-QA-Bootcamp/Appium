package sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumInstalledAppTest {

	static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.ANDROID);
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		dc.setCapability("appPackage", "com.google.android.calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new RemoteWebDriver(url, dc);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(enabled = false)
	public void installed_calculator_test() throws MalformedURLException, InterruptedException {
		WebElement digit_5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		WebElement digit_6 = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
		WebElement addElement = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		WebElement equalElement = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		
		Thread.sleep(3000);
		
		digit_5.click();
		addElement.click();
		digit_6.click();
		equalElement.click();
		
		WebElement resultElement = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		
		String resultValue = resultElement.getText();
		
		System.out.println("Result is : " + resultValue);
	}
	
	@Test()
	public void dynamicSumTotal() throws InterruptedException {
		int finalResult = getSumTotal(9, 8);
		System.out.println("Result is : " + finalResult);
		Assert.assertEquals(finalResult, 17);
		getSumTotal(1, 2, 3, 5, 6);
	}
	
	public static int getSumTotal(int a, int b) throws InterruptedException {
		if(a < 10 && b < 10) {
			WebElement first_digit = driver.findElement(By.id("com.google.android.calculator:id/digit_"+a));
			WebElement second_digit = driver.findElement(By.id("com.google.android.calculator:id/digit_"+b));
			WebElement addElement = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
			WebElement equalElement = driver.findElement(By.id("com.google.android.calculator:id/eq"));
			
			Thread.sleep(3000);
			
			first_digit.click();
			addElement.click();
			second_digit.click();
			equalElement.click();
			
			WebElement resultElement = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
			
			String resultValue = resultElement.getText();
			
			return Integer.parseInt(resultValue);
		}else {
			return 0;
		}
	}
	
	public static int getSumTotal(int... arr) {
		return 0;
	}
}
