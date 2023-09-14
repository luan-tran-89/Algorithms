package com.leetcode.example.concatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 30. Substring with Concatenation of All Words
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 *
 * A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
 *
 * For com.example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
 * Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 *
 * Example 1:
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 * The output order does not matter. Returning [9,0] is fine too.
 *
 * Example 2:
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
 * There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.
 * We return an empty array.
 *
 * Example 3:
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.
 *
 * Constraints:
 * 1 <= s.length <= 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * s and words[i] consist of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] words = new String[]{"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        System.out.println(solution.findSubstring(input, words));
//        List<Integer> result = new ArrayList<>();
//        result = solution.countSubString("aaaaaaaaaaaaaa", "aaaa");
//        System.out.println(result);
    }

    private Map<String, Integer> wordCount = new HashMap<>();
    private int wordLength;
    private int substringSize;
    private int k;

    public List<Integer> findSubstring(String s, String[] words) {
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;
        int n = s.length();

        List<Integer> result = new ArrayList<>();
        if (s.length() < substringSize) {
            return result;
        }

        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < n - substringSize + 1; i++) {
            if (this.check(i, s)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean check(int i, String s) {
        Map<String, Integer> remaining = new HashMap<>(wordCount);
        int wordUsed = 0;

        for (int j = i; j < i + substringSize; j += wordLength) {
            String substring = s.substring(j, j + wordLength);
            if (remaining.getOrDefault(substring, 0) != 0) {
                remaining.put(substring, remaining.get(substring) - 1);
                wordUsed++;
            } else {
                break;
            }
        }

        return wordUsed == k;
    }


    /**
     * This solution occurs timeoutproblem
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring1(String s, String[] words) {
        int length = words.length * words[0].length();
        List<Integer> result = new ArrayList<>();

        if (s.length() < length) {
            return result;
        }

        List<String> subStrings = this.permute(words);

        for (String value : subStrings) {
            int index = s.indexOf(value);
            if (index > -1) {
                List<Integer> indexs = this.countSubString(s, value);
                if (indexs.size() > 0) {
                    result.addAll(indexs);
                }
            }
        }

        return result;
    }

    private List<Integer> countSubString(String s, String value) {
        int length = s.length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int index = s.indexOf(value, i);
            if (index > -1) {
                result.add(index);
                i = index;
            }
        }
        return result;
    }

    private List<String> permute(String[] words) {
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[words.length];
        this.permute(result, words, new ArrayList<>(), visited);
        return result;
    }

    private void permute(List<String> result, String[] words, List<String> list, boolean[] visited) {
        if (words.length == list.size()) {
            String value = list.stream().collect(Collectors.joining());
            if (!result.contains(value)) {
                result.add(value);
            }
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            list.add(words[i]);
            visited[i] = true;
            this.permute(result, words, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
