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

public class DemoQATest5 {

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
	public void testcase1_seach_and_addtocart_checkout() {
		   WebElement search = driver.findElement(By.xpath("//input[@class='search']"));
		   search.sendKeys("iphone 5\n");
		   WebDriverWait wait = new WebDriverWait(driver, 25);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		   WebElement header = driver.findElement(By.xpath("//a[@title='iPhone 5']"));
		   header.click();
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.prodtitle")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
           WebElement tocart=driver.findElement(By.xpath("//input[@value='Add To Cart']"));
           tocart.click();
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("go_to_checkout")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
        WebElement gocheckout = driver.findElement(By.xpath("//a[@class='go_to_checkout']"));
        gocheckout.click();
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Remove']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
        WebElement remove=driver.findElement(By.xpath("//input[@value='Remove']"));
        remove.click();
        boolean removed2=false;
        try{
     	   boolean removed=driver.findElement(By.xpath("//input[@value='Remove']")).isDisplayed();
     	   if (removed){
     		   System.out.println("Product remove faied");
     	   }
        }catch (Exception e){
     	   removed2=true;
        }
        Assert.assertTrue("iPhone 5 not removed", removed2);

	}
	
	@Test
	public void testcase2_seach_and_continue_shopping(){
		   WebElement search = driver.findElement(By.xpath("//input[@class='search']"));
		   search.sendKeys("iphone 5\n");
		   WebDriverWait wait = new WebDriverWait(driver, 25);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		   WebElement header = driver.findElement(By.xpath("//a[@title='iPhone 5']"));
		   header.click();
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.prodtitle")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
        WebElement tocart=driver.findElement(By.xpath("//input[@value='Add To Cart']"));
        tocart.click();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
             // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("go_to_checkout")));
	         // wait.pollingEvery(100, TimeUnit.MILLISECONDS);
     WebElement continueshop = driver.findElement(By.xpath("//div[@class='popup']/div[@class='group']/a[2]"));
     continueshop.click();
     WebElement shoppingcart = driver.findElement(By.cssSelector("a.cart_icon"));
     shoppingcart.click();
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Remove']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
     WebElement remove=driver.findElement(By.xpath("//input[@value='Remove']"));
     remove.click();
     boolean removed2=false;
     try{
  	   boolean removed=driver.findElement(By.xpath("//input[@value='Remove']")).isDisplayed();
  	   if (removed){
  		   System.out.println("Product remove faied");
  	   }
     }catch (Exception e){
  	   removed2=true;
     }
     Assert.assertTrue("iPhone 5 not removed", removed2);

	}

}
