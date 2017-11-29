package java.bean;

import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {

		Categories categories = new Categories();

		categories.addCategory("Kategória 1", new Vector<Integer>(Arrays.asList( 1,2,3,4,5)), 2, 3, 2, 2);
		categories.addCategory("Kategória 2", new Vector<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,100,150,25)), 2, 3, 2, 2);
		categories.addCategory("Kategória 3", new Vector<Integer>(Arrays.asList(16,7,8,9,10,11,12,13,14)), 2, 3, 2, 2);
		categories.addCategory("Kategória 4", new Vector<Integer>(Arrays.asList(1,2,3,4,5,15,16,17,18,19)), 2, 3, 2, 2);
		categories.addCategory("Kategória 5", new Vector<Integer>(Arrays.asList(55,56,57,58,59)), 2, 3, 2, 2);
		categories.addCategory("Kategória 6", new Vector<Integer>(Arrays.asList(10,20,23,25,60,61,62,63,64,65)), 2, 3, 2, 2);
		categories.addCategory("Kategória 7", new Vector<Integer>(Arrays.asList(1,11,12,12,44,54,23,100,150,25,60,61,62,63,64,65)), 2, 3, 2, 2);
		
		categories.setBlanks(new Vector<Integer>(Arrays.asList(20,21,22,23,24)));
		
		
		EvolutionEngine ee = new EvolutionEngine(categories, 1, 1);//1000, 100

		ee.evolution();System.out.println(ee.getAllTimePeakFitness() + ": " + ee.getAllTimeFittestGenome());
		ee.evolution();System.out.println(ee.getAllTimePeakFitness() + ": " + ee.getAllTimeFittestGenome());
		ee.evolution();System.out.println(ee.getAllTimePeakFitness() + ": " + ee.getAllTimeFittestGenome());
		ee.evolution();System.out.println(ee.getAllTimePeakFitness() + ": " + ee.getAllTimeFittestGenome());
		ee.evolution();System.out.println(ee.getAllTimePeakFitness() + ": " + ee.getAllTimeFittestGenome());
		ee.evolution();System.out.println(ee.getAllTimePeakFitness() + ": " + ee.getAllTimeFittestGenome());
		
		
		//categories.test();
		
	}

}
