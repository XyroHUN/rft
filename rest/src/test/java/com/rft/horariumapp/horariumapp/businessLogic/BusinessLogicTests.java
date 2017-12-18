import com.rft.horariumapp.horariumapp.businessLogic.*;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BusinessLogicTests {
	
	static Categories c0;
	static Categories c1;
	static Categories c2;
	static Categories c3;
	static Categories c4;
	static Categories c5;
	
	static EvolutionEngine ee0;
	static EvolutionEngine ee1;
	static EvolutionEngine ee2;
	static EvolutionEngine ee3;
	static EvolutionEngine ee4;
	static EvolutionEngine ee5;
	static EvolutionEngine ee6;
	static EvolutionEngine ee7;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("Test starts.");

		c0 = new Categories();
		c0.addCategory("K0", new Vector<Integer>(Arrays.asList(0, 1, 2, 3, 4)), 1, 1, 1, 1);

		c1 = new Categories();
		c1.addCategory("K0", new Vector<Integer>(Arrays.asList(0, 1, 2, 3, 4)), 1, 1, 1, 1);
		c1.addCategory("K1", new Vector<Integer>(Arrays.asList(5, 6, 7, 8, 9)), 1, 1, 1, 1);

		c2 = new Categories();
		c2.addCategory("K0", new Vector<Integer>(Arrays.asList(0, 1, 2, 3, 4)), 1, 1, 1, 1);
		c2.addCategory("K1", new Vector<Integer>(Arrays.asList(5, 6, 7, 8, 9)), 1, 1, 1, 1);
		c2.addCategory("K3", new Vector<Integer>(Arrays.asList(10, 11, 12, 13, 14)), 1, 1, 1, 1);
				
		c3 = new Categories();
		c3.addCategory("K0", new Vector<Integer>(Arrays.asList(0)), 1, 1, 1, 1);
		c3.addCategory("K1", new Vector<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)), 1, 1, 1, 1);
		c3.addCategory("K3", new Vector<Integer>(Arrays.asList(167)), 1, 1, 1, 1);

		c4 = new Categories();
		c4.addCategory("K0", new Vector<Integer>(Arrays.asList(0, 1, 2, 3, 4)), 10, 10, 10, 10);
		c4.addCategory("K1", new Vector<Integer>(Arrays.asList(5, 6, 7, 8, 9)), 2, 3, 4, 5);
		c4.addCategory("K3", new Vector<Integer>(Arrays.asList(10, 11, 12, 13, 14)), 6, 7, 8, 9);
		
		c5 = new Categories();
		c5.addCategory("K0", new Vector<Integer>(Arrays.asList(10, 20, 30, 40, 50)), 1, 2, 1, 2);
		c5.addCategory("K1", new Vector<Integer>(Arrays.asList(0, 1, 2, 3, 4)), 2, 3, 2, 2);
		c5.addCategory("K3", new Vector<Integer>(Arrays.asList(2, 15, 100, 30, 14, 75)), 2, 4, 1, 1);
			
		ee0 = new EvolutionEngine(c0, 10, 10, 35, 12, 12);
		ee0.evolution();
		
		ee1 = new EvolutionEngine(c1, 10, 10, 35, 12, 12);
		ee1.evolution();
		
		ee2 = new EvolutionEngine(c2, 10, 10, 35, 12, 12);
		ee2.evolution();
		
		ee3 = new EvolutionEngine(c3, 10, 10, 35, 12, 12);
		ee3.evolution();
		
		ee4 = new EvolutionEngine(c4, 10, 10, 0, 100, 0);
		ee4.evolution();
		
		ee5 = new EvolutionEngine(c4, 10, 100, 100, 0, 0);
		ee5.evolution();
		
		ee6 = new EvolutionEngine(c4, 100, 100, 35, 12, 12);
		ee6.evolution();
		
		ee7 = new EvolutionEngine(c5, 100, 100, 35, 12, 12);
		ee7.evolution();
		
		
		c0.test();
		c1.test();
		c2.test();
		c3.test();
		c4.test();
		c5.test();

		System.out.println(ee0.getAllTimePeakFitness() + ": " + ee0.getAllTimeFittestGenome());
		System.out.println(ee1.getAllTimePeakFitness() + ": " + ee1.getAllTimeFittestGenome());
		System.out.println(ee2.getAllTimePeakFitness() + ": " + ee2.getAllTimeFittestGenome());
		System.out.println(ee3.getAllTimePeakFitness() + ": " + ee3.getAllTimeFittestGenome());
		System.out.println(ee4.getAllTimePeakFitness() + ": " + ee4.getAllTimeFittestGenome());
		System.out.println(ee5.getAllTimePeakFitness() + ": " + ee5.getAllTimeFittestGenome());
		System.out.println(ee6.getAllTimePeakFitness() + ": " + ee6.getAllTimeFittestGenome());
		System.out.println(ee7.getAllTimePeakFitness() + ": " + ee7.getAllTimeFittestGenome());
		
		System.out.println("Test ends.");
	}

	@Test
	public void test() {
		
		assertNotNull(c0);
		assertNotNull(c1);
		assertNotNull(c2);
		assertNotNull(c3);
		assertNotNull(c4);
		assertNotNull(c5);
		assertNotNull(ee0);
		assertNotNull(ee1);
		assertNotNull(ee2);
		assertNotNull(ee3);
		assertNotNull(ee4);
		assertNotNull(ee5);
		assertNotNull(ee6);
		assertNotNull(ee7);
		// fail("Not yet implemented");
	}

}
