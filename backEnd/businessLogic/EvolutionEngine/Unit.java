import java.util.Random;

public class Unit {

	private String genome;
	private int fitness;

	public Unit(Environment e) {
		String genome = e.generateGenome();
		this.genome = genome;
		this.fitness = e.fitness(genome);
		
	}

	public Unit(Environment e, Unit u1, Unit u2) { // crossOver

		Random rand = new Random();
		Unit better;
		Unit worse;

		if (u1.getFitness() > u2.getFitness()) {
			better = u1;
			worse = u2;
		} else {
			better = u2;
			worse = u1;
		}

		String s = "";
		int chance = better.getFitness();
		String betterGenome = better.getGenome();
		String worseGenome = worse.getGenome();

		for (int i = 0; i < e.getGenomeSize(); i++)
			s += betterGenome.charAt(i) == worseGenome.charAt(i) 
					? betterGenome.charAt(i) 
					: rand.nextInt(100) <= chance 
						? betterGenome.charAt(i) 
						: worseGenome.charAt(i);

		this.genome = s;
		this.fitness = e.fitness(s);

	}

	public Unit(Environment e, Unit u) { // mutation

		Random rand = new Random();
		if (rand.nextInt(100) < e.getUnitMutationRate()) {
			
			String genome = e.mutateGenome(u);
			
			this.genome = genome;
			this.fitness = e.fitness(genome);
		}

		else
			this.genome = u.getGenome();
			this.fitness = u.getFitness();
	}

	public String getGenome() {
		return genome;
	}

	public int getFitness() {
		return fitness;
	}


}
