package artificial_life;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;


public class Animal {
	private Body body = new Body();
	
	private ArrayList<Leg> legs = new ArrayList<Leg>();
	private Random rand = new Random();
	
	private int numberlegs;

	public Animal() {	   	   
	   this.body.setLength( rand.nextInt(400) );
	   this.body.setWidth( rand.nextInt(400) );
	   this.body.setHeight( rand.nextInt(400) );
	   	   
	   this.setNumberlegs( rand.nextInt(8) + 2 );
	   
	   for( int i=0; i< this.getNumberlegs(); i++ ) {
		   Leg leg = new Leg();
		   
		   leg.setSide( ( i % 2 == 0 ) ? BodyPart.BodySide.LEFT : BodyPart.BodySide.RIGHT );
		   leg.setBodyx( (int) (((body.getLength() * 0.8) / (this.getNumberlegs() / 2) * i) + body.getLength() * 0.1 ));
		   leg.setBodyy( (int) ( rand.nextInt( body.getHeight() / 2 )));		   
		   
		   legs.add(leg);
	   }	   	   
	}
	
	public Animal mate( Animal other ) {
		Animal child = new Animal();
		
		Body childbody = new Body();
		
		childbody.setLength( Math.round( (this.getBody().getLength() + other.getBody().getLength()) / 2 + ( rand.nextInt(20) - 10) ) ); 
		childbody.setWidth( Math.round( (this.getBody().getWidth() + other.getBody().getWidth()) / 2 + ( rand.nextInt(20) - 10) ) );		
		childbody.setHeight( Math.round( (this.getBody().getHeight() + other.getBody().getHeight()) / 2 + ( rand.nextInt(20) - 10) ) );		
	    	
		child.setNumberlegs( Math.round((this.getNumberlegs() + other.getNumberlegs()) / 2 ) );
		
		Leg myleg = this.getAverageLeg();
		Leg otherleg = other.getAverageLeg();
		
		int upperleg = Math.round( ( myleg.getUpperleg() + otherleg.getUpperleg() ) / 2  + ( rand.nextInt(20) - 10) );
		int lowerleg = Math.round( ( myleg.getLowerleg() + otherleg.getLowerleg() ) / 2  + ( rand.nextInt(20) - 10) );		
		
        ArrayList<Leg> childlegs = child.getLegs();
        
        if ( childlegs.size() > 0 ) {
        	childlegs.clear();
        }

 	    for( int i=0; i< this.getNumberlegs(); i++ ) {
		   Leg leg = new Leg();
		   
		   leg.setSide( ( i % 2 == 0 ) ? BodyPart.BodySide.LEFT : BodyPart.BodySide.RIGHT );
		   
		   leg.setUpperleg(upperleg);
		   leg.setLowerleg(lowerleg);
		   
		   childlegs.add(leg);
 	    }
		  		
		return child;
	}
	
	/**
	 * @return the body
	 */
	public Body getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(Body body) {
		this.body = body;
	}	

	public int getNumberlegs() {
		return numberlegs;
	}

	public void setNumberlegs(int numberlegs) {
		this.numberlegs = numberlegs;
	}
	
	public ArrayList<Leg> getLegs() {
		return legs;
	}
	
	public ArrayList<Leg> getLeftLegs() {
		  return this.getLegs().stream().
		               filter( leg -> leg.getSide().equals(BodyPart.BodySide.LEFT)).
		               collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<Leg> getRightLegs() {
		  return this.getLegs().stream().
		               filter( leg -> leg.getSide().equals(BodyPart.BodySide.RIGHT)).
		               collect(Collectors.toCollection(ArrayList::new));
	}
	
	public Leg getAverageLeg() {
       int upperleg = (int) this.getLegs().stream().mapToInt( leg -> leg.getUpperleg() ).summaryStatistics().getAverage();
       int lowerleg = (int) this.getLegs().stream().mapToInt( leg -> leg.getLowerleg() ).summaryStatistics().getAverage();       
		
       Leg leg = new Leg();
       leg.setUpperleg(upperleg);
       leg.setLowerleg(lowerleg);
       
       return leg;		
	}
		
}
