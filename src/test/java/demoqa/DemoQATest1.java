package demoqa;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
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
import org.junit.Assert;
import org.junit.Before;

public class DemoQATest1 {

	protected static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/etxmsl/TEST15/Testautomatisering/Selenium/demoqa.com/chromedriver");
		if (driver == null){
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
	public void testcase1_BuyNow() {
		   WebElement buynow = driver.findElement(By.linkText("Buy Now"));
		   boolean found = buynow.isDisplayed();
		   Assert.assertTrue("Buy Now not found", found);	
		   buynow.click();
	}	

    @Test
    public void testcase2_findiphone5pic(){
	       //driver.manage().window().setSize(new Dimension(1024,768));
	       WebDriverWait wait = new WebDriverWait(driver, 10);
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
		     wait.pollingEvery(100, TimeUnit.MILLISECONDS);
    	   WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
    	   iphone5.click();
    	   boolean iphone5header = driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    	   Assert.assertTrue("Product title not found", iphone5header);
    }
    
    @Test
    public void testcase3_moreinfo(){
    	   WebElement moreinfo = driver.findElement(By.xpath("//a[@title='More Info']"));
    	   boolean found = moreinfo.isDisplayed();
    	   Assert.assertTrue("More Info not found", found);
    	   moreinfo.click();
    }
    @Test
    public void testcase4_treprodukter(){
    	   long produkter=0;
    	   long tre=3;
    	   WebDriverWait wait = new WebDriverWait(driver, 10);
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Magic Mouse']")));
		     wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		   WebElement mouse = driver.findElement(By.xpath("//img[@alt='Magic Mouse']"));
		   if (mouse.isDisplayed()){produkter++;}
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone 5']")));
		     wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		   WebElement iphone5 = driver.findElement(By.xpath("//img[@alt='iPhone 5']"));
		   if (iphone5.isDisplayed()){produkter++;}
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPod Nano Blue']")));
		     wait.pollingEvery(100, TimeUnit.MILLISECONDS);
           WebElement ipodnano = driver.findElement(By.xpath("//img[@alt='iPod Nano Blue']"));
		   if (ipodnano.isDisplayed()){produkter++;}		   
		   Assert.assertEquals("wrong number of products", tre, produkter);
    }
    @Test
    public void testcase5_manual(){
       long click=0;
       long tre=3;
       WebElement slidemanual =driver.findElement(By.id("slide_menu"));
       if (slidemanual.isDisplayed()){
          WebElement link1 = driver.findElement(By.xpath("//ul[@id='slide_menu']/a[1]"));
   	      WebElement link2 = driver.findElement(By.xpath("//ul[@id='slide_menu']/a[2]"));
	      WebElement link3 = driver.findElement(By.xpath("//ul[@id='slide_menu']/a[3]"));
	      link1.click();
	      try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      if (driver.findElement(By.xpath("//img[@alt='Magic Mouse']")).isDisplayed()){
	      click++;}
	      link2.click();
	      try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      if (driver.findElement(By.xpath("//img[@alt='iPhone 5']")).isDisplayed()){
	      click++;}
	      link3.click();
	      try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      if (driver.findElement(By.xpath("//img[@alt='iPod Nano Blue']")).isDisplayed()){
		  click++;}
       }
       Assert.assertEquals("wrong number of products", tre, click);
    }
    @Test
    public void testcase6_blogpost_prod(){
    	   driver.manage().window().setSize(new Dimension(1280,1024));
    	   WebElement footer = driver.findElement(By.xpath("//section[@class='footer_featured']"));
    	   boolean footerpresent=footer.isDisplayed();
    	   Assert.assertTrue("Blogpost products not present", footerpresent);
    }
    @Test
    public void testcase7_blogpost_prod_select(){
    	   driver.manage().window().setSize(new Dimension(1280,1024));
    	   boolean blogspost_clicked=false;
    	   boolean iphone4s=false;
    	   try{
    	       iphone4s= driver.findElement(By.xpath("//a[@title='Apple iPhone 4S 32GB SIM-Free - White']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("iPhone 4s not found");
    	   }
    	   boolean ipad2=false;
    	   try{
    	       ipad2= driver.findElement(By.xpath("//a[@title='Apple iPad 2 16GB, Wi-Fi, 9.7in - Black']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("iPad 2 not found");
    	   }
    	   boolean ipad6=false;
    	   try{
    	       ipad6= driver.findElement(By.xpath("//a[@title='Apple iPad 6 32GB (White, 3D)']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("iPad 6 not found");
    	   }
    	   boolean appletv=false;
    	   try{
    	       appletv= driver.findElement(By.xpath("//a[@title='Apple TV']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Apple TV not found");
    	   }
    	   boolean scullcandy=false;
    	   try{
    	       scullcandy= driver.findElement(By.xpath("//a[@title='Skullcandy PLYR 1 - Black']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Scullcandy not found");
    	   }
    	   boolean sennheiser=false;
    	   try{
    	       sennheiser= driver.findElement(By.xpath("//a[@title='Sennheiser RS 120']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Sennheiser not found");
    	   }
    	   boolean macbook=false;
    	   try{
    	       macbook= driver.findElement(By.xpath("//a[@title='Apple 13-inch MacBook Pro']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("MacBook not found");
    	   }
    	   boolean asus=false;
    	   try{
    	       asus= driver.findElement(By.xpath("//a[@title='Asus MX239H 23-inch Widescreen AH']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Asus not found");
    	   }
    	   if (iphone4s){
    		   WebElement iphone4s_click=driver.findElement(By.xpath("//a[@title='Apple iPhone 4S 32GB SIM-Free - White']"));
               iphone4s_click.click();
               boolean h1_iphone4s=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
               if (h1_iphone4s){
            	   blogspost_clicked=true;
               }
    	   }else if(ipad2){
    		   WebElement ipad2_click=driver.findElement(By.xpath("//a[@title='Apple iPad 2 16GB, Wi-Fi, 9.7in - Black']"));
    		   ipad2_click.click();
    		   boolean h1_ipad2=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_ipad2){
    			   blogspost_clicked=true;
    		   }
    	   }else if(ipad6){
    		   WebElement ipad6_click=driver.findElement(By.xpath("//a[@title='Apple iPad 6 32GB (White, 3D)']"));
    		   ipad6_click.click();
    		   boolean h1_ipad6=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if(h1_ipad6){
    			  blogspost_clicked=true;
    		   }
    	   }else if(appletv){
    		   WebElement appletv_click=driver.findElement(By.xpath("//a[@title='Apple TV']"));
    		   appletv_click.click();
    		   boolean h1_appletv=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_appletv){
    			   blogspost_clicked=true;
    		   }
    	   }else if(scullcandy){
    		   WebElement scullcandy_click=driver.findElement(By.xpath("//a[@title='Skullcandy PLYR 1 - Black']"));
    		   scullcandy_click.click();
    		   boolean h1_scullcandy=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_scullcandy){
    			   blogspost_clicked=true;
    		   }
    	   }else if(sennheiser){
    		   WebElement sennheiser_click=driver.findElement(By.xpath("//a[@title='Sennheiser RS 120']"));
    		   sennheiser_click.click();
    		   boolean h1_sennheiser=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_sennheiser){
    			   blogspost_clicked=true;
    		   }
    	   }else if(macbook){
    		   WebElement macbook_click=driver.findElement(By.xpath("//a[@title='Apple 13-inch MacBook Pro']"));
    		   macbook_click.click();
    		   boolean h1_macbook=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_macbook){
    			   blogspost_clicked=true;
    		   }
    	   }else if(asus){
    		   WebElement asus_click=driver.findElement(By.xpath("//a[@title='Asus MX239H 23-inch Widescreen AH']"));
    		   asus_click.click();
    		   boolean h1_asus=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_asus){
    			   blogspost_clicked=true;
    		   }
    	   }
    	   Assert.assertTrue("Product page not displayed", blogspost_clicked);
    }
    @Test
    public void testcase8_blogpost_prod_select(){
    	   driver.manage().window().setSize(new Dimension(1280,1024));
    	   boolean blogspost_clicked=false;
    	   boolean iphone4s=false;
    	   try{
    	       iphone4s= driver.findElement(By.xpath("//a[@title='Apple iPhone 4S 32GB SIM-Free - White']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("iPhone 4s not found");
    	   }
    	   boolean ipad2=false;
    	   try{
    	       ipad2= driver.findElement(By.xpath("//a[@title='Apple iPad 2 16GB, Wi-Fi, 9.7in - Black']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("iPad 2 not found");
    	   }
    	   boolean ipad6=false;
    	   try{
    	       ipad6= driver.findElement(By.xpath("//a[@title='Apple iPad 6 32GB (White, 3D)']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("iPad 6 not found");
    	   }
    	   boolean appletv=false;
    	   try{
    	       appletv= driver.findElement(By.xpath("//a[@title='Apple TV']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Apple TV not found");
    	   }
    	   boolean scullcandy=false;
    	   try{
    	       scullcandy= driver.findElement(By.xpath("//a[@title='Skullcandy PLYR 1 - Black']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Scullcandy not found");
    	   }
    	   boolean sennheiser=false;
    	   try{
    	       sennheiser= driver.findElement(By.xpath("//a[@title='Sennheiser RS 120']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Sennheiser not found");
    	   }
    	   boolean macbook=false;
    	   try{
    	       macbook= driver.findElement(By.xpath("//a[@title='Apple 13-inch MacBook Pro']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("MacBook not found");
    	   }
    	   boolean asus=false;
    	   try{
    	       asus= driver.findElement(By.xpath("//a[@title='Asus MX239H 23-inch Widescreen AH']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Asus not found");
    	   }
    	   if (iphone4s){
    		   WebElement iphone4s_click=driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/iphones/apple-iphone-4s-32gb-sim-free-white/']"));
               iphone4s_click.click();
               boolean h1_iphone4s=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
               if (h1_iphone4s){
            	   blogspost_clicked=true;
               }
    	   }else if(ipad2){
    		   WebElement ipad2_click=driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/ipads/apple-ipad-2-16gb-wi-fi-9-7in-black/']"));
    		   ipad2_click.click();
    		   boolean h1_ipad2=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_ipad2){
    			   blogspost_clicked=true;
    		   }
    	   }else if(ipad6){
    		   WebElement ipad6_click=driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/ipads/apple-ipad-6-32gb-white-3d/']"));
    		   ipad6_click.click();
    		   boolean h1_ipad6=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if(h1_ipad6){
    			  blogspost_clicked=true;
    		   }
    	   }else if(appletv){
    		   WebElement appletv_click=driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/accessories/apple-tv/']"));
    		   appletv_click.click();
    		   boolean h1_appletv=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_appletv){
    			   blogspost_clicked=true;
    		   }
    	   }else if(scullcandy){
    		   WebElement scullcandy_click=driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/accessories/skullcandy-plyr-1-black/']"));
    		   scullcandy_click.click();
    		   boolean h1_scullcandy=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_scullcandy){
    			   blogspost_clicked=true;
    		   }
    	   }else if(sennheiser){
    		   WebElement sennheiser_click=driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/accessories/sennheiser-rs-120/']"));
    		   sennheiser_click.click();
    		   boolean h1_sennheiser=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_sennheiser){
    			   blogspost_clicked=true;
    		   }
    	   }else if(macbook){
    		   WebElement macbook_click=driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/macbooks/apple-13-inch-macbook-pro/']"));
    		   macbook_click.click();
    		   boolean h1_macbook=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_macbook){
    			   blogspost_clicked=true;
    		   }
    	   }else if(asus){
    		   WebElement asus_click=driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/accessories/asus-mx239h-23-inch-widescreen-ah/']"));
    		   asus_click.click();
    		   boolean h1_asus=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_asus){
    			   blogspost_clicked=true;
    		   }
    	   }
    	   Assert.assertTrue("Product page not displayed", blogspost_clicked);
    }
    @Test
    public void testcase9_blogpost_prod_select_details(){
    	   driver.manage().window().setSize(new Dimension(1280,1024));
    	   boolean blogspost_clicked=false;
    	   boolean iphone4s=false;
    	   try{
    	       iphone4s= driver.findElement(By.xpath("//a[@title='Apple iPhone 4S 32GB SIM-Free - White']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("iPhone 4s not found");
    	   }
    	   boolean ipad2=false;
    	   try{
    	       ipad2= driver.findElement(By.xpath("//a[@title='Apple iPad 2 16GB, Wi-Fi, 9.7in - Black']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("iPad 2 not found");
    	   }
    	   boolean ipad6=false;
    	   try{
    	       ipad6= driver.findElement(By.xpath("//a[@title='Apple iPad 6 32GB (White, 3D)']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("iPad 6 not found");
    	   }
    	   boolean appletv=false;
    	   try{
    	       appletv= driver.findElement(By.xpath("//a[@title='Apple TV']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Apple TV not found");
    	   }
    	   boolean scullcandy=false;
    	   try{
    	       scullcandy= driver.findElement(By.xpath("//a[@title='Skullcandy PLYR 1 - Black']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Scullcandy not found");
    	   }
    	   boolean sennheiser=false;
    	   try{
    	       sennheiser= driver.findElement(By.xpath("//a[@title='Sennheiser RS 120']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Sennheiser not found");
    	   }
    	   boolean macbook=false;
    	   try{
    	       macbook= driver.findElement(By.xpath("//a[@title='Apple 13-inch MacBook Pro']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("MacBook not found");
    	   }
    	   boolean asus=false;
    	   try{
    	       asus= driver.findElement(By.xpath("//a[@title='Asus MX239H 23-inch Widescreen AH']")).isDisplayed();
    	   }catch(Exception e){
    		   System.out.println("Asus not found");
    	   }
    	   if (iphone4s){
    		   WebElement iphone4s_click=driver.findElement(By.xpath("//a[@title='More Detail']"));
               iphone4s_click.click();
               boolean h1_iphone4s=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
               if (h1_iphone4s){
            	   blogspost_clicked=true;
               }
    	   }else if(ipad2){
    		   WebElement ipad2_click=driver.findElement(By.xpath("//a[@title='More Details']"));
    		   ipad2_click.click();
    		   boolean h1_ipad2=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_ipad2){
    			   blogspost_clicked=true;
    		   }
    	   }else if(ipad6){
    		   WebElement ipad6_click=driver.findElement(By.xpath("//a[@title='More Details']"));
    		   ipad6_click.click();
    		   boolean h1_ipad6=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if(h1_ipad6){
    			  blogspost_clicked=true;
    		   }
    	   }else if(appletv){
    		   WebElement appletv_click=driver.findElement(By.xpath("//a[@title='More Details']"));
    		   appletv_click.click();
    		   boolean h1_appletv=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_appletv){
    			   blogspost_clicked=true;
    		   }
    	   }else if(scullcandy){
    		   WebElement scullcandy_click=driver.findElement(By.xpath("//a[@title='More Details']"));
    		   scullcandy_click.click();
    		   boolean h1_scullcandy=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_scullcandy){
    			   blogspost_clicked=true;
    		   }
    	   }else if(sennheiser){
    		   WebElement sennheiser_click=driver.findElement(By.xpath("//a[@title='More Details']"));
    		   boolean h1_sennheiser=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_sennheiser){
    			   blogspost_clicked=true;
    		   }
    	   }else if(macbook){
    		   WebElement macbook_click=driver.findElement(By.xpath("//a[@title='More Details']"));
    		   macbook_click.click();
    		   boolean h1_macbook=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_macbook){
    			   blogspost_clicked=true;
    		   }
    	   }else if(asus){
    		   WebElement asus_click=driver.findElement(By.xpath("//a[@title='More Details']"));
    		   asus_click.click();
    		   boolean h1_asus=driver.findElement(By.cssSelector("h1.prodtitle")).isDisplayed();
    		   if (h1_asus){
    			   blogspost_clicked=true;
    		   }
    	   }
    	   Assert.assertTrue("Product page not displayed", blogspost_clicked);
    }
}
