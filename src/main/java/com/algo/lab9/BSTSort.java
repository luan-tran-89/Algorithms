package com.algo.lab9;

import com.algo.lab4.sort.runtime.Sorter;
import com.leetcode.traverseTree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gasieugru
 */
public class BSTSort extends Sorter {

    @Override
    public int[] sort(int[] arr) {
        MyBST bst = new MyBST();

        for (int item : arr) {
            bst.insert(item);
        }
        List<Integer> list = bst.inOrderTraversal();
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;

        System.out.printf("Input: %s\n", Arrays.toString(arr));
        BSTSort bstSort = new BSTSort();
        System.out.printf("Output: %s\n", Arrays.toString(bstSort.sort(arr)));
    }

}
