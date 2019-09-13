package io.varaga.ds.stack;

import java.util.stream.IntStream;

public class StackApp {

	public static void main(String[] args) {
		Stack stack = new Stack();
		IntStream.range(0, 100).forEach(num -> {
			stack.push(num);
		});
		
		IntStream.range(0, 10).forEach( num -> {
			System.out.println(stack.pop());
		});
	}
	
}
