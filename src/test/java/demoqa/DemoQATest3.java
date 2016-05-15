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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQATest3 {
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
	
	/* Product category tests */
	@Test
	public void testcase1_product_category_accessories() {
		   Actions action = new Actions(driver);
		   WebElement prodcategory = driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"));
		   action.moveToElement(prodcategory).moveToElement(driver.findElement(By.id("menu-item-34"))).click().build().perform();
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.entry-title")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		   WebElement header = driver.findElement(By.cssSelector("h1.entry-title"));
		   String headtext=header.getText();
		   Boolean headerfound=false;
		   //System.out.println(headtext);
		   if(headtext.equals("Accessories")){headerfound=true;}
		   Assert.assertTrue("Accessories not found", headerfound);
	}
	@Test
	public void testcase2_product_category_imacs(){
		   Actions action = new Actions(driver);
		   WebElement prodcategory = driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"));
		   action.moveToElement(prodcategory).moveToElement(driver.findElement(By.id("menu-item-35"))).click().build().perform();
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.entry-title")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		   WebElement header = driver.findElement(By.cssSelector("h1.entry-title"));
		   String headtext=header.getText();
		   Boolean headerfound=false;
		   //System.out.println(headtext);
		   if(headtext.equals("iMacs")){headerfound=true;}
		   Assert.assertTrue("iMacs not found", headerfound);

	}
	@Test
	public void testcase3_product_category_ipads(){
		   Actions action = new Actions(driver);
		   WebElement prodcategory = driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"));
		   action.moveToElement(prodcategory).moveToElement(driver.findElement(By.id("menu-item-36"))).click().build().perform();
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.entry-title")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
			   WebElement header = driver.findElement(By.cssSelector("h1.entry-title"));
			   String headtext=header.getText();
			   Boolean headerfound=false;
			   //System.out.println(headtext);
			   if(headtext.equals("iPads")){headerfound=true;}
			   Assert.assertTrue("iPads not found", headerfound);
	}
	@Test
	public void testcase4_product_category_iphones(){
		   Actions action = new Actions(driver);
		   WebElement prodcategory = driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"));
		   action.moveToElement(prodcategory).moveToElement(driver.findElement(By.id("menu-item-37"))).click().build().perform();
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.entry-title")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
			   WebElement header = driver.findElement(By.cssSelector("h1.entry-title"));
			   String headtext=header.getText();
			   Boolean headerfound=false;
			   //System.out.println(headtext);
			   if(headtext.equals("iPhones")){headerfound=true;}
			   Assert.assertTrue("iPhones not found", headerfound);
	}
	@Test
	public void testcase5_product_category_ipods(){
		   Actions action = new Actions(driver);
		   WebElement prodcategory = driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"));
		   action.moveToElement(prodcategory).moveToElement(driver.findElement(By.id("menu-item-38"))).click().build().perform();
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.entry-title")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
			   WebElement header = driver.findElement(By.cssSelector("h1.entry-title"));
			   String headtext=header.getText();
			   Boolean headerfound=false;
			   //System.out.println(headtext);
			   if(headtext.equals("iPods")){headerfound=true;}
			   Assert.assertTrue("iPods not found", headerfound);
	}
	@Test
	public void testcase6_product_category_macbooks(){
		   Actions action = new Actions(driver);
		   WebElement prodcategory = driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"));
		   action.moveToElement(prodcategory).moveToElement(driver.findElement(By.id("menu-item-39"))).click().build().perform();
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.entry-title")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
			   WebElement header = driver.findElement(By.cssSelector("h1.entry-title"));
			   String headtext=header.getText();
			   Boolean headerfound=false;
			   //System.out.println(headtext);
			   if(headtext.equals("MacBooks")){headerfound=true;}
			   Assert.assertTrue("MacBooks not found", headerfound);
	}
}
