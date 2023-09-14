package com.interview.mroads;

import java.util.*;

/**
 * Write a program to print the com.common and unique numbers between the 3 arrays
 *         int[] a = {1, 2, 3, 4, 5};
 *         int[] b = {2, 4, 5, 7, 9};
 *         int[] c = {2, 5, 10, 14, 15};
 *
 * @author gasieugru
 */
public class UnitNumbers {

    public static void main(String[] args) {
        UnitNumbers solution = new UnitNumbers();

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 4, 5, 7, 9};
        int[] c = {2, 5, 10, 14, 15};

        // Output: 1, 3, 7, 9, 10, 14, 15
        int[] result = solution.getUnitNumbers(a, b , c);
        System.out.println(Arrays.toString(result));

//        List<Integer> sourceList = Arrays.asList(0, 1, 2, 3, 4, 5);
//        Set<Integer> sourceSet = sourceList.stream().collect(Collectors.toSet());
//        // Convert List<Integer> to int[] array
//        int[] arr = sourceList.stream().mapToInt(Integer::intValue).toArray();
//        int[] arr1 = sourceSet.stream().mapToInt(Integer::intValue).toArray();
//        // Convert List<Integer> to Integer[] array
//        Integer[] targetArray = sourceList.toArray(new Integer[0]);
//        Integer[] targetArray1 = sourceSet.toArray(new Integer[0]);
//
//        // Convert int[] array to List<Integer>
//        List<Integer> a1 = Arrays.stream(arr).boxed().collect(Collectors.toList());
//        Set<Integer> a2 = Arrays.stream(arr).boxed().collect(Collectors.toSet());
//        // Convert Integer[] array to List<Integer>
//        Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
//        List<Integer> targetList = Arrays.asList(sourceArray);
//        Set<Integer> targetSet = Arrays.stream(sourceArray).collect(Collectors.toSet());

        // Print array: Arrays.toString(arr);
    }

    public int[] getUnitNumbers(int[] a, int[] b, int[] c) {
        Map<Integer, Integer> map = new HashMap<>();
        this.putDataToMap(map, a);
        this.putDataToMap(map, b);
        this.putDataToMap(map, c);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void putDataToMap(Map<Integer, Integer> map, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = map.get(arr[i]) == null ? 0 : map.get(arr[i]);
            map.put(arr[i], count + 1);
        }
    }

    public int[] getUnitNumbers1(int[] a, int[] b, int[] c) {
        int aLength = a.length;
        int bLength = b.length;
        int cLength = a.length;

        int[] temp = new int[aLength + bLength + cLength];
        int index = 0;

        for (int i = 0; i < aLength; i++) {
            temp[index++] = a[i];
        }

        for (int i = 0; i < aLength; i++) {
            temp[index++] = b[i];
        }

        for (int i = 0; i < cLength; i++) {
            temp[index++] = c[i];
        }

        Arrays.sort(temp);

//        int[] result = new int[temp.length];
        List<Integer> result = new ArrayList<>();
//        int count = 0;

        for (int i = 0; i < temp.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < temp.length; j++) {
                if (i != j && temp[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
//                result[count++] = temp[i];
                result.add(temp[i]);
            }
        }
//        int[] result1 = new int[count];
//        for (int i = 0; i < count; i++) {
//            result1[i] = result[i];
//        }

//        return result1;
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}