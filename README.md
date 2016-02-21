# Challenge:

Given: A list of 2D (all different) points: (x_1, y_1), ..., (x_K, y_K); numbers use floating point representation.

As known from basic geometry, one can draw a straight line between any two such points. The goal is to find all _lines_ that have more than two points on them from the input set.
You can choose any way to represent a line, but the common one is y = m * x + b.

For example, if the input is (0, 0), (1,1), (3,5), (2,2), the output should be
(m=1, b=0) because this line has three points from the input set: (0, 0), (1,1), (2,2).

# Solution and Approach

There could be many different approach to this problem. 

A line in 2D space can be represented as 
	
	y = mx + c
	where, 
	x,y: represent the co-ordinate in 2D space.
	m: slope of the line 
	c: intercept on the line

	

The simplest solution would be to:
1. Calculate the slope and intercept from each point to every other point.
2. Points matching the same slope and intercept would form the same line.

## Approach

I have used Java to code this work. I construct a collection of points by reading the input. Then I calculate the slope and intercept for each points. While I do that, I also keep a TreeMap with the key being the equation itself and the values being the points satisfying the line equation. At the end of computing lines for each point, I end up with a TreeMap sorted on the equation that has all the lines for that equation. Finally, I print the output and the unique points for each line equations.

### Point

A Java object that encapsulates x,y and has functions to calculate slope for another point. The hashcode and equals override is important for TreeMap and line calculation

### Line

A Java object representing a line between two Points

# Time complexity

Since we iterate over each point to calculate the slope and intercept the order is as follows:

	O(n) = n-1 +  n -2 + n-3 .... 1 = ((n)*(n-1))/2  ~ O(n^2)

This time complexity can easily be reduced to O(n) by applying distributing computing where each worker (k workers) calculates slope and intercept to other points in O(n) time. 
This will reduce the time complexity to:
	
	k * O(n) ~ O(n)
	
# How to run the program

Since this is written in Java, you can simple use maven to run this:

1. Compile the project by running 

		cd challenge
		mvn package

	
2. Run the project in a few modes: 

Provide sample points in the command line:
		
		mvn exec:java  -Dexec.mainClass="org.ajanta.challenge.TwoDimensionalLines"
	
Provide a file with points 

	mvn exec:java  -Dexec.mainClass="org.ajanta.challenge.TwoDimensionalLines"  -Dorg.ajanta.challenge.inputfile="<path-to-file>"
	
Run the test that runs a static list and runs a randonly generated numbers

	mvn test	
		


