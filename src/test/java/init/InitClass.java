package init;




import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;





public class InitClass {

	
	//Driver Launch
	
	public static ChromeOptions options= new ChromeOptions();
	public static EdgeOptions edgeoptions= new EdgeOptions();
	public static WebDriver driver;
	
	
	
	
	@BeforeTest

	public void launchBrowser() throws InterruptedException {
		
		
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\614296257\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
		
		driver = new EdgeDriver();
		

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//URL
		driver.get("https://magento.softwaretestingboard.com/");
		
		
}
	
	
	
	
	
	
	
	@AfterTest
	public void closeDriver() {
		
		
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
}