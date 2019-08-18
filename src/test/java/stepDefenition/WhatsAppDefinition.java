package stepDefenition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WhatsAppDefinition {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
		driver = new ChromeDriver();
    	driver.manage().window().maximize();
	}
	
	
	
	@Given("WhatsApp is open")
	public void whatsapp_is_open() {
			LaunchBrowser();
	    	System.out.println("WhatsApp is Open");
			driver.get("https://web.whatsapp.com/");
	}

	@Given("I wait till the user has Logged in using Barcode")
	public void i_wait_till_the_user_has_Logged_in_using_Barcode() throws Exception {
		wait = new WebDriverWait(driver, 30);
		System.out.println("30 Secound Timer for entering Bar code");
		System.out.println("Time: ");
		for(int i=0;i<=10;i++) {
			Thread.sleep(1000);
			System.out.print(+ i + " ");
			if(i==10) {
				System.out.println("");
				System.out.println("----READY----");
			}
		}
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		System.out.println("Barcode Entered Y/N");
		String value = scn.nextLine();
		if(value.equalsIgnoreCase("y")) {
		System.out.println("Initiating WhatsApp Automation........");
		System.out.println("Welcome to WhatsApp Automation Framework...");
		
		}
	}
	
	@And("I Create a new group")
	public void I_Create_a_new_group() {
		WebElement Menu  = driver.findElement(By.xpath("//div[@class='_3j8Pd']//div[@title='Menu']"));	
		wait.until(ExpectedConditions.elementToBeClickable(Menu));
		Menu.click();
		System.out.println("New Group Creation Initiated....");
		WebElement NewGroup = driver.findElement(By.xpath("//div[@class='_3zy-4 Sl-9e' and @title='New group']"));
		NewGroup.click();
		
	}

	@Then("^I Add Contacts \"([^\"]*)\" from search to the group$")
	public void i_Add_Contacts_from_search_to_the_group(String contacts) throws Exception {
		WebElement SearchContact = driver.findElement(By.xpath("//input[@class='_44uDJ copyable-text selectable-text']"));
		SearchContact.sendKeys(contacts);
		Thread.sleep(2000);
		SearchContact.sendKeys(Keys.RETURN);
		System.out.println("Contact "+ contacts.toUpperCase() + " Added");
	}

	@Then("^I proceed and Name the group as \"([^\"]*)\"$")
	public void i_Name_the_group_as(String GroupName) throws Exception {
		WebElement NextButton = driver.findElement(By.xpath("//div[@class='_1g8sv']"));
		NextButton.click();
		WebElement GroupValue = driver.findElement(By.xpath("//div[@class='_3u328 copyable-text selectable-text']"));
		GroupValue.sendKeys(GroupName);
		WebElement Select = driver.findElement(By.xpath("//div[@class='_1g8sv']"));
		Select.click();
		System.out.println("WhatsApp Group Successfully Created With Group Name " + GroupName.toUpperCase());
		for(int i=0;i<=5;i++) {
			Thread.sleep(1000);
			System.out.print(+ i + " ");
			if(i==10) {
				System.out.println("");
				System.out.println("----READY----");
			}
		}
	}

	@Then("I send images to the group from the file")
	public void i_send_images_to_the_group_from_the_file() throws Exception {
		
		File folder = new File("src/test/java/Images");
    	File[] listOfFiles = folder.listFiles();
    	
    	System.out.println("Folder Loaded Success");
    	for (int i = 0; i < listOfFiles.length; i++) {
        	 System.out.println("Searching For Files......");
        	WebElement Attach = driver.findElement(By.xpath("(//div[@class='_3j8Pd'])[5]"));
        	Attach.click();
			System.out.println("No of files found" +i);
			System.out.println("/Users/vishalvaitheeswaranrk/eclipse-workspace/SocialMediaManager/src/test/java/Images/" + listOfFiles[i].getName());
			WebElement PhotoUpload = driver.findElement(By.xpath("//input[@type='file' and @accept='image/*,video/mp4,video/3gpp,video/quicktime']"));
			PhotoUpload.sendKeys("/Users/vishalvaitheeswaranrk/eclipse-workspace/SocialMediaManager/src/test/java/Images/"+ listOfFiles[i].getName().toString());
			System.out.println("Upload Complete....." +i);
			Thread.sleep(5000);
			WebElement SendPhotos = driver.findElement(By.xpath("//div[@class='_1g8sv NOJWi']"));
			SendPhotos.click();
    		}  
        	  }
	
	@And("^I search for name \"([^\"]*)\"$")
	public void I_search_for_name(String name) throws Exception {
		WebElement NewChat = driver.findElement(By.xpath("//div[@title='New chat']"));
		NewChat.click();
		for(int i=0;i<=5;i++) {
			Thread.sleep(1000);
			System.out.print(+ i + " ");
			if(i==5) {
				System.out.println("");
				System.out.println("----READY----");
			}
		}
		WebElement SearchElement = driver.findElement(By.xpath("//input[@title='Search contacts']"));
		SearchElement.click();
		SearchElement.sendKeys(name);
		System.out.println("Searching For the name: " +name.toUpperCase());
		System.out.println("Successfully Found Element");
		
		
	}
	@And("I Select the Contact")
	public void i_select_the_contact() throws Exception {
		for(int i=0;i<=5;i++) {
			Thread.sleep(1000);
			System.out.print(+ i + " ");
			if(i==5) {
				System.out.println("");
				System.out.println("----READY----");
			}
		}
	 WebElement SelectContact = driver.findElement(By.xpath("(//div[@class='_2WP9Q'])[1]"));
	 SelectContact.click();
	 System.out.println("Sucessfully found contact");
	}
	
	
	@Given("I send {string} message")
	public void i_send_message(String message) throws Exception {

		for(int i=0;i<=5;i++) {
			Thread.sleep(1000);
			System.out.print(+ i + " ");
			if(i==10) {
				System.out.println("");
				System.out.println("----READY----");
			}
		}
		WebElement MessageBox = driver.findElement(By.className("_13mgZ"));
		MessageBox.click();
		MessageBox.sendKeys(message);
		WebElement Send = driver.findElement(By.className("_3M-N-"));
		Send.click();
		System.out.println("Message Sent Sucess");
	}

	@Given("I send {string} message {int} times")
	public void i_send_message_times(String message, int value) throws Exception {
		for(int i=0;i<value;i++) {
		WebElement MessageBox = driver.findElement(By.className("_13mgZ"));
		MessageBox.sendKeys(message);
		WebElement Send = driver.findElement(By.className("_3M-N-"));
		
		try {
			
			Send.click();
			} catch (NoSuchElementException e) {
				MessageBox.sendKeys("Exception");
				Send.click();
			}
		
		System.out.println("Message Count: "+ i);
		}
	}
	
	@Given("I send {int} times Quote")
	public void i_send_Quotes(int value) throws Exception {
		File jsonInputFile = new File("/Users/vishalvaitheeswaranrk/eclipse-workspace/SocialMediaManager/src/test/java/resources/quotes.json");
        InputStream is= new FileInputStream(jsonInputFile);
        JsonReader reader = Json.createReader(is);
        JsonObject Obj = reader.readObject();
        reader.close();
        JsonArray arrObj = Obj.getJsonArray("quotes");
        int length = arrObj.size();
        System.out.println(length);
        Random rand = new Random();
        for(int i=1;i<value;i++) {
        	WebElement MessageBox = driver.findElement(By.className("_13mgZ"));
    		MessageBox.sendKeys(arrObj.getJsonObject(rand.nextInt(30)).get("quote").toString());
    		WebElement Send = driver.findElement(By.className("_3M-N-"));
    		Send.click();
        }
		
    }
}

