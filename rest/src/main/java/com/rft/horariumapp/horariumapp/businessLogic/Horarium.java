package com.rft.horariumapp.horariumapp.businessLogic;

import com.rft.horariumapp.horariumapp.model.Activity;
import com.rft.horariumapp.horariumapp.model.Event;
import com.rft.horariumapp.horariumapp.model.Time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import org.springframework.core.convert.converter.Converter;

public class Horarium {

	private final boolean Cancer = true;

	private final Converter<List<Activity>, List<Event>> activityListToEventListConverter;

	public Horarium() {
		activityListToEventListConverter = new ActivityListToEventListConverter();
	}
	
	public List<Event> getResult(List<Activity> activities) {

		Categories categories = new Categories();

		Random rand = new Random();
		String name;
		int rule1, rule2, rule3, rule4;

		for (Activity activity : activities) {
			Vector<Integer> hourList = new Vector<>();
			List<Time> times = activity.getTimes();
			List<Integer> rules = activity.getRules();

			rule1 = rules.get(0);
			rule2 = rules.get(1);
			rule3 = rules.get(2);
			rule4 = rules.get(3);
			name = activity.getName();
			int t = 0;
			for (Time time : times) {
				int day = time.getDay();
				List<Integer> hours = time.getHours();
				
				if(hours.size()-rule2 <= 0) {
					t = 0;
				}else {
					t = rand.nextInt(hours.size()-rule2) + 0;
				}
				
				if(rule2 > hours.size()) {
					for (int k = t; k < rule1+t; k++) {
						int hour = hours.get(k);
						hourList.add(hour + day * 24);						
					}
				}else {
					for (int k = t; k < rule2+t; k++) {
						int hour = hours.get(k);
						hourList.add(hour + day * 24);
					}
				}
/*				
				for (int k = 0; k < hours.size(); k++) {
					int hour = hours.get(k);


					hourList.add(hour + day * 24);
				}
*/
			}
			categories.addCategory(name, hourList, rule1, rule2, rule3, rule4);

		}

		EvolutionEngine ee = new EvolutionEngine(categories, 150, 150, 35, 12, 12);
		ee.evolution();

		String genome = ee.getAllTimeFittestGenome();

		for (Activity category : activities) {

			List<Time> times = category.getTimes();
			String categoryName = category.getName();

			ArrayList<Time> newTimes = new ArrayList<>();

			for (Time time : times) {
				Time newTime = getNewTime(categories, genome, time.getDay(), categoryName);
				if (newTime != null)
					newTimes.add(newTime);

			}
			category.setTimes(newTimes);

		}

		return activityListToEventListConverter.convert(activities);
	}

	private Time getNewTime(Categories categories, String genome, Integer day, String category) {

		ArrayList<Integer> hours = new ArrayList<>();
		
		for (int i = 0; i < genome.length(); i++) {

			if (genome.charAt(i) != ' ' && categories.getCategoryName(genome.charAt(i)).equals(category)) {

				if (day.equals(i / 24)) {
					hours.add(i % 24);
					
				}
			}

		}

		if (!hours.isEmpty()) {
			return Time.builder().hours(hours).day(day).build();
		}

		return null;

	}

}
