import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class Categories {

	private final int MAX_CATERORIES = 25;
	private final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y' };

	private int categoryCount;
	private Vector<Category> categories;
	private Vector<Integer> blanks;
	
	
 public int getCategoryCount() {
		return categoryCount;
	}

	public Categories() {
		categoryCount = 0;
		categories = new Vector<Category>();
	}

	public boolean addCategory(String name, Vector<Integer> hours, int minOccasion, int maxOccasion, int minDuration,
			int maxDuration) {
		if (categoryCount < MAX_CATERORIES) {
			char token = ALPHABET[categoryCount];
			categoryCount++;
			Category c = new Category(name, token, hours, minOccasion, maxOccasion, minDuration, maxDuration);
			categories.add(c);
			return true;
		} else
			return false;
	}


	
	public boolean feasible(char token, int hour) {
				
		if (token=='Z') return true;
		else {
		
			
			for(Category category : categories) if(category.getToken() == token) return category.getHours().contains(hour);
		
			return false; //' ' nincs pontozva, passz
		}
	}
	
	public char getCategory(int hour) {
		
Random rand = new Random();
		
		
		char token = ' ';
		
		Vector<Category> suitables = new Vector<Category>();
		
		for(Category c:categories) if(c.getHours().contains(hour)) suitables.add(c);
		
		return suitables.size()==0 ? token : suitables.elementAt(rand.nextInt(suitables.size())).getToken();
	}

	public void test() {
		for(Category c:categories) {
			System.out.println(c.getName() + " "  + c.getToken() + " " +c.getHours().toString());
		}
		System.out.println(categoryCount);
	}
	
	public String getAlphabet() {
		return new String(Arrays.copyOfRange(ALPHABET, 0, categoryCount));
	}



	public Vector<Integer> getBlanks() {
		return blanks;
	}



	public void setBlanks(Vector<Integer> blanks) {
		this.blanks = blanks;
	}
	
}
