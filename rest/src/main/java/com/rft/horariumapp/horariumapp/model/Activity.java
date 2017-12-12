package com.rft.horariumapp.horariumapp.model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
public class Activity {

	@Id
	private String id;

	private String ownerEmail;
	private String name;
	private List<Time> time;
	private List<Integer> rules;
	public void setOwnerEmail(String currentUserEmail) {
		// TODO Auto-generated method stub
		
	}

}
