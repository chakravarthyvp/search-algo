package io.varaga.algorithms.problems;

public class Point {
	final int x1;
	final int y1;
	double distanceFromOrigin;
	
	public Point(final int x, final int y) {
		this.x1 = x;
		this.y1 = y;
		double sqr = Math.pow(Math.abs(x1),2) + Math.pow(Math.abs(y1),2);
		this.distanceFromOrigin = Math.sqrt(sqr);
	}
	
	public double getDistanceFromOrigin() {
		return distanceFromOrigin;
	}
	
	@Override
	public String toString() {
		return "x: " + x1 + " y1: "+ y1 + " distanceFromOrigin: " + distanceFromOrigin;
	}
}
