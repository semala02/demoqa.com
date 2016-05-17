package demoqa;

import static org.junit.Assert.*;

import java.util.Set;
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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQATest2 {

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
	public void testcase1_a_product_page_iphone5() {
		   boolean all_types=false;
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
	       iphone5.click();
	       boolean iphone5header = driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
	       boolean iphone5description = driver.findElement(By.className("product_description")).isDisplayed();
	       boolean iphone5pris=driver.findElement(By.className("product_price_32")).isDisplayed();
	       if(iphone5header){
		      if(iphone5description){
			     if(iphone5pris){
				    all_types=true;
			     }
		      }
	       }
	       Assert.assertTrue("All details not displayed", all_types);
	}
	@Test
	public void testcase2_b_varukorg(){
		   WebDriverWait wait = new WebDriverWait(driver, 25);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
	       iphone5.click();
           WebElement addtocart = driver.findElement(By.xpath("//input[@value='Add To Cart']"));
           addtocart.click();
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
	
	public void testcase3_c_rating_i_ii(){
		   // Five star for iPhone 5
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
	       iphone5.click();
	       boolean rating = driver.findElement(By.className("wpec-star-rating")).isDisplayed();
	       if(rating){
	          WebElement star5 = driver.findElement(By.xpath("//a[@title='5']"));
	          star5.click();
	       }	
	       boolean rated=false;
	       try{
	           rated=driver.findElement(By.xpath("//div[@class='wpec-star-rating rater-0 star star-rating-applied star-rating-readonly star-rating-on']/a[@title='5']")).isDisplayed();
	       }catch(Exception e){
	    	   System.out.println("Rating not saved");
	       }
	       Assert.assertTrue("Rating failed", rated);	
	}
	@Test
	public void testcase4_c_rating_ii_1star(){
		   // 1 star iPhone 5
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
	       iphone5.click();
	       boolean rating = driver.findElement(By.className("wpec-star-rating")).isDisplayed();
	       if(rating){
	          WebElement star1 = driver.findElement(By.xpath("//a[@title='1']"));
	          star1.click();
	       }	
	       boolean rated=false;
	       try{
	           rated=driver.findElement(By.xpath("//div[@class='wpec-star-rating rater-0 star star-rating-applied star-rating-readonly star-rating-on']/a[@title='1']")).isDisplayed();
	       }catch(Exception e){
	    	   System.out.println("Rating not saved");
	       }
	       Assert.assertTrue("Rating failed", rated);
	}
	@Test
	public void testcase5_c_rating_ii_2star(){
		   // 2 star iPhone 5
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
	       iphone5.click();
	       boolean rating = driver.findElement(By.className("wpec-star-rating")).isDisplayed();
	       if(rating){
	          WebElement star2 = driver.findElement(By.xpath("//a[@title='2']"));
	          star2.click();
	       }	
	       boolean rated=false;
	       try{
	           rated=driver.findElement(By.xpath("//div[@class='wpec-star-rating rater-0 star star-rating-applied star-rating-readonly star-rating-on']/a[@title='2']")).isDisplayed();
	       }catch(Exception e){
	    	   System.out.println("Rating not saved");
	       }
	       Assert.assertTrue("Rating failed", rated);
	}
	@Test
	public void testcase6_c_rating_ii_3star(){
		   // 3 star iPhone 5 
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
	       iphone5.click();
	       boolean rating = driver.findElement(By.className("wpec-star-rating")).isDisplayed();
	       if(rating){
	          WebElement star3 = driver.findElement(By.xpath("//a[@title='3']"));
	          star3.click();
	       }	
	       boolean rated=false;
	       try{
	           rated=driver.findElement(By.xpath("//div[@class='wpec-star-rating rater-0 star star-rating-applied star-rating-readonly star-rating-on']/a[@title='3']")).isDisplayed();
	       }catch(Exception e){
	    	   System.out.println("Rating not saved");
	       }
	       Assert.assertTrue("Rating failed", rated);
	}
	@Test
	public void testcase7_c_rating_ii_4star(){
		   //4 star iPhone 5 
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
	       iphone5.click();
	       boolean rating = driver.findElement(By.className("wpec-star-rating")).isDisplayed();
	       if(rating){
	          WebElement star4 = driver.findElement(By.xpath("//a[@title='4']"));
	          star4.click();
	       }	
	       boolean rated=false;
	       try{
	           rated=driver.findElement(By.xpath("//div[@class='wpec-star-rating rater-0 star star-rating-applied star-rating-readonly star-rating-on']/a[@title='4']")).isDisplayed();
	       }catch(Exception e){
	    	   System.out.println("Rating not saved");
	       }
	       Assert.assertTrue("Rating failed", rated);
	}
	@Test
	public void testcase8_c_rating_ii_iv_5star(){
		   // 5 star iPhone 5
		   WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
	          wait.pollingEvery(100, TimeUnit.MILLISECONDS);
	       WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
	       iphone5.click();
	       boolean rating = driver.findElement(By.className("wpec-star-rating")).isDisplayed();
	       boolean rateddouble=false;
	       String doublerated="Sorry, you already rated!";
	       String doublerated2="";
	       if(rating){
	          WebElement star5 = driver.findElement(By.xpath("//a[@title='5']"));
	          star5.click();
	          star5.click();
	          WebElement sorry =driver.findElement(By.className("message"));
	          doublerated2=sorry.getText();
	       }	
	       if(doublerated2.equals(doublerated)){
	    	 rateddouble=true;
	       }
	       Assert.assertTrue("Double rating failed", rateddouble);
	}
	
	@Test
	public void testcase9_d_facebook_i_ii(){
		   WebDriverWait wait = new WebDriverWait(driver, 15);
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
              wait.pollingEvery(100, TimeUnit.MILLISECONDS);
           WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
           iphone5.click();
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='fb:like Facebook Social Plugin']")));
              wait.pollingEvery(100, TimeUnit.MILLISECONDS);
           
           Actions fbaction=new Actions(driver);
           String mainwindow=driver.getWindowHandle();
           WebElement facebook=driver.findElement(By.xpath("//iframe[@title='fb:like Facebook Social Plugin']"));
           fbaction.click(facebook).build().perform();
           Set<String> handles=driver.getWindowHandles();
           String newwindow;
           for(String handleid:handles){
        	   driver.switchTo().window(handleid);
        	   if(driver.getTitle().contains("Facebook")){
        		  newwindow=handleid;
        		  break;
        	   }
           }
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Avbryt']")));
              wait.pollingEvery(100, TimeUnit.MILLISECONDS);

           WebElement avbryt=driver.findElement(By.xpath("//input[@value='Avbryt']"));
           avbryt.click();
           driver.switchTo().frame(facebook.getAttribute("name"));
           
           //String numlikes=fbaction.moveToElement(driver.findElement(By.cssSelector("div.pluginCountButton.pluginCountNum"))).toString();
           boolean numlikesshown=driver.findElement(By.className("pluginCountNum")).isDisplayed();
           //System.out.println("Numblikes:"+numlikes);
	       Assert.assertTrue("Num likes not shown", numlikesshown);
	}

}
