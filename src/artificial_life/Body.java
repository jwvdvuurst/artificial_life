/**
 * 
 */
package artificial_life;

/**
 * @author John
 *
 */
public class Body extends BodyPart {
	private int length;
	private int width;
	private int height;

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		if (length <= 0) {
			length = 1;
		}

		this.length = length;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		if (width <= 0) {
			width = 1;
		}

		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		if (height <= 0) {
			height = 1;
		}

		this.height = height;
	}
}
