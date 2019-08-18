package com.MAKERSTRIBE.SocialMediaManager;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoInsertDocument {
	public static void main(String[] args) {
		
		MongoClient mongo = new MongoClient("localhost",27017);
		DB db = mongo.getDB("vishal");
		
		DBCollection collection = db.getCollection("users");
		
		//BasicDBObjectBuilder example
//		BasicDBObject document = new BasicDBObject();
//		document.put("database", "vishal");
//		document.put("table", "hosting");
//		BasicDBObject documentDetail = new BasicDBObject();
//		documentDetail.put("records", 99);
//		documentDetail.put("index", "vps_index1");
//		documentDetail.put("active", "true");
//		
//		document.put("detail",documentDetail);
//		collection.insert(document);
		
//		DBCollection table = db.getCollection("users");
//		BasicDBObject searchQuery = new BasicDBObject();
//		searchQuery.put("database", "vishal");
//		table.remove(searchQuery);
		
		//Map example
//		Map<String, Object> documentMap = new HashMap<String, Object>();
//		documentMap.put("database", "vishal");
//		documentMap.put("table", "hosting");
//		
//		Map<String, Object> documentMapDetail = new HashMap<String, Object>();
//		documentMapDetail.put("records", 99);
//		documentMapDetail.put("index", "vps_index1");
//		documentMapDetail.put("active", "true");
//		
//		documentMap.put("detail", documentMapDetail);
//		
//		collection.insert(new BasicDBObject(documentMap));
		
//		JSON parse example
		String json ="";
				  
		DBObject dbObject = (DBObject)JSON.parse(json);
		
		collection.insert(dbObject);
		
		DBCursor cursor = collection.find();
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		
	}

}
