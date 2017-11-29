package java.bean;

import java.util.Random;

public class Environment {

	private int populationSize;
	private String alphabet;
	private final int unitMutationRate = 50;
	private final int geneMutationRate = 30;
	private final int genomeSize = 168;
	private Categories categories;

	public Environment(Categories categories, int populationSize) {

		this.categories = categories;
		this.populationSize = populationSize;
		this.alphabet = categories.getAlphabet();
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

	private String applyBlanks(String genome) {
		
		if(categories.getBlanks() == null) return genome;
		
		else {
		
		String blanked = "";
		
		for(int i = 0;i < genomeSize; i++) {
			blanked += categories.getBlanks().contains(i) ? 'Z' : genome.charAt(i); 
		}
		
		return blanked;
		}
	}

	public String generateGenome() {

		String s = "";
		for (int i = 0; i < genomeSize; i++)
			s += categories.getCategory(i);
		
		return applyBlanks(s);
	}
	

	public int fitness(String genome) {
	
		int genomeFitness = 0;
		for (int i = 0; i < genome.length(); i++)  
			if(categories.feasible(genome.charAt(i), i)) genomeFitness++;
			
		
		return genomeFitness;
	}

	public String mutateGenome(Unit u) {

		Random rand = new Random();
		String genome = "";

		for (int i = 0; i < genomeSize; i++) {
			genome += rand.nextInt(100) < geneMutationRate ? categories.getCategory(i)
					: u.getGenome().charAt(i);
		}

		return applyBlanks(genome);
	}

}
