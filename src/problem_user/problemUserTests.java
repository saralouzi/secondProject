package problem_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class problemUserTests {

	WebDriver driver = new ChromeDriver();
	String username = "problem_user"; 
	String passwordInput = "secret_sauce";
	String myWebsite = "https://www.saucedemo.com";
	
	@BeforeTest 
	public void MySetup () {
		driver.get(myWebsite);
		driver.manage().window().maximize();
	} 
	
	@Test (priority = 1)
	public void Login () {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(passwordInput);
		driver.findElement(By.id("login-button")).click();
	} 
	
	@Test (priority =2)
	public void AddToCart () throws InterruptedException {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		
	}
	
	@Test (priority =3)
	public void RemoveItem () throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
	}
	@AfterTest 
	public void PostTesting () throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
