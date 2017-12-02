package com.rft.horariumapp.horariumapp.model;

import java.util.List;

public class Task {
	
	public String name;
	public List<Time> time;
	public List<Integer> rules;
	
	public Task() {
		
	}
	
	public Task(String name, List<Time> time, List<Integer> rules) {
		super();
		this.name = name;
		this.time = time;
		this.rules = rules;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Time> getTime() {
		return time;
	}

	public void setTime(List<Time> time) {
		this.time = time;
	}

	public List<Integer> getRules() {
		return rules;
	}

	public void setRules(List<Integer> rules) {
		this.rules = rules;
	}
	
}
