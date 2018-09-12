package io.varaga.algorithms.bit;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
	Note:

    The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    You could assume no leading zero bit in the integer’s binary representation.
    
 *
 */
public class NumberComplement {
	
	public static void main(String ...args) {
		
		int num = 13;
		//Get the highest 1 bit int value
		int high = Integer.highestOneBit(num);
		// and create a mask
		int mask = high - 1;
		int numComplement = ~num & mask;
		int i= 5/2;
		//Create a mask
		System.out.print("num complement: " + numComplement);
	}
	
}
