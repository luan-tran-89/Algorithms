package com.algo.lab4.sort.sortroutines;

import com.algo.lab4.sort.runtime.Sorter;
import com.algo.lab9.MyBST;

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
        int[] res = list.stream().mapToInt(i -> i).toArray();
        return res;
    }

}
