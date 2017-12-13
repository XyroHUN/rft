package com.rft.horariumapp.horariumapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
	private List<Time> times;
	private List<Integer> rules;

}
