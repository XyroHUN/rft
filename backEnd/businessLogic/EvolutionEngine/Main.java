public class Main {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !";	
	
	public static void main(String[] args) {

		
		EvolutionEngine ee = new EvolutionEngine(100, 12,ALPHABET, 1000);
		
		ee.evolution();
		System.out.println(ee.getAllTimeFittestGenome());
		

	}

}
