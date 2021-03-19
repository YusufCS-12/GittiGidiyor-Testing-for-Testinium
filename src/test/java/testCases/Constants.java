package testCases;

import org.openqa.selenium.By;
import static org.openqa.selenium.By.cssSelector;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;



public class Constants {
	
	static WebDriverWait wait;
    static WebDriver driver;
    static ExpectedCondition<Boolean> documentReady = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
		    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		}
	};
	
	@Test
    public void DriverOlustur() throws InterruptedException {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\yusuf\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        getUrl("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, 15);
        
	}
	
	@Test
    public void GirisYap() throws InterruptedException {
        getUrl("https://www.gittigidiyor.com/uye-girisi");
        setById("L-UserNameField", "yusufcs1234@gmail.com");
        setById("L-PasswordField", "testinium12");
        clickById("gg-login-enter");
        Thread.sleep(4000);
        wait.until(documentReady);
        driver.findElement(name("k")).sendKeys("Bilgisayar");
    	driver.findElement((xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button"))).click();
    	int randomProductIndex = new Random().nextInt(28);
    	WebElement productElement = driver.findElement(By.cssSelector(".products-container > li:nth-child(" + randomProductIndex + ")"));
    	productElement.findElement(By.cssSelector("a")).click();
    	Thread.sleep(4000);
    }
	

		@Test
	     public void SepeteAt() throws InterruptedException {
	    	 
	     driver.findElement(cssSelector("#buyitnow_adet")).clear();
	     driver.findElement(cssSelector("#buyitnow_adet")).sendKeys("1");
	     driver.findElement(By.id("sp-addbasket-button")).click();
	     driver.findElement(By.cssSelector("#header_wrapper > div.header-icon-container.robot-header-iconContainer.gg-w-5.gg-d-6.gg-t-14.gg-m-11.gg-w-push-14.gg-d-push-12.gg-t-push-0.gg-m-push-0 > div.basket-container.robot-header-iconContainer-cart > a")).click();
	     driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	     driver.findElement(By.className("btn-delete")).click();
	     
	     }


	
	     public void setById(String id, String value) {
	         driver.findElement(By.id(id)).clear();
	         driver.findElement(By.id(id)).sendKeys(value);
	     }

	     public void clickById(String id) {
	         driver.findElement(By.id(id)).click();
	     }

	     public void getUrl(String URL) {
	         driver.get(URL);
	     }
    

	

}
