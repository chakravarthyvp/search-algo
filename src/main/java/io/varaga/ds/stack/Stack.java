package io.varaga.ds.stack;

import java.util.Arrays;

/**
 * Stack implementation for a FIFO model.
 * @author varagac
 *
 */
public class Stack {

	int top = -1;
	int capacity = 10;
	int[] nums = new int[capacity];
	
	public void ensureCapacity() {
		if ((top + 1) == capacity) {
			nums = Arrays.copyOf(nums, capacity *2);
			capacity *= 2;
		}
	}
	
	public void push(final int num) {
		ensureCapacity();
		nums[++top] = num;
	}
	
	public int pop() {
		if (top == -1) {
			throw new IllegalStateException("Stack is empty");
		}
		int num = nums[top];
		top--;
		return num;
	}
	
}
