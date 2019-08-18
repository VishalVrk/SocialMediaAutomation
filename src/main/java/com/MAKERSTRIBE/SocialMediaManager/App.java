package com.MAKERSTRIBE.SocialMediaManager;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class App 
{
	static WebDriver driver;
	
	public static void LaunchBrowser(String url) {
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
    	driver = new ChromeDriver(chromeOptions);
    	driver.get(url);
	}
	
	public static void MongoDBLaunch(DB db) {
		DBCollection table = db.getCollection("test");
		BasicDBObject urlDocument = new BasicDBObject();
		urlDocument.append("url", "https://www.google.com/");
		urlDocument.append("username", "vishalcool.vaitheeswaran");
		urlDocument.append("password", "ind-pplmt0000382");
		table.insert(urlDocument);
		DBCursor cursor = table.find();
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	
	
    public static void main( String[] args ) throws Exception{
    	MongoClient mongo = new MongoClient("localhost",27017);
		DB db = mongo.getDB("vishal");		
		DBCollection table = db.getCollection("test");
		DBCursor cursor = table.find();
		table.findOne();
//		LaunchBrowser(url);
		
    }

    }

