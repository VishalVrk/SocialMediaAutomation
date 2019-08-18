package com.MAKERSTRIBE.SocialMediaManager;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoApp {
	
	
	public static void main(String[] args) {
		
		//Initialization
		MongoClient mongo = new MongoClient("localhost",27017);
		DB db = mongo.getDB("vishal");
		
		//Get DB names
		List<String> dbs = mongo.getDatabaseNames();
		for(String DB:dbs) {
			System.out.println(DB);
		}
		
		//Get Collection Names
		Set<String> tables = db.getCollectionNames();
		
		for(String coll:tables) {
			System.out.println(coll);
		}
		
		//ORM
//		DBCollection table = db.getCollection("users");
//		BasicDBObject document = new BasicDBObject();
//		document.put("name", "vishal");
//		document.put("age", 20);
//		document.put("createdDate",new Date());
//		table.insert(document);
		
		//Update Values using $set
//		DBCollection table = db.getCollection("users");
//		BasicDBObject query = new BasicDBObject();
//		query.put("name", "vishal");
//		BasicDBObject newDocument = new BasicDBObject();
//		newDocument.put("name", "vishal-updated");
//		BasicDBObject updateObj = new BasicDBObject();
//		updateObj.put("$set", newDocument);
//		table.update(query, updateObj);
		
		//Find example
//		DBCollection table = db.getCollection("users");
//		BasicDBObject searchQuery = new BasicDBObject();
//		searchQuery.put("name", "vishal-updated");
//		DBCursor cursor = table.find(searchQuery);
//		while (cursor.hasNext()) {
//			System.out.println(cursor.next());
//		}
		
		//Delete Example
		DBCollection table = db.getCollection("users");
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "vishal-updated");
		table.remove(searchQuery);
		DBCursor cursor = table.find();
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}


}
