package com.rft.horariumapp.horariumapp.businessLogic;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {

		Categories categories = new Categories();

		categories.addCategory("Kategória 1", new Vector<Integer>(Arrays.asList(1,2,3,4,5)), 2, 3, 2, 2);
		categories.addCategory("Kategória 2", new Vector<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,100,150,25)), 2, 3, 2, 2);
		categories.addCategory("Kategória 3", new Vector<Integer>(Arrays.asList(16,7,8,9,10,11,12,13,14)), 2, 3, 2, 2);
		categories.addCategory("Kategória 4", new Vector<Integer>(Arrays.asList(1,2,3,4,5,15,16,17,18,19)), 2, 3, 2, 2);
		categories.addCategory("Kategória 5", new Vector<Integer>(Arrays.asList(55,56,57,58,59)), 2, 3, 2, 2);
		categories.addCategory("Kategória 6", new Vector<Integer>(Arrays.asList(10,20,23,25,60,61,62,63,64,65)), 2, 3, 2, 2);
		categories.addCategory("Kategória 7", new Vector<Integer>(Arrays.asList(1,11,12,12,44,54,23,100,150,25,60,61,62,63,64,65)), 2, 3, 2, 2);
		categories.addCategory("Kategória 8", new Vector<Integer>(Arrays.asList(0,160, 161)), 2, 3, 2, 2);

		/*
		EvolutionEngine ee1 = new EvolutionEngine(categories, 100, 100, 35, 12, 12);		
		ee1.evolution();System.out.println(ee1.getAllTimePeakFitness() + ": " + ee1.getAllTimeFittestGenome());
		
		EvolutionEngine ee2 = new EvolutionEngine(categories, 100, 100, 5, 5, 5);		
		ee2.evolution();System.out.println(ee2.getAllTimePeakFitness() + ": " + ee2.getAllTimeFittestGenome());
		
		EvolutionEngine ee3 = new EvolutionEngine(categories, 100, 100, 60, 60, 60);		
		ee3.evolution();System.out.println(ee3.getAllTimePeakFitness() + ": " + ee3.getAllTimeFittestGenome());
		*/
		
		for(int i=0;i<100;i++){
			Random r = new Random(); 
			int r1 = r.nextInt(80)+5;
			int r2 = r.nextInt(80)+5;
			int r3 = r.nextInt(50)+5;
			int r4 = r.nextInt(125)+25;
			int r5 = r.nextInt(125)+25;
			System.out.print(r4 + " " + r5 + ", " + r1 + " " + r2 + " " + r3+": ");
			EvolutionEngine ee = new EvolutionEngine(categories, r4, r5, r1,r2,r3);		
			ee.evolution();System.out.println(ee.getAllTimePeakFitness());//ee.getAllTimeFittestGenome());
		}
		
		//categories.test();
		
	}

}
