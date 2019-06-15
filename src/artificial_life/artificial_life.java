/**
 * 
 */
package artificial_life;

import java.util.Random;
import java.util.ArrayList;
/**
 * @author John
 *
 */
public class artificial_life {
	
	private static ArrayList<Animal> animals = new ArrayList<Animal>();
	
	private static Random rand = new Random();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//create first 100 animals
		for( int i = 0; i<100; i++ ) {
			Animal child = new Animal();
			
			animals.add(child);
		}
		
		//iterate 1000 generations
		for( int g = 0; g<1000; g++) {
			
			ArrayList<Animal> children = new ArrayList<Animal>();
			
			for( Animal parent : animals ) {
				Animal mate = (Animal) animals.toArray()[rand.nextInt(animals.size()) + 1];
				Animal child = parent.mate(mate);
				
				children.add(child);				
			}
			
			animals = children;
		}
		
	}

}
