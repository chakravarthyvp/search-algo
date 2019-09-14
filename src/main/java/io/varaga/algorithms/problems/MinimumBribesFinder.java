package io.varaga.algorithms.problems;

public class MinimumBribesFinder {

	// Complete the minimumBribes function below.
    public static void minimumBribes(int[] q) {
        int len = q.length - 1;
        int minBribes = 0;
        for (int index = len; index >= 0; index--) {
            if (q[index] != (index + 1)) { // the no is not in appropriate position
                if(q[index-1] == (index+1)) { // check previous position
                    minBribes++;
                    swap(q, index, index-1);
                } else if (q[index-2] == (index+1)) { //check previous two positions
                    minBribes += 2;
                    swap(q, index-1, index-2);
                    swap(q, index, index-1);
                } else { // beyond 2 positions
                    System.out.println("Too Chaotic");
                    return;
                }
            }
        }
        System.out.println(minBribes);
    }

    private static void swap(int[] swpArr, int index1, int index2) {
        int tmp =  swpArr[index1];
        swpArr[index1] = swpArr[index2];
        swpArr[index2] = tmp;
    }

    public static void main(String[] args) {
    	minimumBribes(new int[] {2,5,1,3,4});
    }
}
