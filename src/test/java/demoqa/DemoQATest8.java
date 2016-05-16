package demoqa;

import static org.junit.Assert.*;

import java.util.List;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQATest8 {
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
	public void testcase1_abc_total_shipping_total_price_progressbar() {
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

	       boolean shippingsame=false;
	       boolean totalsame=false;
	       boolean fullprogressbar=false;
		   if (quantity1){
			   WebElement updatebuttom = driver.findElement(By.xpath("//input[@value='Update']"));
			   quantity.sendKeys("\b2");
			   updatebuttom.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='pricedisplay']")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
			   WebElement continuebottom=driver.findElement(By.xpath("//a[@class='step2']"));
			   continuebottom.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.info.act")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
     	       //Get shipping for Sweden
		       Select select=new Select(driver.findElement(By.id("current_country")));
		       select.selectByValue("SE");
		       WebElement calculate2 = driver.findElement(By.xpath("//input[@value='Calculate']"));
		       calculate2.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wpsc_totals")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
               List<WebElement> shipping2list=driver.findElements(By.className("pricedisplay"));
               //int shipping2size=shipping2list.size();
               //System.out.println("List of prices: "+shipping2size);
               WebElement shipping2wb=shipping2list.get(5);
               String shipping2=shipping2wb.getText().trim();
               WebElement totalpricewb=shipping2list.get(10);
               String totalprice=totalpricewb.getText().trim();
               
               System.out.println("Shipping Sweden:"+shipping2);
               System.out.println("Total price:"+totalprice);
               //Fill in fields for billing and shipping
			   String s_firstname="Martin";
			   String s_lastname="Landhage";
			   String s_email="martin.landhage@gmail.com";
			   String s_adress="Dannemoragatan 14";
			   String s_city="Stockholm";
			   String s_province="Stockholm";
			   String s_postal="11344";
			   String s_phone="+468331705";

		       WebElement firstname = driver.findElement(By.id("wpsc_checkout_form_2"));
		       firstname.sendKeys(s_firstname);
		       WebElement lastname = driver.findElement(By.id("wpsc_checkout_form_3"));
		       lastname.sendKeys(s_lastname);
		       WebElement email=driver.findElement(By.id("wpsc_checkout_form_9"));
		       email.sendKeys(s_email);
		       WebElement adress=driver.findElement(By.id("wpsc_checkout_form_4"));
		       adress.sendKeys(s_adress);
		       WebElement city=driver.findElement(By.id("wpsc_checkout_form_5"));
		       city.sendKeys(s_city);
		       WebElement province=driver.findElement(By.id("wpsc_checkout_form_6"));
		       province.sendKeys(s_province);
		       Select select2=new Select(driver.findElement(By.id("wpsc_checkout_form_7")));
		       select2.selectByValue("SE");
		       WebElement postal=driver.findElement(By.id("wpsc_checkout_form_8"));
		       postal.sendKeys(s_postal);
		       WebElement phone=driver.findElement(By.id("wpsc_checkout_form_18"));
		       phone.sendKeys(s_phone);
		       WebElement shippingsame1=driver.findElement(By.id("shippingSameBilling"));
		       shippingsame1.click();

               WebElement purchase = driver.findElement(By.xpath("//input[@value='Purchase']"));
               purchase.click();
               //Get final prices
               WebElement shippingandtotalwb=driver.findElement(By.xpath("//div[@class='wpsc-transaction-results-wrap']/p[3]"));
               String shippingandtotal=shippingandtotalwb.getText();
               System.out.println("\n"+shippingandtotal);
               String shippingtotal=shippingandtotal.substring(15,22).trim();
               String total=shippingandtotal.substring(29).trim();
               System.out.println("\nFinal shipping total:"+shippingtotal);
               System.out.println("Final total:"+total);
               //Check total shipping
               if (shipping2.equals(shippingtotal)){
            	   shippingsame=true;
               }
               //Check total price
               if (totalprice.equals(total)){
            	   totalsame=true;
               }
               //Check progress bar
               boolean cartact=driver.findElement(By.cssSelector("li.cart.act")).isDisplayed();
               boolean infoact=driver.findElement(By.cssSelector("li.info.act")).isDisplayed();
               boolean finalact=driver.findElement(By.cssSelector("li.final.act")).isDisplayed();
               if(cartact){
            	 if(infoact){
            	   if(finalact){
            		  fullprogressbar=true;
            	   }
            	 }
               }
               
               
		   }
            Assert.assertTrue("Shipping not same", shippingsame);
            Assert.assertTrue("Total not same", totalsame);
            Assert.assertTrue("Full progress bar not lit", fullprogressbar);

	}

}
