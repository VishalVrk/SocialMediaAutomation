package com.MAKERSTRIBE.SocialMediaManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Random;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAutomation {
	
		static WebDriver driver;
		static String baseUrl = "http://demo.guru99.com/test/upload/";
	
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
		 driver = new ChromeDriver();
	}
	
	public void MessageArray() {
		String[] strArray = new String[] {
				"John",
				"Mary", 
				"Bob"};	
		for(int i=0; i<strArray.length;i++) {
			System.out.println(strArray[i]);
		}

	}
	
	public void FileReader() {

	}
	
	public static void ReadJson() throws Exception {
		File jsonInputFile = new File("/Users/vishalvaitheeswaranrk/eclipse-workspace/SocialMediaManager/src/test/java/resources/quotes.json");
        InputStream is= new FileInputStream(jsonInputFile);
        JsonReader reader = Json.createReader(is);
        JsonObject Obj = reader.readObject();
        reader.close();
        JsonArray arrObj = Obj.getJsonArray("quotes");
        int length = arrObj.size();
        System.out.println(length);
        Random rand = new Random();
        for(int j=0;j<100;j++) {
        for(int i=1;i<length-1;i++) {
        System.out.println(arrObj.getJsonObject(rand.nextInt(i)).get("quote").toString());

	}
        }
	}
	
	public static void main(String[] args) throws Exception {
		ReadJson();
		
	}

}

