package test1.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {

	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
	}
	
	@Test
	public void testPage() {

		inicio();
		post();
	}

	
	public void inicio() {
		WebElement usuario = driver.findElement(By.xpath("//*[@id=\'user_login\']"));
		usuario.clear();
		usuario.sendKeys("opensourcecms");
		
		WebElement contraseña = driver.findElement(By.xpath("//*[@id=\'user_pass\']"));
		contraseña.clear();
		contraseña.sendKeys("opensourcecms");
		
		WebElement boton = driver.findElement(By.xpath("//*[@id=\'wp-submit\']"));
		boton.click();
		driver.manage().timeouts().implicitlyWait(02, TimeUnit.SECONDS);
	}
	
	
	public void post() {
		
		WebElement post = driver.findElement(By.xpath("//*[@id=\'menu-posts\']/a/div[3]"));
		post.click();
		
		WebElement cateori = driver.findElement(By.xpath("//*[@id=\'menu-posts\']/ul/li[4]/a"));
		cateori.click();
		//assertEquals("Categories",driver.getTitle());
		
		WebElement tag = driver.findElement(By.xpath("//*[@id=\'menu-posts\']/ul/li[5]/a"));
		tag.click();
		//assertEquals("Tags",driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
System.out.println("entre en pae");
		
		WebElement pagee = driver.findElement(By.xpath("//*[@id=\'menu-pages\']/a/div[3]"));
		pagee.click();
		
		WebElement all = driver.findElement(By.xpath("//*[@id=\'menu-pages\']/ul/li[2]/a"));
		all.click();
		//assertEquals("Pages",driver.getTitle());
		
		WebElement neww = driver.findElement(By.xpath("//*[@id=\'menu-pages\']/ul/li[3]/a"));
		neww.click();
		
		driver.manage().timeouts().implicitlyWait(02, TimeUnit.SECONDS);
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
}
