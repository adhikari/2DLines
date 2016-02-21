/**
 * 
 */
package org.ajanta.challenge;


import org.ajanta.challenge.model.Point;

/**
 * @author ajanta
 *
 */
public class Line{
	
	/* private members */
	private float slope=0;
	private Point a;
	private Point b;
	private float intercept=0;

	/**
	 * 
	 */
	public Line() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param slope
	 * @param a
	 * @param b
	 * @param intercept
	 */
	public Line(float slope, Point a, Point b, float intercept) {
		this.slope = slope;
		this.a = a;
		this.b = b;
		this.intercept = intercept;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	/**
	 * @return the slope
	 */
	public float getSlope() {
		return slope;
	}

	/**
	 * @param slope the slope to set
	 */
	public void setSlope(float slope) {
		this.slope = slope;
	}

	/**
	 * @return the a
	 */
	public Point getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(Point a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public Point getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(Point b) {
		this.b = b;
	}



	/**
	 * @return the intercept
	 */
	public float getIntercept() {
		return intercept;
	}

	/**
	 * @param intercept the intercept to set
	 */
	public void setIntercept(float intercept) {
		this.intercept = intercept;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Line o) {
		int compare =(int)Math.random();
		if(o!=null){
			/* if the slope and intercept are same then it is the same continuation of the line */
			if(this.slope==o.slope && this.intercept==o.intercept){
				System.out.println(" Compare equal ==>" +this +" Other "+o);
				compare =0;
			}else{
				if(this.slope==o.slope){
					compare = Float.floatToIntBits(this.intercept-o.intercept);
				}
				
			}
		}
		
		return compare;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " y = "+slope+"x +"+intercept;
	}
	
	public String getEquation(){
		return toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(intercept);
		result = prime * result + Float.floatToIntBits(slope);
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
		Line other = (Line) obj;
		if (Float.floatToIntBits(intercept) != Float.floatToIntBits(other.intercept))
			return false;
		if (Float.floatToIntBits(slope) != Float.floatToIntBits(other.slope))
			return false;
		return true;
	}

	public String printPoints(){
		return " Points: "+a.getLabel()+" AND "+b.getLabel();
	}
}
