package com.algo.lab4.sort.sortroutines;


import com.algo.lab4.sort.runtime.Sorter;

public class InsertionSort extends Sorter {

	public static void main(String[] args) {
		InsertionSort s = new InsertionSort();
		int[] arr = {156, 27, 456, 511, 283, 991, 378, 239, 134, 130, 246, 738, 223, 177, 554, 170, 622, 21, 267, 894 };
		long start = System.nanoTime();
		s.sort(arr);
		long end = System.nanoTime();

		System.out.println(end - start);
	}

	@Override
	public int[] sort(int[] anArray) {
		  if(anArray == null || anArray.length <= 1) {
			return anArray;
		  }
		  int len = anArray.length;
		  int temp = 0;
		  int j = 0;
		  for(int i = 1; i < len; ++i) {
		    temp = anArray[i];
		    j=i;
		    while(j>0 && temp < anArray[j-1]){
		       anArray[j] = anArray[j-1];
		       j--;
		    }
		    anArray[j]=temp;
		  }
		  return anArray;
	}

}
