package com.interview.blankfactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
   There is a string "sdfgabcwetrrytruyrtuabcpotre!@#abcprtort".
   The task is to implement the following method:

   private HashMap<string, string> processString(string inputStr, string separator);

   The result needs to contain the following keys:
   Count : count all substrings (itemstrings)  in front of which there is a separator string
   (if xxx is the string and A is the separator here: xxxAxxxAxxxAxxx, you need to return 3);
   prefix : if any string exists before the first separator, please provide the text
   sortedItems : a string with all itemstrings concatenated in alphabetical order
   evenChars : a string with concatenated all even indexed chars (2,4,6,8,10th)

   notes:
       1. if there is no separator found in input string then the whole inputString is counted as 1 itemString
       2. zero length strings should not be included in count
       3. prefix should not be included in itemstrings
       4. prefix should not be included in count
       5. itemstrings should be displayed with space (" ") between each of them in the output

   Implement all results display inside Main method in following format:

   Count: some number
   Prefix: some string
   sortedItems: some string
   evenChars: some string


   Example output when executed with inputString = "abcdefSEPgabcwetSEPsdsSEPdsfgSEPfro", separator = "SEP"

   Count: 4
   Prefix: abcdef
   sortedItems: dsfg fro gabcwet sds
   evenChars: aceSPaceSPdSPsgEfo
*/
public class Solution {
    static List<String> keys = List.of("Count", "Prefix", "sortedItems", "evenChars");

    public static void main(String[] args) {
        String inputString = "sdfgabcwetrrytruyrtuabcpotre!@#abcprtort";
        ArrayList<HashMap<String, String>> resultList = new ArrayList<>();

        resultList.add(processString(inputString,"abc"));
        resultList.add(processString(inputString,"s"));
        resultList.add(processString(inputString,"r"));
        resultList.add(processString(inputString,"zi"));

        inputString = "abcdefSEPgabcwetSEPsdsSEPdsfgSEPfro";
        resultList.add(processString(inputString,"SEP"));

        inputString = "";
        resultList.add(processString(inputString,"SEP"));

        printResult(resultList);
    }

    private static HashMap<String, String> processString(String inputStr, String separator)
    {
        HashMap<String, String> result = new HashMap<>();

        //Add the implementation here
        List<String> items = Arrays.stream(inputStr.split(separator))
                .filter(s -> !"".equals(s)).collect(Collectors.toList());

        String evenChars = IntStream.range(0, inputStr.length())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> String.valueOf(inputStr.charAt(i)))
                .collect(Collectors.joining());

        int count;
        String prefix = "";
        List<String> itemStrings;

        if (items.size() < 2) {
            count = items.size();
            itemStrings = items;
        } else {
            count = items.size() - 1;
            prefix = items.get(0);
            itemStrings = items.subList(1, items.size());
        }
        result.put(keys.get(0), String.valueOf(count));
        result.put(keys.get(1), prefix);
        result.put(keys.get(2), itemStrings.stream().sorted().collect(Collectors.joining(" ")));
        result.put(keys.get(3), evenChars);

        return result;
    }

    private static void printResult(ArrayList<HashMap<String, String>> resultList) {
        /*
    		Below is an com.example output when executed with inputString = "abcdefSEPgabcwetSEPsdsSEPdsfgSEPfro", separator = "SEP"

    		Count: 4
    		Prefix: abcdef
    		sortedItems: dsfg fro gabcwet sds
    		evenChars: aceSPaceSPdSPsgEfo
		*/

        //Add the implementation here
        if (resultList != null && resultList.size() > 0) {
            resultList.forEach((map) -> {
                for (String key : keys) {
                    String value = map.get(key);
                    System.out.printf("%s: %s\n", key, value);
                }
                System.out.println();
            });
        }
    }

}
