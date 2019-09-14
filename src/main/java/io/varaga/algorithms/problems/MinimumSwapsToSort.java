package io.varaga.algorithms.problems;

/**
 * You are given an unordered array consisting of consecutive integers  
 * [1, 2, 3, ..., n] without any duplicates. You are allowed to swap 
 * any two elements. You need to find the minimum number of swaps required 
 * to sort the array in ascending order.
 * For example, given the array  we perform the following steps:

    i   arr                         swap (indices)
    0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
    1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
    2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
	3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
	4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
	5   [1, 2, 3, 4, 5, 6, 7]
	It took  swaps to sort the array.

 * @author varagac
 *
 */
public class MinimumSwapsToSort {

	public static void main(String[] args) {
		int[] test = {4,1,3,2};
		System.out.println(findMinSwaps(test));
		
		test = new int[] {7,6,5,4,3,2,1};
		System.out.println(findMinSwaps(test));
		
		test = new int[] {1,2,3,4};
		System.out.println(findMinSwaps(test));
	}
	
	public static int findMinSwaps(int[] swapArray) {
		int len = swapArray.length - 1;
		int minSwaps = 0;
		
		for (int index = 0; index < len -1; index++) {
			if(index < (swapArray[index] - 1)) {
				//swap
				swap(swapArray, index, swapArray[index] - 1);
				minSwaps++;
				index--; //lets check the position after the swap
			}
		}
		return minSwaps;
	}
	
	public static void swap(int[] swap, int index1, int index2) {
		int tmp = swap[index1];
		swap[index1] = swap[index2];
		swap[index2] = tmp;
	}
}
