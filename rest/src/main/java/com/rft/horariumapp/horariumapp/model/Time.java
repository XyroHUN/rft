package com.rft.horariumapp.horariumapp.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Time {
	
	public Integer day;
	public List<Integer> hours;

}
