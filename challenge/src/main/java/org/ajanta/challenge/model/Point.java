/**
 * 
 */
package org.ajanta.challenge.model;

/**
 * @author ajanta
 *
 */
public class Point {

	/* private members */
	private float x;
	private float y;
	private String label=null;
	


	/**
	 * @param x
	 * @param y
	 * @param label
	 */
	public Point(String label, float x, float y) {
		this.x = x;
		this.y = y;
		this.label = label;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}


	
	/**
	 * Compute slope for a line that will cross two points of the form 
	 * y = mx + c, where m is the slope and c is the intercept.
	 * m is calculated as y2-y1/x2-x1
	 * c is calculated by plugging the value of m to one of the points
	 * @param other
	 * @return slope with respect to the other point
	 */
	public float getSlope(Point other){
		float slope=0;
		slope = (other.getY()-this.getY())/(other.getX()-this.getX());		
		return slope;
	}

	/**
	 * 
	 * @param other
	 * @return
	 */
	public float getIntercept(Point other){
		float intercept = 0;
		float m = getSlope(other);
		intercept = this.y - m*this.x;
		return intercept;
	}
	
	


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return label+" [x=" + x + ", y=" + y + "]";
	}

}
