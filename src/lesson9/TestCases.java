package lesson9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

	WebDriver driver=new ChromeDriver();
	String URL="https://www.saucedemo.com/";
	String userName="standard_user";
	String Password="secret_sauce";
	
	@BeforeTest
	public void MySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
        	}
	
	@Test(priority=1)
	public void Login() {
		WebElement usernameInput=driver.findElement(By.id("user-name"));
		usernameInput.sendKeys(userName);
		WebElement PasswordInput=driver.findElement(By.id("password"));
		PasswordInput.sendKeys(Password);

		WebElement LoginButtom=driver.findElement(By.id("login-button"));
		LoginButtom.click();

	}
	
	@Test(priority=2,enabled=false)
	public void AddAllItems() {

		List<WebElement> AddToCart=driver.findElements(By.className("btn"));
		
		for(int i=0;i<AddToCart.size() ;i++) {
			AddToCart.get(i).click();
		}
	}

	@Test(priority=3,enabled=false)
	public void AddOneItemsAfterTheOther() {

		List<WebElement> AddToCart=driver.findElements(By.className("btn"));
		
		for(int i=0;i<AddToCart.size() ;i++) 
			if(i%2 ==0)
			AddToCart.get(i).click();
		
	}
	
	
	@Test(priority=4,enabled=false)
	public void AddElementWithLabWord() {

	    List<WebElement> AddToCart = driver.findElements(By.className("btn"));
	    List<WebElement> Items = driver.findElements(By.className("inventory-item-description"));
	    
	    for(int i = 0; i < Items.size(); i++) {
	        String Item = Items.get(i).getText();
	        
	        if(Item.contains("Labs")) 
	            AddToCart.get(i).click();
	        
	    }
	}

	
		
	@Test(priority=5)
	public void AddingPricesLessThan$15() {
	    List<WebElement> Items = driver.findElements(By.className("inventory_item_description"));  
	    List<WebElement> AddToCart = driver.findElements(By.className("btn_inventory"));  
	    List<WebElement> Prices = driver.findElements(By.className("inventory_item_price"));

	    int size = Math.min(Math.min(Items.size(), AddToCart.size()), Prices.size());

	    for (int i = 0; i < size; i++) {
	        String ThePrice = Prices.get(i).getText();
	        double price = Double.parseDouble(ThePrice.replace("$", ""));

	        if (price < 15.00) 
	            AddToCart.get(i).click();
	        
	    }
	}

}
