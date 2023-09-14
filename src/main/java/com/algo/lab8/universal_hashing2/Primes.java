package com.algo.lab8.universal_hashing2;

public class Primes {
	
    public static int nextPrime( int n ){
       
        if( n % 2 == 0 )
                n++;

        while(!isPrime( n )){
		    n += 2;
        }

        return n;
    }

        public static boolean isPrime( int n ) {
            if( n == 2 || n == 3 )
                return true;

            if( n == 1 || n % 2 == 0 )
                return false;

            for( int i = 3; i * i <= n; i += 2 )
                if( n % i == 0 )
                    return false;

            return true;
        }
        
        public static void main(String[] args){
        	int nxtPrime = 1;
        	int tmp = 0;
        	while(nxtPrime < 3000) {
        		tmp = nextPrime(nxtPrime);
        		System.out.print(tmp+", ");
        		nxtPrime = tmp+1;
        	}
        }
}