package com.rft.horariumapp.horariumapp.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.rft.horariumapp.horariumapp.model.User;

public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired	
    private MongoClient mongoClient;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		MongoDatabase database = mongoClient.getDatabase("horariumdb");
        MongoCollection<Document> collection = database.getCollection("Users");
        Document document = collection.find(Filters.eq("email",email)).first();
        if(document!=null) {
            String password = document.getString("password");
            User mongoUserDetails = new User(email,password);
            return mongoUserDetails;
        }
        return null;
    }

}
