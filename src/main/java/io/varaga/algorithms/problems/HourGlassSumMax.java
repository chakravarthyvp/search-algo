package io.varaga.algorithms.problems;

/**
 * Given 6 * 6 matrix, find the max sum of hour glass subset numbers.
 * 
 * 	1 1 1 0 0 0
 *  1 0 1 1 0 0
 *  2 1 1 2 3 4
 *  4 1 5 0 1 0
 *  5 0 8 1 0 0
 *  6 10 7 20 3 4
 *  
 * Hour glass format is as below.
 *   1 1 1
 *     0
 *   2 1 1
 *   and the sum is 7
 *    1 5 0
 *    0 8 1
 *    10 7 20
 *    is another hour glass whose sum is: 52
 *    
 *    and the max is 52
 * @author varagac
 *
 */
public class HourGlassSumMax {

	public static void main(String[] args) {
		int[][] arr = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = i + j;
			}
		}
		System.out.println(hourglassSum(arr));
	}
	
	public static int hourglassSum(int[][] arr) {
        int rowLen = arr.length - 1;
        int colLen = arr[0].length - 1;
        int max = Integer.MIN_VALUE;
        
        for (int row = 0; row <= (rowLen - 2); row++) {
            for (int column = 0; column <= (colLen - 2); column++) {
                int col = column;
                int sum = arr[row][col] + arr[row][col+1] + arr[row][col+2]
                        + arr[row+1][col+1]
                    + arr[row+2][col] + arr[row+2][col+1] + arr[row+2][col+2];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
