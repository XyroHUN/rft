package com.rft.horariumapp.horariumapp.businessLogic;

import java.util.Vector;

public class GroupedGenome {
		
	private Vector<GeneGroup> genes;
	
	
	
	public GroupedGenome() {
		genes = new Vector<GeneGroup>();
	}



	public void addGroup(String sequence) {
		boolean exist = false;
		for(int i = 0; i<genes.size();i++) {
			if(genes.elementAt(i).match(sequence.charAt(0))) {
				genes.elementAt(i).increaseWeekly();
				genes.elementAt(i).addHours(sequence.length());
				exist = true;
			}
		}
		
		if(!exist) {
			genes.add(new GeneGroup(sequence.charAt(0)));
			genes.lastElement().increaseWeekly();
			genes.lastElement().addHours(sequence.length());
			exist = false;
		}
		
	}
	
	public int geneTypeCount() {return genes.size();}


	public int getWeekly(int i) {
		return genes.elementAt(i).getWeekly();
	}

	public int getHourly(int i) {
		return genes.elementAt(i).getHourly();
	}
	
	public char getGene(int i) {
		return genes.elementAt(i).getGene();
	}
	

	@Override
	public String toString() {

		for(GeneGroup ggr : genes) 
			System.out.print(genes.size() +""+ggr.getGene()+""  + ggr.getWeekly()+""+ggr.getHourly()+" ");
	
		
		return "";
		
	}
	
	

}
