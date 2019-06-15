/**
 * 
 */
package artificial_life;

import java.util.Random;

/**
 * @author John
 *
 */
public class Leg extends BodyPart {
	private int upperleg;
	private int lowerleg;
	private BodyPart.BodySide side;
	private int bodyx;
	private int bodyy;
	
	private Random rand = new Random();
	
	public Leg() {
		this.upperleg = rand.nextInt(80) + 20;
		this.lowerleg = rand.nextInt(80) + 20;
		this.side = ( rand.nextInt(10) % 2 == 0 ) ? BodyPart.BodySide.LEFT : BodyPart.BodySide.RIGHT;
		this.bodyx = rand.nextInt(400);	
		this.bodyy = rand.nextInt(400);
	}

	/**
	 * @return the upperleg
	 */
	public int getUpperleg() {
		return upperleg;
	}

	/**
	 * @param upperleg the upperleg to set
	 */
	public void setUpperleg(int upperleg) {
		this.upperleg = upperleg;
	}

	/**
	 * @return the lowerleg
	 */
	public int getLowerleg() {
		return lowerleg;
	}

	/**
	 * @param lowerleg the lowerleg to set
	 */
	public void setLowerleg(int lowerleg) {
		this.lowerleg = lowerleg;
	}

	/**
	 * @return the side
	 */
	public BodyPart.BodySide getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(BodyPart.BodySide side) {
		this.side = side;
	}

	/**
	 * @return the bodyx
	 */
	public int getBodyx() {
		return bodyx;
	}

	/**
	 * @param bodyx the bodyx to set
	 */
	public void setBodyx(int bodyx) {
		this.bodyx = bodyx;
	}
	
	/**
	 * @return the bodyy
	 */
	public int getBodyy() {
		return bodyy;
	}

	/**
	 * @param bodyy the bodyy to set
	 */
	public void setBodyy(int bodyy) {
		this.bodyy = bodyy;
	}	

}
