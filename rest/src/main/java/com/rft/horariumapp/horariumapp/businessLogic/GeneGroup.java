package bean;

public class GeneGroup {
	
	private char gene;
	private int weekly;
	private int hourlyWeight;
	private int hourlyTotal;
	
	public GeneGroup(char gene) {
		this.gene = gene;
		this.weekly=0;
		this.hourlyWeight=0;
		this.hourlyTotal=0;
	}
	
	public boolean match(char gene){
		return gene == this.gene; 
	}

	public int getWeekly() {
		return weekly;
	}

	public int getHourly() {
		return hourlyTotal/hourlyWeight;
	}
	
	public char getGene() {
		return gene;
	}
		
	public void increaseWeekly() {weekly++;}
	
	public void addHours(int hours) {hourlyWeight++; hourlyTotal+=hours;}

}
