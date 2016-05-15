package demoqa;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQATest4 {

	protected static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		   System.setProperty("webdriver.chrome.driver", "/home/etxmsl/TEST15/Testautomatisering/Selenium/demoqa.com/chromedriver");
		   if(driver == null){
		       driver=new ChromeDriver();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	   	   if(driver != null){
		      driver.close();
	       }
	}

	@Before
	public void loadpage(){
	       driver.get("http://store.demoqa.com");
	       PageFactory.initElements(driver, this);
	       driver.manage().window().setSize(new Dimension(1024,768));
	}

	@Test
	public void search_product() {
		   WebElement search = driver.findElement(By.xpath("//input[@class='search']"));
		   search.sendKeys("iphone 5\n");
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		   WebElement header = driver.findElement(By.xpath("//a[@title='iPhone 5']"));
		   header.click();
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.prodtitle")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
           boolean prodheader=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
           Assert.assertTrue("iPhone5 not found", prodheader);
	}

}
