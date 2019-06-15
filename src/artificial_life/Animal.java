package artificial_life;

import java.util.Random;
import java.util.ArrayList;

public class Animal {
	private ArrayList<BodyPart> bodyparts = new ArrayList<BodyPart>();
	private Random rand = new Random();
	
	private int numberlegs;

	public Animal() {
	   Body body = new Body();
	   
	   body.setLength( rand.nextInt(400) );
	   body.setWidth( rand.nextInt(400) );
	   body.setHeight( rand.nextInt(400) );
	   
	   bodyparts.add(body);
	   
	   this.setNumberlegs( rand.nextInt(8) + 2 );
	   
	   for( int i=0; i< this.getNumberlegs(); i++ ) {
		   Leg leg = new Leg();
		   
		   leg.setSide( ( i % 2 == 0 ) ? BodyPart.BodySide.LEFT : BodyPart.BodySide.RIGHT );
		   leg.setBodyx( (int) (((body.getLength() * 0.8) / (this.getNumberlegs() / 2) * i) + body.getLength() * 0.1 ));
		   leg.setBodyy( (int) ( rand.nextInt( body.getHeight() / 2 )));		   
		   
		   bodyparts.add(leg);
	   }	   	   
	}
	
	public Animal( Animal animal ) {
		
	}

	public int getNumberlegs() {
		return numberlegs;
	}

	public void setNumberlegs(int numberlegs) {
		this.numberlegs = numberlegs;
	}
}
