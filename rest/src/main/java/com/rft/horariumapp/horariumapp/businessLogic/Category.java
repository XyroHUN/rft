package com.rft.horariumapp.horariumapp.businessLogic;

import java.util.Vector;

public class Category {
	private String name;
	private char token;
	private int minOccasion;
	private int maxOccasion;
	private int minDuration;
	private int maxDuration;
	private Vector<Integer> hours;

	
	
	public Category(String name, char token, Vector<Integer> hours, int minOccasion, int maxOccasion, int minDuration, 
			int maxDuration) {
		super();
		this.name = name;
		this.token = token;
		this.minOccasion = minOccasion;
		this.maxOccasion = maxOccasion;
		this.minDuration = minDuration;
		this.maxDuration = maxDuration;
		this.hours = hours;
	}


	public Category() {
	}


	public String getName() {
		return name;
	}



	public char getToken() {
		return token;
	}



	public int getMinOccasion() {
		return minOccasion;
	}



	public int getMaxOccasion() {
		return maxOccasion;
	}



	public int getMinDuration() {
		return minDuration;
	}



	public int getMaxDuration() {
		return maxDuration;
	}



	public Vector<Integer> getHours() {
		return hours;
	}



	public boolean isValid() {
		boolean result = true;
		for (int h : hours) {
			result &= (h <= 167 && h >= 0);
		}
		result &= minOccasion <= maxOccasion && minOccasion >= 0 && minDuration <= maxDuration && minDuration >= 0
				&& maxDuration <= 24;

		return result;
	}

}
