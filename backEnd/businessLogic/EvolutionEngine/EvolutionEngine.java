import java.util.Vector;

public class EvolutionEngine {


  public EvolutionEngine(int populationSize, int genomeSize, String alphabet, int maxCycle) {
    this.maxCycle = maxCycle;
    this.populationSize = populationSize;
    this.genomeSize=genomeSize;
    this.alphabet=alphabet;
    
    averageFitness = new Vector<>();
    peakFitness = new Vector<>();
    
    e = new Environment(populationSize, genomeSize, alphabet); 
    p = new Population(e);
    p.genesis();
  }


  private Environment e;
  private Population p;
  private int maxCycle;
  private Vector<Integer> averageFitness;
  private Vector<Integer> peakFitness;
  private String allTimeFittestGenome;
  private int allTimePeakFitness;
  private int populationSize;
  private int genomeSize;
private String alphabet;


  
  public void evolution() {

	  
	  
    for (int currentCycle = 0; currentCycle < maxCycle; currentCycle++) {

      averageFitness.add(p.getavarageFitness());
      peakFitness.add(p.getPeakFitness());
      p.evolve();
      p.mutate();
    }

    allTimeFittestGenome = p.getAllTimePeakGenome();
    allTimePeakFitness = p.getAllTimePeakFitness();
    
    //clean up for next run
    
	averageFitness.clear();
	peakFitness.clear();
	
	e = new Environment(populationSize, genomeSize, alphabet); 
    p = new Population(e);
    p.genesis();
  }

 
  public Vector<Integer> getAverageFitness() {
    return averageFitness;
  }

 
  public Vector<Integer> getPeakFitness() {
    return peakFitness;
  }

  public String getAllTimeFittestGenome() {
    return allTimeFittestGenome;
  }

 
  public int getAllTimePeakFitness() {
    return allTimePeakFitness;
  }
}
