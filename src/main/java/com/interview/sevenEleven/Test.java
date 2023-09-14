package com.interview.sevenEleven;

/**
 * @author gasieugru
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();

        System.out.println(t.foo(2));
    }

    int foo(int n ) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j * j > 0; j--) {
                count = count + 1;
            }
        }
        return count;
    }

}
