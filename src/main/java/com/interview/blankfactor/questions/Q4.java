package com.interview.blankfactor.questions;

/**
 * https://www.mycompiler.io/new/java?fork=82Dhnv3TyF2
 * Output
 * 0
 * 2
 * 3
 * 4
 * 6
 * @author gasieugru
 */
public class Q4 {
    public static void main(String[] args) {
        int i = 0;
        for (; i < 10; i++) {
            System.out.printf("i = %s, i%%4 = %s, i%%6 = %s \n", i, i%4, i%6);
            if(i%4 == 1) {
                continue;
            }
            System.out.println(i);
            if(i%6 == 0 && i > 0){
                break;
            }
        }
    }
}
