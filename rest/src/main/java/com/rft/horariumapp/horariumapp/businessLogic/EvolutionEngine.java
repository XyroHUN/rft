package com.rft.horariumapp.horariumapp.businessLogic;

import java.util.Vector;

public class EvolutionEngine {

	public EvolutionEngine(Categories categories, int maxCycle, int populationSize, int unitMutationRate, int geneMutationRate, int boldGeneRatio) {
		
		this.maxCycle = maxCycle;

		averageFitness = new Vector<>();
		peakFitness = new Vector<>();
		
		this.e = new Environment(categories, populationSize, unitMutationRate, geneMutationRate, boldGeneRatio);

	}

	private Environment e;
	private Population p;
	private int maxCycle;
	private Vector<Integer> averageFitness;
	private Vector<Integer> peakFitness;

	public void evolution() {

		averageFitness.clear();
		peakFitness.clear();

		p = new Population(e);

		p.genesis();


		for (int currentCycle = 0; currentCycle < maxCycle; currentCycle++) {
			averageFitness.add(p.getavarageFitness());
			peakFitness.add(p.getPeakFitness());
			p.evolve();
			p.mutate();
			
		}

	}

	public Vector<Integer> getAverageFitness() {
		return averageFitness;
	}

	public Vector<Integer> getPeakFitness() {
		return peakFitness;
	}

	public String getAllTimeFittestGenome() {
		return p.getAllTimePeakGenome();
	}

	public int getAllTimePeakFitness() {
		return p.getAllTimePeakFitness();
	}
}
