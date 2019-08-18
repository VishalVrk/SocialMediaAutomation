package stepDefenition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class FacebookDefinition{
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
    	driver.manage().window().maximize();
	}
	
	@Given("Facebook is open")
	public void facebook_is_open() {
		LaunchBrowser();
		System.out.println("Facebook is Open........");
		driver.get("https://www.facebook.com/");
	}
	
	@Given("I login using {string} username and {string} password")
	public void i_login_using_username_and_password(String emailId, String pass) throws Exception {
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		email.sendKeys(emailId);
		password.sendKeys(pass);	
		Thread.sleep(3000);
	}
	
	@Given("I click login")
	public void I_click_login() throws Exception {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver,10);
		WebElement LogInButton = driver.findElement(By.xpath("//label[@id='loginbutton']"));
		wait.until(ExpectedConditions.elementToBeClickable(LogInButton));
		LogInButton.click();
	}

	@Given("I send post from file {string}")
	public void i_send_post_from_file(String string) throws Exception {
		wait = new WebDriverWait(driver,10);
		WebElement TextArea = driver.findElement(By.xpath("//textarea"));
		wait.until(ExpectedConditions.visibilityOf(TextArea));
		try {
			String path = string;
	    	File file = new File(path);
	    	BufferedReader br = new BufferedReader(new FileReader(file)); 
	    	String st; 
	    	  while ((st = br.readLine()) != null) {
	  			TextArea.sendKeys(st.toString());
	    	  }   
			
		}
		catch(NoSuchElementException e) {
			wait.until(ExpectedConditions.visibilityOf(TextArea));
		}
		
	
	}

	@Given("I Add Images from file {string} and Caption from file {string}")
	public void i_Add_Images_from_file(String string, String path) throws Exception {
		WebElement TextArea = driver.findElement(By.xpath("//textarea"));
		TextArea.click();
		File folder = new File(string);
    	File[] listOfFiles = folder.listFiles();
		for(int i=0;i<listOfFiles.length;i++) {
		WebElement PhotoVideo = driver.findElement(By.xpath("//input[@type='file']"));
		PhotoVideo.sendKeys(string+"/"+listOfFiles[i].getName().toString());
		Thread.sleep(3000);
		}
		Thread.sleep(5000);
		WebElement Caption = driver.findElement(By.xpath("//div[@aria-label='Say something about these photos...']"));
		Caption.click();
		File file = new File(path);
    	BufferedReader br = new BufferedReader(new FileReader(file)); 
    	String st; 
    	  while ((st = br.readLine()) != null) {
  			Caption.sendKeys(st.toString());
    	  }   
	}

	@Given("I post content")
	public void i_post_content() throws Exception {
		Thread.sleep(3000);
		WebElement PostStatus = driver.findElement(By.xpath("//button//span[contains(text(),'Post')]"));
		PostStatus.click();
	}



}
