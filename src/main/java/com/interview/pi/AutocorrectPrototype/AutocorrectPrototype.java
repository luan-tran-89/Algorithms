package com.interview.pi.AutocorrectPrototype;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Complete the implementation of an autocorrect function.
 * Given a search query string, the function should return al words which are anagrams
 *
 * Given 2arrays, words[n], and queries[q], for each query,
 * return an array of the strings that are anagrams,sorted alphabetically ascending.
 *
 * Note: An anagram is any string that can be formed by rearranging the letters of a string.
 *
 * Example: n = 4, q = 2
 * words = ["duel", "speed", "dule", "cars"], queries = ["spede", "deul"].
 *
 * The only anagram of "spede" is "speed".
 * Both "duel" and "dule" aer anagrams of "deul".
 *
 * Return [["speed"], ["duel", "dule"]].
 *
 * @author gasieugru
 */
public class AutocorrectPrototype {

    public static void main(String[] args) {
        AutocorrectPrototype solution = new AutocorrectPrototype();
        List<String> words = List.of("duel", "speed", "dule", "cars");
        List<String> queries = List.of("spede", "deul");

        System.out.println(solution.getSearchResults(words, queries));
    }


    public static List<List<String>> getSearchResults(List<String> words, List<String> queries) {
        List<List<String>> results = new ArrayList<>();

        for (String query : queries) {
            List<String> anagrams = new ArrayList<>();
            for(String word : words) {
                boolean isAnagrams = isAnagrams(word, query);
                if (isAnagrams) {
                    anagrams.add(word);
                }
            }
            results.add(anagrams);
        }
        return results;
    }

    private static boolean isAnagrams(String word, String query) {
        if (word.length() != query.length()) {
            return false;
        }

        List<Character> wordChars = word.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());
        List<Character> queryChars = query.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());

        for (int i = 0; i < wordChars.size(); i++) {
            if (wordChars.get(i) != queryChars.get(i))  {
                return false;
            }
        }

        return true;
    }
}
