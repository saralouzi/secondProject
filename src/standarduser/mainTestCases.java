package standarduser;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mainTestCases {

	WebDriver driver = new ChromeDriver();
	String myWebsite = "https://www.saucedemo.com";
	String user_name = "standard_user";
	String passwordInput = "secret_sauce";
	Random rand = new Random();

	@BeforeTest
	public void MySetup() {
		driver.get(myWebsite);
		driver.manage().window().maximize();
		// driver.manage().window().minimize();
		// driver.manage().window().fullscreen();

	}

	@Test(priority = 1)
	public void Login() {

		// i can ask for info from the system in both ways considering everything is a
		// webelement
		// i cant write an action in the same line as definition
// First way (clean code)
		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInputField.sendKeys(user_name);
		PasswordInputField.sendKeys(passwordInput);
		LoginButton.click();

//second way 		
		// driver.findElement(By.id("password")).sendKeys(passwordInput);
		// driver.findElement(By.id("login-button")).click();
	}

	@Test(priority = 2, enabled = false)
	public void AddItemToCart() throws InterruptedException {
		Thread.sleep(2000);

		// ma bnfa3 adal adawer 3la el id for each item to add it w a3mallo code special
		// so i use the class instead
//		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

		// wrong code using classes
//		driver.findElements(By.className("btn")).get(0).click();
//		driver.findElements(By.className("btn")).get(1).click();
//		driver.findElements(By.className("btn")).get(2).click();
//		driver.findElements(By.className("btn")).get(3).click();
//		driver.findElements(By.className("btn")).get(4).click();
//		driver.findElements(By.className("btn")).get(5).click();

		// array starts from number 0 till last-1 ya3ni 3ndi 6 items in this case
		// if e have 200 items last item's number would be 199
		// in such cases we use for loop instead of writing code for adding 200 items
// الهدف اني مااعمل add to cart لكل عنصر لحاله فهيك هو لحاله بعتمد على ال length and index and condition 
		// use smth called List -same idea as array-

		// if used this code it wont get the text inside the get rh y36eni esmo bl code
		// msh whats inside
		// System.out.println(driver.findElements(By.className("btn")).get(0));
		// i need to add smth mshan yfham that i need whats inside 0
		// System.out.println(driver.findElements(By.className("btn")).get(0).getText());

		// correct code using for loop
		// webelement is considered now as a datatype
		// for (/identify/ i = 0; /add condition to i/ i<6 if i leave it as 6 then then
		// code will stop
		// running at the 5 item regardless of the amount i actually have so i need smth
		// to
		// keep it running no matter how many items i add to the test ex.
		// AddToCartButtons.size();
		// here we have dynamic values not static; counter i++ it means keep adding one
		// to i till we reach
		// the condition ){}size = length

		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();
		}
	}

	// try out adding left side products or rights side products by changing the
	// value of i or i+=2
	// dont forget tests are enabled

	@Test(priority = 3, enabled = false)
	public void RemoveItemFromCart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
	}

	@Test(priority = 3, enabled = false)
	public void AddCertainNumberOfItems() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();
			if (i == 2) {
				break;
			}
			// i cant write anything after break (dead code)
			// if i put the break line before the get like this then it wont
			// take the value of element of index 2

			// like this:
			// if (i==2) {break;}
			// AddToCartButtons.get(i).click();

		}
	}
