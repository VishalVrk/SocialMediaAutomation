package com.MAKERSTRIBE.SocialMediaManager;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoUpdateDocument {
	static DBCollection collection;
	static DBCursor cursor;
	
	public void dummyData() {
		BasicDBObject document = new BasicDBObject();
		document.put("hosting", "hostA");
		document.put("type", "vps");
		document.put("clients", 1000);

		BasicDBObject document2 = new BasicDBObject();
		document2.put("hosting", "hostB");
		document2.put("type", "dedicated server");
		document2.put("clients", 100);

		BasicDBObject document3 = new BasicDBObject();
		document3.put("hosting", "hostC");
		document3.put("type", "vps");
		document3.put("clients", 900);
		collection.insert(document3);
	}
	
	public void Search(String key,String value) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put(key, value);
		collection.find(searchQuery);
		cursor = collection.find(searchQuery);
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	
	public void LogAll() {
		cursor = collection.find();
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	
	public void updateInc(BasicDBObject document,String key ,int value) {
		document = 
				new BasicDBObject().append("$inc", 
				new BasicDBObject().append("total "+key, value));
	}
	
	
	public static void main(String[] args) {
		MongoClient mongo = new MongoClient("localhost",27017);
		DB db = mongo.getDB("vishal");
		collection = db.getCollection("hosting");
		
		MongoUpdateDocument doc = new MongoUpdateDocument();
		BasicDBObject document=new BasicDBObject().append("$inc", new BasicDBObject().append("total clients", 99));
		collection.update(new BasicDBObject().append("hosting", "hostB"), document);
		doc.LogAll();
		
		
	}
	
	
	


}
