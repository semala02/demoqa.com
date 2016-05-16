package demoqa;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

public class DemoQATest7 {
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
	public void testcase1_a_calculate_shipping() {
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
		       // Get shipping for US
		       Select select1=new Select(driver.findElement(By.id("current_country")));
		       select1.selectByValue("US");
		       WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
		       calculate.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wpsc_totals")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
               List<WebElement> shipping1list=driver.findElements(By.className("pricedisplay"));
               //int shipping1size=shipping1list.size();
               //System.out.println("List of prices: "+shipping1size);
               WebElement shipping1wb=shipping1list.get(5);
               String shipping1=shipping1wb.getText().trim();
  		       //System.out.println("Shipping USA:"+shipping1);
  		       //Get shipping for Sweden
  		       Select select2=new Select(driver.findElement(By.id("current_country")));
  		       select2.selectByValue("SE");
		       WebElement calculate2 = driver.findElement(By.xpath("//input[@value='Calculate']"));
  		       calculate2.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wpsc_totals")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
               List<WebElement> shipping2list=driver.findElements(By.className("pricedisplay"));
               //int shipping2size=shipping2list.size();
               //System.out.println("List of prices: "+shipping2size);
               WebElement shipping2wb=shipping2list.get(5);
               String shipping2=shipping2wb.getText().trim();
               //System.out.println("Shipping Sweden:"+shipping2);
               String shipping1ex=shipping1.substring(1);
               //System.out.println("Shipping USA: "+shipping1ex);
               String shipping2ex=shipping2.substring(1);
               double shipping1d=Double.parseDouble(shipping1ex);
               double shipping2d=Double.parseDouble(shipping2ex);
               boolean swedengreater=false;
               if (shipping2d>shipping1d){
            	   swedengreater=true;
               }
               WebElement goback = driver.findElement(By.className("step1"));
               goback.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Remove']")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		       WebElement remove =driver.findElement(By.xpath("//input[@value='Remove']"));
		       remove.click();
               Assert.assertTrue("Sweden not greater", swedengreater);
		   }


	}
    @Test
    public void testcase2_b_fillinmandatory(){
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
           boolean errorgiven=false;
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
		       // Get shipping for US
		       Select select1=new Select(driver.findElement(By.id("current_country")));
		       select1.selectByValue("SE");
		       WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
		       calculate.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wpsc_totals")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		       WebElement firstname = driver.findElement(By.id("wpsc_checkout_form_2"));
		       firstname.sendKeys("Martin");
		       WebElement lastname = driver.findElement(By.id("wpsc_checkout_form_3"));
		       lastname.sendKeys("Landhage");
		       WebElement purchase=driver.findElement(By.xpath("//input[@value='Purchase']"));
		       purchase.click();
		       errorgiven=false;
		       // Incorrect handling of web page, error not given
		       System.out.println("ERROR: Redirected to checkout page");
		       try {
				    Thread.sleep(3000);
			   } catch (InterruptedException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
			   }
		       WebElement missingadress =driver.findElement(By.className("wpsc_error_msg_field_name"));
		       String s_email=missingadress.getText();
		       if (s_email.equals("address")){
		           errorgiven=true;
		       }
		       //To be removed if working correctly
		       WebElement remove =driver.findElement(By.xpath("//input[@value='Remove']"));
		       remove.click();
		       //To be removed
		   }
		   Assert.assertTrue("Error not given", errorgiven);
    }
    @Test
    public void testcase3_c_incorrect_email(){
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
           boolean errorgiven=false;
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
		       // Get shipping for US
		       Select select1=new Select(driver.findElement(By.id("current_country")));
		       select1.selectByValue("SE");
		       WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
		       calculate.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wpsc_totals")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		       WebElement firstname = driver.findElement(By.id("wpsc_checkout_form_2"));
		       firstname.sendKeys("Martin");
		       WebElement lastname = driver.findElement(By.id("wpsc_checkout_form_3"));
		       lastname.sendKeys("Landhage");
		       WebElement purchase=driver.findElement(By.xpath("//input[@value='Purchase']"));
		       WebElement email=driver.findElement(By.id("wpsc_checkout_form_9"));
		       email.sendKeys("martin.landhage");
		       purchase.click();
		       errorgiven=false;
		       // Incorrect handling of web page, error not given
		       System.out.println("ERROR: Redirected to checkout page");
		       try {
				    Thread.sleep(3000);
			   } catch (InterruptedException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
			   }
		       WebElement missingemail =driver.findElement(By.className("wpsc_error_msg_field_name"));
		       String s_email=missingemail.getText();
		       if (s_email.equals("email")){
		           errorgiven=true;
		       }
		       //To be removed if working correctly
		       WebElement remove =driver.findElement(By.xpath("//input[@value='Remove']"));
		       remove.click();
		       //To be removed
		   }
		   Assert.assertTrue("Error not given", errorgiven);
    }
    @Test
    public void testcase4_d_shipping_same_as_billing(){
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
           boolean shippingsamemess=false;
           boolean notshippingfirstname=false;
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
		       // Get shipping for US
		       Select select1=new Select(driver.findElement(By.id("current_country")));
		       select1.selectByValue("SE");
		       WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
		       calculate.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wpsc_totals")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		       WebElement firstname = driver.findElement(By.id("wpsc_checkout_form_2"));
		       firstname.sendKeys("Martin");
		       WebElement lastname = driver.findElement(By.id("wpsc_checkout_form_3"));
		       lastname.sendKeys("Landhage");
		       //WebElement purchase=driver.findElement(By.xpath("//input[@value='Purchase']"));
		       WebElement email=driver.findElement(By.id("wpsc_checkout_form_9"));
		       email.sendKeys("martin.landhage@gmail.com");
		       WebElement adress=driver.findElement(By.id("wpsc_checkout_form_4"));
		       adress.sendKeys("Dannemoragatan 14");
		       WebElement city=driver.findElement(By.id("wpsc_checkout_form_5"));
		       city.sendKeys("Stockholm");
		       WebElement province=driver.findElement(By.id("wpsc_checkout_form_6"));
		       province.sendKeys("Stockholm");
		       Select select2=new Select(driver.findElement(By.id("wpsc_checkout_form_7")));
		       select2.selectByValue("SE");
		       WebElement postal=driver.findElement(By.id("wpsc_checkout_form_8"));
		       postal.sendKeys("11344");
		       WebElement phone=driver.findElement(By.id("wpsc_checkout_form_18"));
		       phone.sendKeys("+468331705");
		       WebElement shippingsame=driver.findElement(By.id("shippingSameBilling"));
		       shippingsame.click();
		       shippingsamemess=driver.findElement(By.id("shippingsameasbillingmessage")).isDisplayed();
		       try{
		    	   boolean shippingfirstname=driver.findElement(By.id("wpsc_checkout_form_11")).isDisplayed();
		    	   if(shippingfirstname){
		    		   notshippingfirstname=false;
		    	   }else{
		    		   notshippingfirstname=true;
		    	   }
		       }catch(Exception e){
		    	      notshippingfirstname=true;
		       }
		       //Remove order
		       WebElement goback=driver.findElement(By.className("step1"));
		       goback.click();
		       try {
				    Thread.sleep(3000);
			   } catch (InterruptedException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
			   }
		       WebElement remove =driver.findElement(By.xpath("//input[@value='Remove']"));
		       remove.click();
		   }
		   Assert.assertTrue("Shipping is same a billing not displayed", shippingsamemess);
		   Assert.assertTrue("Name field for shipping still shown", notshippingfirstname);
	
    }
    @Test
    public void testcase5_e_progress_bar(){
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
	       boolean cartact=false;
	       boolean infoact=false;
	       boolean finalnotact=false;
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
               cartact=driver.findElement(By.cssSelector("li.cart.act")).isDisplayed();
               infoact=driver.findElement(By.cssSelector("li.info.act")).isDisplayed();
               finalnotact=driver.findElement(By.cssSelector("li.final")).isDisplayed();
		       //Remove order
		       WebElement goback=driver.findElement(By.className("step1"));
		       goback.click();
		       try {
				    Thread.sleep(3000);
			   } catch (InterruptedException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
			   }
		       WebElement remove =driver.findElement(By.xpath("//input[@value='Remove']"));
		       remove.click();
		   }
	       Assert.assertTrue("Cart not activated", cartact);
	       Assert.assertTrue("Info not activated", infoact);
	       Assert.assertTrue("Final activated", finalnotact);
    }
    @Test
    public void testcase6_f_go_back_continue(){
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
           boolean allfieldsreturn=false;
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
		       // Get shipping for US
		       Select select1=new Select(driver.findElement(By.id("current_country")));
		       select1.selectByValue("SE");
		       WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
		       calculate.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wpsc_totals")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
               //Field values
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
		       WebElement shippingsame=driver.findElement(By.id("shippingSameBilling"));
		       shippingsame.click();
		       WebElement goback=driver.findElement(By.className("step1"));
		       goback.click();
		       try {
				    Thread.sleep(3000);
			   } catch (InterruptedException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
			   }
			   WebElement continuebottom2=driver.findElement(By.xpath("//a[@class='step2']"));
			   continuebottom2.click();
			   //Verify same values
		       WebElement firstname1 = driver.findElement(By.id("wpsc_checkout_form_2"));
		       String s_firstname1=firstname1.getText();
		       WebElement lastname1 = driver.findElement(By.id("wpsc_checkout_form_3"));
		       String s_lastname1=lastname1.getText();
		       WebElement email1=driver.findElement(By.id("wpsc_checkout_form_9"));
		       String s_email1=email1.getText();
		       WebElement adress1=driver.findElement(By.id("wpsc_checkout_form_4"));
		       String s_adress1=adress1.getText();
		       WebElement city1=driver.findElement(By.id("wpsc_checkout_form_5"));
		       String s_city1=city1.getText();
		       WebElement province1=driver.findElement(By.id("wpsc_checkout_form_6"));
		       String s_province1=province1.getText();
		       WebElement postal1=driver.findElement(By.id("wpsc_checkout_form_8"));
		       String s_postal1=postal1.getText();
		       WebElement phone1=driver.findElement(By.id("wpsc_checkout_form_18"));
		       String s_phone1=phone1.getText();
               if(s_firstname1.equals(s_firstname)){
            	  if(s_lastname1.equals(s_lastname)){
            		 if(s_email1.equals(s_email)){
            			if(s_adress1.equals(s_adress)){
            			   if(s_city1.equals(s_city)){
            				  if(s_province1.equals(s_province1)){
            					 if(s_postal1.equals(s_postal)){
            						if(s_phone1.equals(s_phone)){
            						   allfieldsreturn=true;	
            						}
            					 }
            				  }
            			   }
            			}
            		 }
            	  }
               }
		       WebElement goback1=driver.findElement(By.className("step1"));
		       goback1.click();
		       try {
				    Thread.sleep(3000);
			   } catch (InterruptedException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
			   }
		       WebElement remove =driver.findElement(By.xpath("//input[@value='Remove']"));
		       remove.click();
 
		   }
	       Assert.assertTrue("All filds not returned", allfieldsreturn);
    }
    @Test
    public void testcase7_g_purchase(){
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
	       boolean confirm=false;
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
		       // Get shipping for US
		       Select select1=new Select(driver.findElement(By.id("current_country")));
		       select1.selectByValue("SE");
		       WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
		       calculate.click();
		          wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wpsc_totals")));
		          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		       //Field values
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
		       //WebElement purchase=driver.findElement(By.xpath("//input[@value='Purchase']"));
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
		       WebElement shippingsame=driver.findElement(By.id("shippingSameBilling"));
		       shippingsame.click();
		       WebElement purchase=driver.findElement(By.xpath("//input[@value='Purchase']"));
		       purchase.click();
		       try {
				    Thread.sleep(3000);
			   } catch (InterruptedException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
			   }
		       confirm=driver.findElement(By.cssSelector("li.final.act")).isDisplayed();
		   }
	       Assert.assertTrue("Final page not displayed", confirm);
    }
}
