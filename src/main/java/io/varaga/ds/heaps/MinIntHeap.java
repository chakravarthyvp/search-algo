package io.varaga.ds.heaps;

import java.util.Arrays;

public class MinIntHeap {

	int capacity = 10; // capacity of the heap
	int size = 0; // current size of the heap
	int[] items = new int[capacity];//all items
	
	public void swap(final int indexOne, final int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	public void ensureCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	/**
	 * Gets the minimum in this heap.
	 * 
	 * @return - the minimum in this heap
	 */
	public int peek() {
		return items[0];
	}
	
	/**
	 * Removes the minimum from the heap and rearranges the heap.
	 * 
	 * @return - the minimum in this heap.
	 */
	public int poll() {
		//remove the top of the heap
		int min = items[0];
		//swap the last element with the first element
		items[0] = items[size-1];
		size--;
		//rearrange the heap by heapifying down.
		heapifyDown();
		return min;
	}
	
	private void heapifyDown() {
		int parentIndex = 0;
		//find the smallest child of the root's children and keep swapping with it.
		while ((2 * parentIndex + 1) < size) { // has left child
			int smallestIndex = 2 * parentIndex + 1;//leftChild Index
			if(((2 * parentIndex + 2) < size) && items[(2 * parentIndex + 2)] < items[smallestIndex]) { // there's a right child and it is smaller than the left child
				smallestIndex = (2 * parentIndex + 2);//right child index
			}
			
			if (items[smallestIndex] < items[parentIndex]) {
				//swap
				swap(parentIndex, smallestIndex);
				parentIndex = smallestIndex;
			} else {
				break; // we only check the parent with the child.
			}
		}
		
	}
	
	/**
	 * Adds an item into the heap.
	 * 
	 */
	public void addItem(final int numberItem) {
		//ensure we have enough space to add the item.
		ensureCapacity();
		//add the item to the last of the array
		items[size] = numberItem;
		size++;
		heapifyUp(); //ensure we keep up the heap property
	}
	
	public void heapifyUp() {
		int childIndex = size - 1;
		while (items[(childIndex - 1)/2] > items[childIndex]) { //if the parent is greater than the child
			swap((childIndex - 1)/2, childIndex);
			childIndex = (childIndex - 1)/2;
		}
	}
	
}
