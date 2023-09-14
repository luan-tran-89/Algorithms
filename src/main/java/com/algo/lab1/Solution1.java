package com.algo.lab1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author gasieugru
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] s = {0, 1, 2};
        int[] v = {1, 3, 4};
        int[] w = {1, 2, 4};
        int W = 4;
        System.out.println(Arrays.toString(solution.knapShake(s, v, w, W)));
        s = new int[]{0, 1, 2, 3};
        v = new int[]{8, 2, 5, 100};
        w = new int[]{1, 3, 4, 10};
        W = 10;
        System.out.println(Arrays.toString(solution.knapShake(s, v, w, W)));

        s = new int[]{0, 1, 2, 3};
        v = new int[]{100, 8, 2, 5};
        w = new int[]{11, 1, 3, 4};
        W = 10;
        System.out.println(Arrays.toString(solution.knapShake(s, v, w, W)));
    }


    public int[] knapShake(int[] sequece, int[] value, int[] weight, int maxWeight) {
        Set<int[]> subSets = new HashSet<>();
        this.ksHelper(sequece, weight, maxWeight, subSets);
        int max = 0;
        int[] t = null;
        for (int[] i : subSets) {
            int sum = Arrays.stream(i).sum();
            if(sum > max) {
                t = i;
                max = sum;
            }
        }
        return t;
    }

    private int[] ksHelper(int[] sequece, int[] weight, int maxWeight, Set<int[]> subSets) {
        if(sequece.length == 1) {
            if (maxWeight == 0) {
                subSets.add(new int[0]);
                return new int[0];
            } else if (maxWeight == weight[0]) {
                subSets.add(new int[]{sequece[0]});
                return new int[]{sequece[0]};
            } else {
                return null;
            }
        }

        int[] s1 = Arrays.copyOf(sequece,sequece.length - 1);
        int[] w1 = Arrays.copyOf(weight,sequece.length - 1);

        int[] t1 = ksHelper(s1, w1, maxWeight, subSets);
        if (t1 != null) {
            subSets.add(t1);
            return t1;
        }

        int[] t2 = ksHelper(s1,w1, maxWeight - weight[weight.length - 1],subSets);
        if (t2 != null) {
            int[] t3 = new int[t2.length + 1];
            System.arraycopy(t2,0,t3,0,t2.length);
            t3[t3.length - 1] = sequece[sequece.length - 1];
            subSets.add(t3);
            return t3;
        }
        return null;

    }

}
