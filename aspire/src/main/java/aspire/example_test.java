package aspire.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class example_test {
	private WebDriver driver = null;
	String appUrl = "https://aspireapp.odoo.com";

	@Test(priority = 0)
	public void Loginwithvalidaccount() throws Exception {
		//open browser and access this 
		driver.get(appUrl);
		// maximize the browser window
        driver.manage().window().maximize();
        // enter the username and password
        WebElement username = driver.findElement(By.xpath("//input[@id=\"login\"]"));
        username.clear();
        username.sendKeys("user@aspireapp.com");
        WebElement password  = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        password.clear();
        password.sendKeys("@sp1r3app");
        //submit
        WebElement submit  = driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block\"]"));
        submit.click();  
		Thread.sleep(1000);
	}
	@Test(priority = 1)
	public void Gotoproductpage() throws Exception {
		WebElement inventoryitem  = driver.findElement(By.xpath("//a[@id='result_app_1']/div"));
		inventoryitem.click();  
		Thread.sleep(1000);
		WebElement productitem  = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
		productitem.click();  
		Thread.sleep(1000);
		WebElement productitem1  = driver.findElement(By.xpath("//*[@class=\"dropdown-item o_menu_entry_lvl_2\"]//span[contains(text(),'Products')]"));
		productitem1.click(); 
		Thread.sleep(1000);
	}
	@Test(priority = 2)
	public void createnewproduct() throws Exception {
		WebElement createproductbutton = driver.findElement(By.xpath("//*[@class=\"btn btn-primary o-kanban-button-new\"]"));
		createproductbutton.click(); 
		Thread.sleep(1000);
		WebElement productname = driver.findElement(By.xpath("//input[@placeholder=\"Product Name\"]"));
		productname.sendKeys("cuonghuynh"); 
		WebElement savecreateproduct = driver.findElement(By.xpath("//button[@class=\"btn btn-primary o_form_button_save\"]"));
		savecreateproduct.click();
		Thread.sleep(1000);

	}
	@Test(priority = 2)
	public void updateproduct() throws Exception {
		WebElement updateproductbutton = driver.findElement(By.xpath("//*[@class=\"btn btn-primary o_form_button_edit\"]"));
		updateproductbutton.click(); 
		Thread.sleep(1000);
	}
	@BeforeTest
	public void beforeTest() throws Exception {
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
