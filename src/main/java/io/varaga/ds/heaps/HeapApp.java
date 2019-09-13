package io.varaga.ds.heaps;

public class HeapApp {

	public static void main(String ...args) {
		MinIntHeap minHeap =  new MinIntHeap();
		minHeap.addItem(1);
		minHeap.addItem(10);
		minHeap.addItem(102);
		minHeap.addItem(190);
		minHeap.addItem(200);
		
		System.out.println(minHeap.peek());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.peek());
		minHeap.addItem(2);
		System.out.println(minHeap.peek());
	}
}
