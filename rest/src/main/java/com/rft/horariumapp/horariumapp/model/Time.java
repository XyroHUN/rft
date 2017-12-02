package com.rft.horariumapp.horariumapp.model;

import java.util.List;

public class Time {
	
	public String day;
	public List<Integer> hours;

	public Time() {
		
	}
	
	public Time(String day, List<Integer> hours) {
		super();
		this.day = day;
		this.hours = hours;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public List<Integer> getHours() {
		return hours;
	}
	public void setHours(List<Integer> hours) {
		this.hours = hours;
	}

}
