package com.algo.lab9;

/**
 * @author gasieugru
 */
public class Prime {


    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i < n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}