// this test will add all items till it reaches number 2 add it then stop 
	// Break = stop

	@Test(priority = 3, enabled = false)
	public void SkipOnCertainItem() {

		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();
			if (i == 2) {
				continue;
			}
		}
		// in this test the program will add all items except num 2
		// continue = skip

		// ex : if (i==2) {continue;} followed by if (i == 0 ) {break;}
		// wont add anything first condition is okay second is out of loop

		// ex: if (i==0){continue;} if (i ==2) {continue;}
		// will add all except item with index 0 and 2

		// ex: if (i==0 || i==2) {continue;}
		// no need to write two if statements

		// ex: if (i==0 && i==2) {continue;}
		// i here cant have two ids at the same time so it wont run code at all
		// the position of break and continue in code is VERY IMPORTANT

	}

	@Test(priority = 3, enabled = false)
	public void AddItemsThatStartWithSauce() {
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < ItemsNames.size(); i++) {
			// System.out.println(ItemsNames.get(i));
			// بهاي الحالة لو تركت جملة الطباعة زي ما هي رح يعطيني اسماءهم بالكمبيوتر مش
			// الاسم اللي بشوفه المستخدم --- بعدل عليها
			// جملة طباعة ما حدا بشوفها غيري

			// System.out.println(ItemsNames.get(i).getText().startsWith("Sauce"));
			// getText lazm traje3 datatype of type string, its useful if i want
			// to print with ToUpperCase/ToLowerCase/StartWith
			// startwith method that returns BOOLEAN datatype --> result: true -
			// true-true-true-true-false

			if ((ItemsNames.get(i).getText().startsWith("Sauce"))) {
				continue;

				// يعني لما تجيبلي كل العناصر و تبلش تلف عليهم ازا كان ببلش بكلمة الشرط جيب زر
				// الاضافة و اكبس عليه
				// if i want it to skip on all items that start with condition
				// we can use continue but it must be before click
			}
			AddToCartButtons.get(i).click();

		}
	}

	@Test(priority = 3)
	public void AddRandomItems() throws InterruptedException {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		int randomIndex = rand.nextInt(AddToCartButtons.size());
		System.out.println(randomIndex);
		AddToCartButtons.get(randomIndex).click();

		// Math.random () usually gives back double datatype but i cant use it for index
		// as it cant be seen as double number "always int"
		// System.out.println(Math.random()*AddToCartButtons.size());
		// --> when run result was 0.8737428935407846
// random gives back random numbers everytime 
		// when i added the * size the largest number ill get is 5.99999999999
		// as the max num of items of index that can be * is 5

		// System.out.println(Math.floor(6.3)); --> when run result is 6
		// floor returns the closest lower integer number
		// System.out.println(Math.floor(Math.random()*AddToCartButtons.size()));

		// int randomItem = Math.floor(Math.random()*AddToCartButtons.size());
		// here i cant use this line cause theres datatype mismatch

		// AddToCartButtons.get(randomItems); --> get only takes int values while
		// this floor line gives double value so we use RANDOM.RAND

		// System.out.println(Math.ceil(89.2)); --> returns the closest higher
		// integer number
		//IF I WANT TO REMOVE ITEMS FROM CART 
		Thread.sleep(3000);
		WebElement RemoveButton = driver.findElement(By.className("btn_secondary"));
	    RemoveButton.click();
	}

	@Test(priority = 4, enabled = false )
	public void CheckOutProcess() {

		WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_link"));
		ShoppingCart.click();
		WebElement CheckoutButton = driver.findElement(By.id("checkout"));
		CheckoutButton.click();
		WebElement FirstNameInput = driver.findElement(By.id("first-name"));
		WebElement LastNameInput = driver.findElement(By.id("last-name"));
		WebElement PostalCodeInput = driver.findElement(By.id("postal-code"));

		// Array of first names
		String[] firstNames = { "Alice", "Bob", "Charlie", "Diana", "Edward" };
		// Random of first names --> we use length with arrays no size
		int RandomFirstName = rand.nextInt(firstNames.length);
		// Array of last names
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones" };
		// Random of last names
		int RandomLastName = rand.nextInt(lastNames.length);
		// Array of postal codes
		String[] PostalCodes = { "12345", "65877", "25647", "12458", "32569" };
		// random pf postal codes
		int RandomPostalCode = rand.nextInt(PostalCodes.length);

		FirstNameInput.sendKeys(firstNames[RandomFirstName]);
		LastNameInput.sendKeys(lastNames[RandomLastName]);
		PostalCodeInput.sendKeys(PostalCodes[RandomPostalCode]);

		WebElement ContinueButton = driver.findElement(By.id("continue"));
		ContinueButton.click();
		WebElement FinishButton = driver.findElement(By.id("finish"));
		FinishButton.click();
		//WebElement BackHomeButton = driver.findElement(By.id("back-to-products"));
		//BackHomeButton.click();
	}

	@Test(priority = 4, enabled = false)
	public void Logout() throws InterruptedException {

		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

	@AfterTest(enabled = false)
	public void PostTesting() {
		driver.quit();

	}

}
