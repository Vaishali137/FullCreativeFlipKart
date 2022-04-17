package org.packagedemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartDemo {
	public static void main(String[] args) throws InterruptedException {
		//Login
		System.setProperty("webdriver.chrome.driver","/FlipKart/target/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//*[@autocomplete=\"off\"])[2]")).sendKeys("8610XXXXX");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("*****");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"_2KpZ6l _2HKlqd _3AWRsL\"]")).click();
		Thread.sleep(3000);
		
		//Searching Hp Laptop 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	    driver.findElement(By.xpath("//*[@title=\"Search for products, brands and more\"]")).sendKeys("hp laptop");
	    driver.findElement(By.xpath("//*[@class=\"L0Z3Pu\"]")).click();
	    Thread.sleep(5000);
	    
	    //HP laptop select
	    driver.findElement(By.xpath("(//*[@class=\"_396cs4 _3exPp9\"])[1]")).click();
	    
	    //window handles
        Set<String> child = driver.getWindowHandles();
	    List<String> list = new ArrayList<>(child);
	    driver.switchTo().window(list.get(1));
	    Thread.sleep(2000);
		
	    //Add to cart
	    driver.findElement(By.xpath("//*[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")).click();
	    Thread.sleep(2000);
	    driver.close();
	    
	  //Parent window
	    driver.switchTo().window(list.get(0));
	    Thread.sleep(6000);
	    
	    //Mobile search
	    WebElement ele1= driver.findElement(By.xpath("//*[@title=\"Search for products, brands and more\"]"));
	    ele1.clear();
	    ele1.sendKeys("iphone11");
	    driver.findElement(By.xpath("//*[@class=\"L0Z3Pu\"]")).click();
	    Thread.sleep(2000);
	    //search icon
	    driver.findElement(By.xpath("(//*[@class=\"fMghEO\"])[1]")).click();
	    Thread.sleep(2000);
	   
	    //window handles
	    Set<String> child1 = driver.getWindowHandles();
	    List<String> list1 = new ArrayList<>(child1);
	    driver.switchTo().window(list1.get(1));
	    Thread.sleep(6000);
	    
	    //Add to cart
        driver.findElement(By.xpath("//*[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")).click();
	     Thread.sleep(6000);
	   
	     //Scroll down Cart and remove Laptop
	    Actions act =new Actions(driver);
	    act.sendKeys(Keys.PAGE_DOWN).build().perform();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//*[@class=\"_3dsJAO\"])[4]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@class=\"_3dsJAO _24d-qY FhkMJZ\"]")).click();
	    Thread.sleep(2000);
	    
	    //VaLidation of selected Item
	    String actual = "APPLE iPhone 11 (White, 64 GB)";
	    String expected = driver.findElement(By.xpath("//*[@class=\"_2Kn22P gBNbID\"]")).getText();
	    if (expected.equals(actual)) {
	    	System.out.println("Validation passed");
	    	
		}
	    Thread.sleep(2000);
	  
	    //Parent window
	    driver.switchTo().window(list1.get(0));
	    Thread.sleep(6000);
	   //driver.findElement(By.xpath("(//*[@class=\"exehdJ\"])[1]")).click();
	    
	  //My account
	  WebElement ele = driver.findElement(By.xpath("//div[text()='My Account']"));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000);
	  
	  //Logout account
	  driver.findElement(By.xpath("(//*[@class=\"_2kxeIr\"])[10]")).click();
	  
	  //Close all tabs
	  driver.quit();
	  

	    
	 
	}
}
