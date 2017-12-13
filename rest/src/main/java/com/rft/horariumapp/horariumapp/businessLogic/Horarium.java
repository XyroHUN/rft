package com.rft.horariumapp.horariumapp.businessLogic;

import com.rft.horariumapp.horariumapp.model.Activity;
import com.rft.horariumapp.horariumapp.model.Event;
import com.rft.horariumapp.horariumapp.model.Time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
			for (Time time : times) {
				int day = time.getDay();
				List<Integer> hours = time.getHours();

				for (int k = 0; k < hours.size(); k++) {
					int hour = hours.get(k);

					if (Cancer && hours.size() == 2) { //pureCancer (TM), kill me

						int size = hours.get(1) - hours.get(0) - 1;
						for (int h = 0; h < size; h++)
							hourList.add(hours.get(0) + h + 1 + day * 24);

						Collections.sort(hours);
					}

					hourList.add(hour + day * 24);
				}

			}
			categories.addCategory(name, hourList, rule1, rule2, rule3, rule4);

		}

		EvolutionEngine ee = new EvolutionEngine(categories, 100, 100, 35, 12, 12);
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

				if (day.equals(i / 24))
					hours.add(i % 24);
			}

		}

		if (!hours.isEmpty()) {
			return Time.builder().hours(hours).day(day).build();
		}

		return null;

	}

}
