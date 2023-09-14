package com.interview.photon.countCharacters;

/**
 * @author gasieugru
 */
public class Solution {

    private static final String SPECIAL_CHAR = "\0";

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countCharacters("Ba Luan Tran aaaauubb"));

        System.out.println(solution.countCharacters1("Ba Luan Tran aaaauubb"));
    }

    public int countCharacters(String s) {
        int result = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (sb.indexOf(c) != -1) {
                continue;
            }
            sb.append(c);
            int count = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (c.equals(String.valueOf(s.charAt(j)))) {
                    count++;
                }

                if (count > 2) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }

    public int countCharacters1(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (!c.equals(SPECIAL_CHAR)) {
                int count = 1;
                for (int j = i+1; j < s.length(); j++) {
                    if (c.equals(String.valueOf(s.charAt(j)))) {
                        count++;
                    }

                    if (count > 2) {
                        result++;
                        s = s.replaceAll(c, SPECIAL_CHAR);
                        break;
                    }
                }
            }
        }

        return result;
    }

}
