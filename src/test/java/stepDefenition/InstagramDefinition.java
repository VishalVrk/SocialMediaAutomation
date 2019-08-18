package stepDefenition;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class InstagramDefinition {
	
	static WebDriver driver;
	static WebDriverWait wait;
	static Dimension d;
	static JavascriptExecutor js;
	
	@Given("Instagram is open at mobile view")
	public void instagram_is_open_at_mobile_view() {
    	System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
    	Map<String, Object> deviceMetrics = new HashMap<>();
    	deviceMetrics.put("width", 411);
    	deviceMetrics.put("height", 600);
    	deviceMetrics.put("pixelRatio", 3.0);
    	Map<String, Object> mobileEmulation = new HashMap<>();
    	mobileEmulation.put("deviceMetrics", deviceMetrics);
    	mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 8.0.0;" +
    	"Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML,like Gecko) " +"Chrome/76.0.3809.87 Mobile Safari/537.36");
    	ChromeOptions chromeOptions = new ChromeOptions();
    	chromeOptions.setExperimentalOption("mobileEmulation",mobileEmulation);
    	chromeOptions.addArguments("user-data-dir=Users/vishalvaitheeswaranrk/Library/ApplicationSupport/Google/Chrome/Default");
    	driver = new ChromeDriver(chromeOptions);
    	driver.get("https://www.instagram.com");
    	driver.manage().window().fullscreen();
    	driver.navigate().refresh();
	}
	
	@Given("I click Login Button")
	public void i_click_Login_Button() {
		WebElement LogInButton = driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		LogInButton.click();
	}
	
	@Given("I enter {string} username and {string} password")
	public void i_enter_username_and_password(String string, String string2) throws Exception {
		WebElement LogInEmail = driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']"));
		LogInEmail.click();
		LogInEmail.sendKeys(string);
		WebElement LogInPassword = driver.findElement(By.xpath("//input[@aria-label='Password']"));
		LogInPassword.click();
		LogInPassword.sendKeys(string2);	
	}
	
	@Given("I enter into the Application")
	public void i_enter_into_the_Application() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement LogIn = driver.findElement(By.xpath("//button[@type='submit']"));
		LogIn.click();
	}
	
	@Given("I click on New Post")
	public void i_click_on_new_post() {
		WebElement NewPost = driver.findElement(By.xpath("//span[@aria-label='New Post']"));
	}
	
	@Given("I get all pictures from images folder")
	public void i_get_all_pictures_from_images_folder() {
		
		File folder = new File("src/test/java/Images");
    	File[] listOfFiles = folder.listFiles();
    	WebElement NewPost = driver.findElement(By.xpath("(//input[@type='file'])[4]"));
		NewPost.sendKeys("/Users/vishalvaitheeswaranrk/eclipse-workspace/SocialMediaManager/src/test/java/Images/"+listOfFiles[1].getName().toString());
	}
	
	@Given("I close Instagram")
		public void i_close_instagram() throws Exception {
		for(int i=0;i<=10;i++) {
			Thread.sleep(1000);
			System.out.print(+ i + " ");
			if(i==10) {
				System.out.println("");
				System.out.println("----READY----");
			}
		}
		driver.quit();
	}


}
