package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import init.InitClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class PurchaseOrderTest extends InitClass {
	
	
	
	@Test
	public void VerifyRegisterAndPurchase() throws InterruptedException, IOException {
		
		// Specify the base URL to the RESTful web service 
		RestAssured.baseURI = "https://randomuser.me/api/"; 
		// Get the RequestSpecification of the request to be sent to the server. 
		RequestSpecification httpRequest = RestAssured.given(); 
		// specify the method type (GET) and the parameters if any. 
		//In this case the request does not take any parameters 
		Response response = httpRequest.get();
		ResponseBody allHeaders = response.getBody();
		

			System.out.println(allHeaders.asString());
			JsonPath value =response.jsonPath();
			
			String fname =value.getString("results[0].name.first");
			String lname =value.getString("results[0].name.last");
			String email =value.getString("results[0].email");
			String password =value.getString("results[0].login.password");
		
		
		
	Thread.sleep(2000);	
	
	driver.findElement(By.xpath("(//a[text()='Create an Account'])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(fname);
	driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lname);
	driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
	//driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sita@12345");
	driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("Sita@12345");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();
	Thread.sleep(2000);
	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'message-success')]")).getText().contains("Thank you for registering with Fake Online Clothing Store."));
	Thread.sleep(2000);
	// Locating the Main Menu (Parent element)
	WebElement mainMenu = driver.findElement(By.xpath("//span[text()='Women']"));

	//Instantiating Actions class
	Actions actions = new Actions(driver);

	//Hovering on main menu
	actions.moveToElement(mainMenu);

	// Locating the element from Sub Menu
	WebElement subMenu1 = driver.findElement(By.xpath("(//span[text()='Tops'])[1]"));
	
	actions.moveToElement(subMenu1);
	
	WebElement subMenu2 = driver.findElement(By.xpath("(//span[text()='Jackets'])[1]"));
	
	actions.moveToElement(subMenu2);
	
	actions.click().build().perform();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//img)[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//div[@index='1'])[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//div[@index='1'])[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("(//a[@class='action showcart']/span)[2]")));
	driver.findElement(By.xpath("(//a[@class='action showcart']/span)[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
	Thread.sleep(3000);
	
	js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//input[@name='street[0]']")));
	driver.findElement(By.xpath("//input[@name='street[0]']")).sendKeys("B501");
	js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//input[@name='city']")));
	driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Gurgaon");
	js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//select[@name='region_id']")));
	 Select state = new Select(driver.findElement(By.xpath("//select[@name='region_id']")));
	 state.selectByVisibleText("Alaska");
	 js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//input[@name='postcode']")));
	driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("12345-6789");
	js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//input[@name='telephone']")));
	driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("1212121212");
	driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
	Thread.sleep(3000);
	js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[text()='Next']")));
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	Thread.sleep(4000);
	js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[text()='Place Order']")));
	driver.findElement(By.xpath("//span[text()='Place Order']")).click();
	Thread.sleep(5000);
	Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@class,'base')]")).getText().contains("Thank you for your purchase!"));
	Thread.sleep(2000);
	
	   

	
	}
	
}
