package com.algo.lab2.powerSet;

import java.util.*;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> X = new ArrayList<>();
        X.add(1);
        X.add(2);
        X.add(3);
        System.out.println(Solution.powerSet(X));

        Set<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(Arrays.toString(set.toArray(Integer[]::new)));
    }

    private static List<List<Integer>> powerSet1(List<Integer> X) {
        List<List<Integer>> p = new ArrayList<List<Integer>>();
        List<Integer> S = new ArrayList<Integer>();
        p.add(S);

        List<Integer> t = new ArrayList<>();
        while(X.size() > 0) {
            Integer f = X.get(0);
            X.remove(0);
            int pSize = p.size();
            for(int i = 0; i < pSize; i++) {
                List<Integer> p1 = p.get(i);
                List newSet = new ArrayList(p1);
                newSet.add(f);
                p.add(newSet);
            }
        }
        return p;
    }


    public static List<Set<Integer>> powerSet(List<Integer> X) {
        List<Set<Integer>> P = new ArrayList<>();
        Set<Integer> S = new HashSet<>();
        P.add(S);

        Set<Integer> T;
        while(!X.isEmpty()) {
            Integer f = X.get(0);
            X.remove(0);

            int pSize = P.size();
            for(int i = 0; i < pSize; i++) {
                Set<Integer> x = P.get(i);
                T = new HashSet<>(x);
                T.add(f);
                P.add(T);
            }
        }
        return P;
    }
}
