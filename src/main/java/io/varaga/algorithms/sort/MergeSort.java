package io.varaga.algorithms.sort;

public class MergeSort {

	// {2,5,4}
    public void mergeSort(int[] a) {
		// check edge cases, null, length == 1 etc.,
		int aL = a.length;
		if(aL < 2){
			return;
		}
		int mid = aL/2; //1
		int[] leftA = new int[mid]; //1
		int[] rightA = new int[aL - mid]; //2
		for(int index = 0; index <= mid - 1; index++) {
			leftA[index] = a[index];
		}
		for(int index = mid; index <= aL - 1; index++) {
			rightA[index-mid] = a[index];
		}
		mergeSort(leftA);
		mergeSort(rightA);
		//Sort
		sort(leftA, rightA, a);
	}
	
	public void sort(int[] left, int[] right, int[] a) {
		int lL = left.length; //1
		int rL = right.length;//1
		int i = 0, j = 0, k = 0;
		while (i < lL && j < rL) {
			if(left[i] <= right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			k++;
		}
		while(i < lL){
			a[k] = left[i];
			i++;
			k++;
		}
		while(j < rL) {
			a[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void main(String ...args) {
		int[] a = new int[] {2,6,3,10,9,8,7,6,5,4,3,2};
		new MergeSort().mergeSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
} 
