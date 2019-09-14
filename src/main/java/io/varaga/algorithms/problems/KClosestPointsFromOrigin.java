package io.varaga.algorithms.problems;

import io.varaga.ds.heaps.MaxedOutHeap;

/**
 * Problem: Given a set of points like (x,y) find 'K' points
 * whose distance is smaller from the origin (0,0). 
 * 
 * @author varagac
 *
 */
public class KClosestPointsFromOrigin {

	public static Point[] kClosestPoints(Point[] points, final int k) {
		//build a minHeap with k capacity
		MaxedOutHeap maxHeap = new MaxedOutHeap(k);
		int kIndex = 0;
		for (Point point: points) {
			if (kIndex < k) {
				maxHeap.addItem(point);
				kIndex++;
			} else if (point.getDistanceFromOrigin() < maxHeap.peek().getDistanceFromOrigin()) {
				maxHeap.replaceMax(point);
			}
		}
		Point[] kPoints = new Point[k];
		for (int index = k-1; index >= 0; index--) {
			kPoints[index] = maxHeap.poll();
		}
		return kPoints;
	}
	
	public static void main(String[] args) {
		Point[] points = new Point[8];
		points[0] = new Point(-2, 4);
		points[1] = new Point(0, -2);
		points[2] = new Point(-1, 0);
		points[3] = new Point(3,5);
		points[4] = new Point(-2, -3);
		points[5] = new Point(3,2);
		points[6] = new Point(1,1);
		points[7] = new Point(-1,-1);
		
		for (Point pt: kClosestPoints(points, 3)) {
			System.out.println(pt);
		}
		
	}
	
}