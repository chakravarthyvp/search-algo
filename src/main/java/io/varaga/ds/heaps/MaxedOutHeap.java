package io.varaga.ds.heaps;

import io.varaga.algorithms.problems.Point;

public class MaxedOutHeap {

	int capacity;
	int size = 0;
	Point[] items;
	boolean hasMaxedOut;
	
	public MaxedOutHeap(final int maxCapacity) {
		this.capacity = maxCapacity;
		this.items = new Point[capacity];
	}
	
	public void addItem(Point point) {
		if(hasMaxedOut) {
			//replace
			replaceMax(point);
		} else {
			items[size] = point;
			size++;
			if (size == capacity) {
				hasMaxedOut = true;
			}
			heapifyUp();
		}
	}
	
	public void swap(final int index1, final int index2) {
		Point tmp = items[index1];
		items[index1] = items[index2];
		items[index2] = tmp;
	}
	
	public void heapifyUp() {
		int largerIndex = size - 1;
		while (items[(largerIndex-1)/2].getDistanceFromOrigin() < items[largerIndex].getDistanceFromOrigin()) {
			//swap
			swap((largerIndex-1)/2, largerIndex);
			largerIndex = (largerIndex-1)/2; 
		}
	}
	
	public void replaceMax(final Point num) {
		items[0] = num;
		heapifyDown();
	}
	
	public void heapifyDown() {
		int parentIndex = 0;
		while ((2*parentIndex + 1) < size) {
			int maxIndex = (2*parentIndex + 1);
			if ((2*maxIndex + 2) < size && items[(2*maxIndex + 2)].getDistanceFromOrigin() > items[(2*maxIndex + 1)].getDistanceFromOrigin() ) {
				maxIndex = 2*maxIndex + 2;
			}
			
			if (items[parentIndex].getDistanceFromOrigin() < items[maxIndex].getDistanceFromOrigin()) {
				swap(maxIndex, parentIndex);
				parentIndex = maxIndex;
			} else {
				break;
			}
			
		}
	}
	
	/**
	 * Removes the maximum from the heap and rearranges the heap.
	 * 
	 * @return - the maximum in this heap.
	 */
	public Point poll() {
		//remove the top of the heap
		Point max = items[0];
		//swap the last element with the first element
		items[0] = items[size-1];
		size--;
		//rearrange the heap by heapifying down.
		heapifyDown();
		return max;
	}

	public Point peek() {
		return items[0];
	}
	
}
