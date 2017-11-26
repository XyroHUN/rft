import java.util.Random;

public class Environment {

	// public int fitness();

	private int populationSize;
	private int genomeSize;
	private String alphabet;
	private final int unitMutationRate = 8;
	private final int geneMutationRate = 2;
	private String fitnessRules;
	
	public Environment(String fitnessRules, int populationSize, int genomeSize, String alphabet) {

		this.fitnessRules = fitnessRules;
		this.populationSize = populationSize;
		this.genomeSize = genomeSize;
		this.alphabet = alphabet;
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public int getGenomeSize() {
		return genomeSize;
	}

	public String getAlphabet() {
		return alphabet;
	}

	
	
	public int getUnitMutationRate() {
		return unitMutationRate;
	}

	public int getGeneMutationRate() {
		return geneMutationRate;
	}

	public String generateGenome() {

		Random rand = new Random();
		String s = "";
		for (int i = 0; i < genomeSize; i++)
			s += alphabet.charAt(rand.nextInt(alphabet.length()));

		return s;
	}

	public int fitness(String genome) { 
		// 0 is a no match, 100 is a perfect
		// hardwired for crossover - unit constructor(100%) if changed here should be changed there too
		// match - peakUnit

		/*
		blank alkalmazása rá / algortmus belerakja
		jó idõben - 1 pont
		szakaszok darabszáma - minimum - 1 pont
		szakaszok darabszáma - maximum - 1 pont
		szakaszok hossza - minimum/maximum 1-1 pont
		átcsszás naponta/hetente
		több szakasz, több pont?
		*/
		
		int genomeFitness = 0;
		String drive = "Hello World!";
		

			if (genome.equals(drive))
				genomeFitness = 100;
			else {

				int geneFitness = Math.round(100 / genomeSize); //optimalized

				for (int i = 0; i < genome.length(); i++) {
					genomeFitness += genome.charAt(i) == drive.charAt(i) ? geneFitness : 0;
				}

			}
		
		return genomeFitness;

	}

}
