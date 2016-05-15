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

public class DemoQATest6 {

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
	public void testcase1_a_empty_cart_i() {
	       WebElement shoppingcart = driver.findElement(By.cssSelector("a.cart_icon"));
	       shoppingcart.click();
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='entry-content']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       String carttext;
	       WebElement divtext=driver.findElement(By.xpath("//div[@class='entry-content']"));
	       carttext=divtext.getText();
	       boolean noitem=false;
	       if(carttext.contains("Oops, there is nothing in your cart")){
	    	  noitem=true;
	       }
           Assert.assertTrue("No empty cart text match", noitem);

	}
    @Test
    public void testcase2_a_no_continue_ii(){
	       WebElement shoppingcart = driver.findElement(By.cssSelector("a.cart_icon"));
	       shoppingcart.click();
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='entry-content']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       boolean continuebott=false;
	       try{
               continuebott=driver.findElement(By.className("step2")).isDisplayed();
	       }catch (Exception e){
	    	   System.out.println("Continue bottom not found");
	       }
	       Assert.assertFalse("Contunue bottom found", continuebott);
    }
	@Test
	public void testcase3_b_c_cart_verify(){
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
           boolean prodimage=driver.findElement(By.cssSelector("img.product_image")).isDisplayed();
           int numprod = driver.findElements(By.xpath("//td[@class='wpsc_product_name wpsc_product_name_0']")).size();
           WebElement iphone5 = driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/n/']"));
           String s_iphone5=iphone5.getText();
           boolean b_iphone5=false;
           if (s_iphone5.equals("iPhone 5")){b_iphone5=true;}
           boolean quantity1=driver.findElement(By.xpath("//input[@value='1']")).isDisplayed();
           boolean pricedisplay=driver.findElement(By.cssSelector("span.pricedisplay")).isDisplayed();
           boolean numprod1=false;
           if(numprod==1){numprod1=true;}
           WebElement remove=driver.findElement(By.xpath("//input[@value='Remove']"));
           remove.click();
           Assert.assertTrue("Product not displayed correctly", prodimage&&b_iphone5&&quantity1&&pricedisplay&&numprod1);    
	}
	
	@Test
	public void testcase4_d_quantity_i_ii(){
		   WebElement search = driver.findElement(By.xpath("//input[@class='search']"));
		   search.sendKeys("iphone 5\n");
		   WebDriverWait wait = new WebDriverWait(driver, 15);
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
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='quantity']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       WebElement quantity = driver.findElement(By.xpath("//input[@name='quantity']"));
	       String quantity_begin=quantity.getAttribute("value");
	       boolean quantity1=false;
	       if (quantity_begin.equals("1")){quantity1=true;}
           //int price1;
           //int price2;
           boolean pricechanged=false;;
           boolean itemremoved=false;
		   boolean iphonefound=false;
		   System.out.println("Quantity begin: "+quantity_begin);
		   System.out.println("Quatity1: "+quantity1);
		   if (quantity1){
			   WebElement updatebuttom = driver.findElement(By.xpath("//input[@value='Update']"));
			   WebElement total = driver.findElement(By.xpath("//span[@class='pricedisplay']"));
			   String s_price1=total.getText();
			   System.out.println("Start price: "+s_price1);
			   quantity.sendKeys("\b2");
			   updatebuttom.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='pricedisplay']")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		          WebElement total2 = driver.findElement(By.xpath("//span[@class='pricedisplay']"));
			   String s_price2=total2.getText();
			   System.out.println("Updated price: "+s_price2);
			   if (s_price1.equals(s_price2)){
				   pricechanged = false;
			   }else{
				   pricechanged=true;
			   }
			   WebElement quantity2 = driver.findElement(By.xpath("//input[@name='quantity']"));
			   quantity2.sendKeys("\b0");
			   WebElement updatebuttom2 = driver.findElement(By.xpath("//input[@value='Update']"));
			   updatebuttom2.click();
			   try {
				    Thread.sleep(5000);
			   } catch (InterruptedException e1) {
				        // TODO Auto-generated catch block
				        e1.printStackTrace();
			   }
			   try {
				  
				    iphonefound=driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/n/']")).isDisplayed();
				    if(iphonefound){
				       itemremoved=false;
				    }else{
				       itemremoved=true;
				    }
			   }catch(Exception e){
				    itemremoved=true;
			   }
		   }
		   Assert.assertTrue("Price not changed", pricechanged);
		   Assert.assertTrue("Item not removed", itemremoved);
	}
	
	@Test
	public void testcase5_efg(){
		   WebElement search = driver.findElement(By.xpath("//input[@class='search']"));
		   search.sendKeys("iphone 5\n");
		   WebDriverWait wait = new WebDriverWait(driver, 15);
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
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='quantity']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       WebElement quantity = driver.findElement(By.xpath("//input[@name='quantity']"));
	       String quantity_begin=quantity.getAttribute("value");
	       boolean quantity1=false;
	       if (quantity_begin.equals("1")){quantity1=true;}
           boolean pricechanged=false;
		   System.out.println("Quantity begin: "+quantity_begin);
		   System.out.println("Quatity1: "+quantity1);
		   boolean cartact=false;
		   boolean infoact=false;
		   boolean finalact=false;
		   boolean continue_infoact=false;

		   if (quantity1){
			   WebElement updatebuttom = driver.findElement(By.xpath("//input[@value='Update']"));
			   WebElement total = driver.findElement(By.xpath("//span[@class='pricedisplay']"));
			   String s_price1=total.getText();
			   System.out.println("Start price: "+s_price1);
			   quantity.sendKeys("\b2");
			   updatebuttom.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='pricedisplay']")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
			   // Verify Sub-total
			   WebElement yourtotalprice=driver.findElement(By.xpath("//span[@class='yourtotal']"));
			   String s_yourtotal1=yourtotalprice.getText();
			   String s_yourtotal=s_yourtotal1.trim();
			   String s_yourtotal2=s_yourtotal.substring(10);
			   System.out.println("Your total: "+s_yourtotal);
			   System.out.println(s_yourtotal2);
			   if (s_yourtotal2.contains("$24")){
				   pricechanged=true;
			   }
			   System.out.println("Pricechanged"+pricechanged);
			   //Verify your cart
			   int cartacts=driver.findElements(By.className("cart")).size();
			   //int acts=driver.findElements(By.className("act")).size();
			   System.out.println("cartacts: "+cartacts);
			   //System.out.println("acts: "+acts);
			   if (cartacts==2){
				   //if(acts==2){
				      cartact=true;
				   //}
			   }
			   try{
				   infoact=driver.findElement(By.cssSelector("li.info.act")).isDisplayed();
			   }catch (Exception e){
				   infoact=false;
			   }
			   try{
				   finalact=driver.findElement(By.cssSelector("li.final.act")).isDisplayed();
			   }catch(Exception e){
				   finalact=false;
			   }
			   // Verify Continue bottom
			   WebElement continuebottom=driver.findElement(By.xpath("//a[@class='step2']"));
			   continuebottom.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.info.act")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		       continue_infoact=driver.findElement(By.className("info")).isDisplayed();

		   }
		   Assert.assertTrue("Price not changed", pricechanged);
		   Assert.assertTrue("Cart not activated", cartact);
		   Assert.assertFalse("Info activated", infoact);
		   Assert.assertFalse("Final activated", finalact);
		   Assert.assertTrue("Continue not correct page", continue_infoact);
	}
	
}