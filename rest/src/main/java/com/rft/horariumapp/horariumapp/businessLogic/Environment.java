package bean;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Environment {

	private int populationSize;
	private String alphabet;
	private int unitMutationRate;
	private int geneMutationRate;
	private int boldGeneRate;
	private int genomeSize = 168;
	private Categories categories;

	public Environment(Categories categories, int populationSize, int unitMutationRate, int geneMutationRate, int boldGeneRatio) {

		this.categories = categories;
		this.populationSize = populationSize;
		this.alphabet = categories.getAlphabet();
		this.unitMutationRate = unitMutationRate;
		this.geneMutationRate = geneMutationRate;
		this.boldGeneRate = boldGeneRatio;
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

		
	private GroupedGenome groupingGenome(String genome) {
				
		genome = genome.replace( " ", "");
		
		//mindugyanaz a karakter - végtelen
		if(genome.length()>0)
		while(genome.charAt(0)==genome.charAt(genome.length()-1)) {
			genome = genome.charAt(0) + genome.substring(0, genome.length()-1);
		}
		
		GroupedGenome gg = new GroupedGenome();
		String geneSequence = genome.substring(0,1);
						
		for(int i = 1; i< genome.length(); i++) {
		
			
			
		
				if(genome.charAt(i)==geneSequence.charAt(geneSequence.length()-1)) {
				
					geneSequence += genome.charAt(i); 
				}
				
				else {
					gg.addGroup(geneSequence);
					geneSequence = "" + genome.charAt(i); 
				}
			
				
		}
		gg.addGroup(geneSequence);
		return gg;
		
	}
	
	public String generateGenome() {

		String s = "";
		for (int i = 0; i < genomeSize; i++)
			s += categories.getCategory(i, boldGeneRate);
		
		return s;
	}
	

	public int fitness(String genome) {
	
		int genomeFitness = 0;
		int feasible = 0;
		int weeklyCount = 0;
		int hourlyCount = 0;
		
		GroupedGenome gg = groupingGenome(genome);
		//gg.toString();
		
		for (int i = 0; i < genome.length(); i++)  
			if(categories.feasible(genome.charAt(i), i)) feasible++;
		
		for(int i = 0;i <gg.geneTypeCount();i++) {
			
			weeklyCount += categories.weeklyOptimal(gg.getGene(i), gg.getWeekly(i)) ? 1 : 0;
			hourlyCount += categories.hourlyOptimal(gg.getGene(i), gg.getHourly(i)) ? 1 : 0;
			
		}
		
		genomeFitness =( (100*feasible)/168 + (100*weeklyCount)/gg.geneTypeCount() + (100*hourlyCount)/gg.geneTypeCount())/3; 
		
		return genomeFitness;
	}

	public String mutateGenome(Unit u) {

		Random rand = new Random();
		String genome = "";

		for (int i = 0; i < genomeSize; i++) {
			genome += rand.nextInt(100) < geneMutationRate ? categories.getCategory(i, boldGeneRate)
					: u.getGenome().charAt(i);
		}

		return genome;
	}

}
