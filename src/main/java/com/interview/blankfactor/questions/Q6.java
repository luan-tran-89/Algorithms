package com.interview.blankfactor.questions;

import java.util.Arrays;
import java.util.Base64;

/**
 * https://www.mycompiler.io/new/java?fork=5URb5DaTPan
 *
 * @author gasieugru
 */
public class Q6 {
    public static void main(String[] args) {
        System.out.println(String.format("Mising number is: %1$s", GetMissingNumber(getNumbers())));
    }

    /*
	  You have a non-repeating numbers array with 99 unique not ordered numbers.
	  Implement the method GetMissingNumber, that should find which number
	  is missing in the range of 1 to 100.
	*/
    public static int GetMissingNumber(int[] numbers) {
        int result = -1; //Assign to result variable missing number
        int[] arr = new int[101];

        for (int i = 0; i < numbers.length; i++) {
            arr[numbers[i]] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                result = i;
            }
        }

        return result;
    }



    //=======================================================================
    public static final String _encryptedNumbersArray = "NTcsMTEsMzMsOTQsMTQsNjcsMzAsNjUsMTksMTgsNDYsNzksMjEsOSw4NSw1Miw0Miw5NiwyNywyNSw2MCwzNSw0OCw3MCw4LDkwLDk4LDMxLDc3LDUzLDM2LDE2LDk3LDc1LDIyLDI5LDE3LDkzLDU1LDQsODAsNTgsNzYsNjIsODMsNTksMiw0Nyw4Niw4Miw3LDM5LDQzLDY5LDcyLDkxLDI4LDczLDg5LDY2LDY4LDc0LDI2LDMsMjQsODQsMjAsMTAsNDEsMzcsNTQsMTIsMTAwLDEzLDQ1LDUsNzEsNDksMTUsMjMsOTUsNjEsOTIsNjQsNTYsNzgsMSw4Nyw0NCw2LDM4LDUwLDMyLDUxLDQwLDgxLDYzLDk5LDM0";
    public static int[] getNumbers() {
        String decrypted = DecryptString(_encryptedNumbersArray);
        return Arrays.stream(decrypted.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static String DecryptString(String encrString) {
        String decrypted = "";

        try {
            byte[] encrBytes = encrString.getBytes();
            byte[] decodedString = Base64.getDecoder().decode(new String(encrBytes).getBytes("UTF-8"));

            decrypted = new String(decodedString);
        } catch (java.lang.Exception e) {
            decrypted = "";
        }
        return decrypted;
    }
}
