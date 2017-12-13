package com.rft.horariumapp.horariumapp.businessLogic;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

public class Horarium {

	private final boolean Cancer = true;
	private JSONObject task;

	public Horarium(JSONObject task) {
		this.task = task;

	}

	public JSONObject getResult() throws FileNotFoundException, IOException, ParseException {

		JSONObject result = (JSONObject) JSONValue.parse(task.toJSONString());

		Categories categories = new Categories();

		String name;
		int rule1, rule2, rule3, rule4;

		JSONArray categoryList = (JSONArray) result.get("activity");
		for (int i = 0; i < categoryList.size(); i++) {
			Vector<Integer> hourList = new Vector<Integer>();
			JSONObject category = (JSONObject) categoryList.get(i);
			JSONArray times = (JSONArray) category.get("time");
			JSONArray rules = (JSONArray) category.get("rules");

			rule1 = ((Long) rules.get(0)).intValue();
			rule2 = ((Long) rules.get(1)).intValue();
			rule3 = ((Long) rules.get(2)).intValue();
			rule4 = ((Long) rules.get(3)).intValue();

			name = (String) category.get("name");
			for (int j = 0; j < times.size(); j++) {
				JSONObject time = (JSONObject) times.get(j);
				int day = mapDays((String) time.get("day"));
				JSONArray hours = (JSONArray) time.get("hours");

				for (int k = 0; k < hours.size(); k++) {
					int hour = ((Long) hours.get(k)).intValue();					
					
					if(Cancer && hours.size()==2) { //pureCancer (TM), kill me
						
							int size = ((Long) hours.get(1)).intValue() - ((Long) hours.get(0)).intValue() - 1;
							for(int h = 0;h<size;h++)
								hourList.add((Integer)((Long) hours.get(0)).intValue()+h+1+day*24);

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

		for (int h = 0; h < categoryList.size(); h++) {

			JSONObject category = (JSONObject) categoryList.get(h);
			JSONArray times = (JSONArray) category.get("time");
			String categoryName = (String) category.get("name");

			JSONArray newTimes = new JSONArray();

			for (int j = 0; j < times.size(); j++) {
				JSONObject time = (JSONObject) times.get(j);
				JSONObject newTime = getNewTime(categories, genome, (String) time.get("day"), categoryName);
				if (!newTime.isEmpty())
					newTimes.add(newTime);

			}
			category.replace("time", newTimes);

		}

		return result;
	}

	private JSONObject getNewTime(Categories categories, String genome, String day, String category) {

		JSONObject newTime = new JSONObject();

		ArrayList<Integer> hours = new ArrayList<>();

		for (int i = 0; i < genome.length(); i++) {

			if (genome.charAt(i) != ' ' && categories.getCategoryName(genome.charAt(i)).equals(category)) {

				if (day.equals(mapDays(i / 24)))
					hours.add(i % 24);
			}

		}

		if (!hours.isEmpty()) {
			newTime.put("hours", hours);
			newTime.put("day", day);
		}

		return newTime;

	}

	private int mapDays(String day) { // pure Cancer (TM)
		return day.equals("Hétfő") ? 0
				: day.equals("Kedd") ? 1
						: day.equals("Szerda") ? 2
								: day.equals("Csütörtök") ? 3
										: day.equals("Péntek") ? 4 : day.equals("Szombat") ? 5 : 6;
	}

	private String mapDays(int day) {
		return day == 0 ? ("Hétfő")
				: day == 1 ? ("Kedd")
						: day == 2 ? ("Szerda")
								: day == 3 ? ("Csütörtök")
										: day == 4 ? ("Péntek") : day == 5 ? ("Szombat") : "Vasárnap";
	}

}
