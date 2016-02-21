/**
 * 
 */
package org.ajanta.challenge;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ajanta.challenge.model.Point;
import org.apache.commons.io.IOUtils;

/**
 * @author ajanta
 *
 */
public class TwoDimensionalLines {

	private static TreeMap<String, Collection<Line>> _sortedLineMap = new TreeMap<String, Collection<Line>>();
	private static Console _console = System.console();

	
	/**
	 * 
	 */
	public TwoDimensionalLines() {
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwoDimensionalLines lines = new TwoDimensionalLines();

		/* Read Input */
		Collection<Point> allPoints = lines.readInput(null);
		
		long start = System.currentTimeMillis();
		System.out.println("Computing lines from given points ");
		try {
			lines.findLines(allPoints);
		} catch (Exception e) {
			System.out.println("Failed to compute lines from points");
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();

		System.out.println(" E N D   O F   P R O G R A M   ( R U N T I M E = "+(end-start)+" milliseconds )");
	}
	
	private static String readFromStdIn(){
		String input=null;

		if (_console == null) {
            System.err.println("No console. Please run from command line or provide a file input by passing a JVM argument to the file location -Dorg.ajanta.challenge.inputfile");
            
            System.exit(1);
        }
		input = _console.readLine("Please type the input points of the format: (0,1), (2,2), (3,3): ");
		_console.flush();
		return input;
	}
	
	
	/**
	 * Read input and compute all lines
	 * @throws Exception 
	 */
	public  void findLines(Collection<Point> allPoints) throws Exception{
		/* For all points, compute lines */
		for(Point p : allPoints){
			computeLines(allPoints, p);
		}		
		/* Finally print these lines */
		printLines();
	}
	
	/**
	 * Print lines
	 * @throws Exception 
	 */
	private  void printLines() throws Exception{
		if(_sortedLineMap==null){
			throw new Exception(" Failed to compute lines from points");
		}
		/* Iterate thru the sorted Line equation map */
		for(String s : _sortedLineMap.keySet()){
			System.out.print("\n\n Line => "+ s);
			Set<Point> uniquePoints = new LinkedHashSet<Point>();
			
			Collection<Line> miniLines = _sortedLineMap.get(s);
			System.out.print("\n\t Mini Lines: "+miniLines.size()+",  in this line equation from given points ( we show line from A -> B and B -> A for completion) :");
			for(Line l: miniLines){
				System.out.print("\n\t\t Equation: "+l +", " +l.printPoints());
				uniquePoints.add(l.getA());
				uniquePoints.add(l.getB());				
			}
			
			System.out.print("\n Unique points  = "+uniquePoints.size()+",  for this line equation "+s+" : "+uniquePoints);
			System.out.println("\n--------------------------------------------\n");

		}
	}
	
	public  Collection<Point> readInput(String inputPoints){
		Collection<Point> allPoints = new LinkedList<Point>();

		/* If points were not passed then read it */
		if(inputPoints==null){
			/* Read Input from from JVM Args  */
			String inputFile = System.getProperty("org.ajanta.challenge.inputfile");
			if(inputFile!=null){
				try {
					FileInputStream input = new FileInputStream(new File(inputFile));
					inputPoints = IOUtils.toString(input);
				}
				catch (IOException e) {
				}
			}else{
				/* Read from STDIN or from a file */
				inputPoints=readFromStdIn();
			}
		
		}
		int i=0;
		if(inputPoints!=null){
	
			/* Pattern of the input */
			String pattern = "[-+]?(\\d*[.])?\\d+";
			
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(inputPoints);
	
			float x=0, y=0;
			/* Collect points from the input */
			while (m.find()) {
				String s = m.group();
				if(i%2==0){
					x = Float.parseFloat(s);
				}else{
					y=Float.parseFloat(s);
					Point p = new Point("("+x+","+y+")", x, y);
					allPoints.add(p);
				}
				i++;
			}
			System.out.println(" Input points ==>" + allPoints);

		}
		/* Validation is simple, if no points were found to match the pattern, then throw an error */
		if(i==0){
			/* Bad Input */
			System.out.println(" Bad Input, please try again with format: (0,1), (2,3) ... ");
			System.exit(-1);
		}
		return allPoints;
	}
	
	/**
	 * 
	 * @param allPoints
	 * @param myPoint
	 */
	private  void computeLines(Collection<Point> allPoints, Point myPoint){
		for(Point p : allPoints){
			if(!p.equals(myPoint)){
				Line s = new Line(myPoint.getSlope(p), myPoint, p,myPoint.getIntercept(p));
				
				Collection<Line> miniLines = _sortedLineMap.get(s.getEquation());
				if(miniLines==null){
					miniLines= new LinkedList<Line>();
				}
				miniLines.add(s);
				_sortedLineMap.put(s.getEquation(),miniLines );
			}
		}
	}

}
