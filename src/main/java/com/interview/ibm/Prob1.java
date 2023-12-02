package com.interview.ibm;

import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/384441/vmware-oa-2019-array-partition
 *
 * Given an integer array, the values of the array need to separated into two subsets
 * A and B whose intersection is null and whose unions the entire array.
 * The sum of values in set A must be strictly greater than sum of values in set B,
 * and number of elements in set A must be minimal.
 * Return the values in set A.
 * Complete following function definition for the same.
 *
 * For eg.
 *  Given arr ={3 7 5 6 2}, here A would be {6 7}.
 *
 * Additional Test cases:
 *  When arr={2 3 4 4 5 9 7 8 6 10 4 5 10 10 8 4 6 4 10 1}, A={8 8 9 10 10 10 10}
 *  When arr={5 5 5 10 10 10 11}, A={10 10 10}
 *  When arr={2 2 4 5 5 11}, A={4 11}
 *  When arr={2 3 4 4 5 9 8 10 4 5 10 10 8 4 6 4 10 1}, A={8 8 9 10 10 10 10}
 *  When arr={2 5 5 9}, A={2 9}
 *  When arr={8 7 6 6 6 6 5 5 5}, A={} since there is no A that satisfies the constraints
 *
 * @author gasieugru
 */
public class Prob1 {

    public static void main(String[] args) {
        System.out.println(subsetA(new ArrayList<>((Arrays.asList(3, 7, 5, 6, 2)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(2, 3, 4, 4, 5, 9, 7, 8, 6, 10, 4, 5, 10, 10, 8, 4, 6, 4, 10, 1)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(5, 5, 5, 10, 10, 10, 11)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(2, 2, 4, 5, 5, 11)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(2, 3, 4, 4, 5, 9, 8, 10, 4, 5, 10, 10, 8, 4, 6, 4, 10, 1)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(2, 5, 5, 9)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(8, 7, 6, 6, 6, 6, 5, 5, 5)))));

//        System.out.println(subsetA(new ArrayList<>((Arrays.asList()))));

    }

    private static List<Integer> list = new ArrayList<>();

    public static List<Integer> subsetA(List<Integer> arr) {
        list = new ArrayList<>();

        int sum = 0;

        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
        }
        Collections.sort(arr, Collections.reverseOrder());

        helper(arr, new ArrayList<>(), sum,0,0);

        if (list.size() > arr.size()/2) {
            return new ArrayList<>();
        }

        Collections.sort(list);
        return list;
    }

    public static void helper(List<Integer> arr, List<Integer> finalList, int sum, int tempSum, int count){
        if (tempSum > (sum - tempSum)) {
            if (list.size() == 0 || list.size() > finalList.size()){
                list = new ArrayList<>();
                list.addAll(finalList);
            }
        }

        for (int i = count ; i < arr.size();i++){
            if (i > 0 && arr.get(i) == arr.get(i-1)){
                continue;
            }
            tempSum += arr.get(i);
            finalList.add(arr.get(i));

            while(i < arr.size()-1 && arr.get(i) == arr.get(i+1)){
                tempSum+=arr.get(i+1);
                finalList.add(arr.get(i));
                i++;
            }
            helper(arr, finalList, sum, tempSum, i+1);

            tempSum -= arr.get(i);
            finalList.remove(arr.get(i));

            while(i > 0 && arr.get(i) == arr.get(i-1)){
                tempSum -= arr.get(i-1);
                finalList.remove(arr.get(i-1));
                i--;
            }
        }
    }

    public static List<Integer> subsetA1(List<Integer> arr) {
        int sumB = 0;

        for (int i = 0; i < arr.size(); i++) {
            sumB += arr.get(i);
        }

        Collections.sort(arr, Collections.reverseOrder());

        int sumA = 0;
        List<Integer> subsetA = new ArrayList<>();

        for (int num : arr) {
            if (sumA <= sumB) {
                subsetA.add(num);
                sumA += num;
                sumB -= num;
            } else {
                break;
            }
        }

        Collections.sort(subsetA);

        return subsetA;
    }

    public static int[] getSumArray() {
        int[] sum = new int[1];


        return sum;
    }

}
