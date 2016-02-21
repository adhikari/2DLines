package org.ajanta.challenge.test;

import static org.junit.Assert.*;

import java.util.Collection;

import org.ajanta.challenge.TwoDimensionalLines;
import org.ajanta.challenge.model.Point;
import org.junit.Before;
import org.junit.Test;

public class Test2DLines {
	private String _input=null;

	@Before
	public void setUp() throws Exception {
		_input =new String("(0, 0), (1,1), (3,5), (2,2),(-1,-1)");
		/* Generate Points randomly */
		
	}

	private void generateRandom(){
		for(int i=0;i<10;i++){
			_input+="("+Math.random()+","+Math.random()+"),";
		}
	}
	
	@Test
	public void test() {
		System.out.println(" TESTING FROM STATIC LIST");
		testStaticInput();
		
		System.out.println(" TESTING FROM RANDOM GENERATED LIST\n");
		testRandom();
		
	}
	
	/**
	 * Test static list
	 */
	private void testStaticInput(){
		TwoDimensionalLines lines = new TwoDimensionalLines();
		System.out.println(_input);

		Collection<Point> allPoints = lines.readInput(_input);
		try {
			lines.findLines(allPoints);
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Test with generated random numbers
	 */
	private void testRandom(){
		TwoDimensionalLines lines = new TwoDimensionalLines();
		generateRandom();
		System.out.println(_input);

		Collection<Point> allPoints = lines.readInput(_input);		
		try {
			lines.findLines(allPoints);
		} catch (Exception e) {
			fail();
		}
		
	}
	
}
