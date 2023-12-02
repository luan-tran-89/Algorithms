package com.interview.ibm.Nov18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement a simple prototype service to find the difference between two JSON JavaScript Object Notation) objects.
 * To keep the prototype simple, aJSON wil contain only key-value pairs and no nested objects or arrays in it.
 * Given two JSON strings, json1 and json2, find the list of keys for which the values are different.
 * If a key is present in only one of the JSONs, it should not be considered in the result.
 * The list of keys should be sorted in lexicographically ascending order.
 *
 * Example:
 *  Suppose json1 = "["hello":"world", "hi": "hello", "you": "me")" and
 *          json2 =" ("hello":"world", "hi":"helloo", "you":"me")"
 *  The only common key where the values differ is "hi".
 *  Hence the answer is ["hi"].
 *
 * Function Description
 *  Complete the function get/SONDiff in the editor below.
 *
 * getJSONDiff has the following parameter(s):
 *      json1: the first JSON string
 *      json2: the second JSON string
 * Returns
 *      string[]: a sorted list of keys that have different associated values in the two ISONs
 *
 * Constraints
 *      • 1≤ljson1|. Ijson2| ≤105
 *      • There are no white spaces in the string.
 *
 * Sample Case 0:
 *      Sample Input:
 *          json1 = "{"hacker":"rank", "input":"output"}"
 *          json2 = "{"hacker": "ranked", "input":"wrong"}"
 *
 *      Sample Output:
 *          hacker
 *          input
 *
 * Sample Case 2:
 *      Sample Input:
 *          json1 = "{"hacker":"rank", "input":"output"}"
 *          json2 = "{"hacker": "rank", "input":"output"}"
 *
 *      Sample Output:
 *
 * @author gasieugru
 */
public class Prob {

    public static void main(String[] args) {
        String json1 = "(\"hacker\":\"rank\", \"input\":\"output\")";
        String json2 = "(\"hacker\":\"ranked\", \"input\":\"wrong\")";
        System.out.println(getJSONDiff(json1, json2));

        String json = "(\"hacker\":\"rank\", \"input\":\"output\")";
        System.out.println(getJSONDiff(json, json));
    }

    public static List<String> getJSONDiff(String json1, String json2) {
        List<String> diff = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        String[] item1 = json1.substring(1, json1.length() - 1).replace("\"", "").split(",");
        String[] item2 = json2.substring(1, json2.length() - 1).replace("\"", "").split(",");;

        for (String item : item1) {
            String[] pair = item.split(":");
            String key = pair[0].trim();
            String value = pair[1].trim();

            map.put(key, value);
        }

        for (String item : item2) {
            String[] pair = item.split(":");
            String key = pair[0].trim();
            String value = pair[1].trim();

            if (!map.containsKey(key)) {
                continue;
            }

            if (!map.get(key).equals(value)) {
                diff.add(key);
            }
        }

        return diff;
    }

}
