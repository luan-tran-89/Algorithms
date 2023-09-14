package com.interview.flexton.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/permutations/description/
 *
 * 46. Permutations
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation solution = new Permutation();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
        System.out.println(solution.permute(new int[]{0, 1}));


        String a = "This sia eclipse random Eclipse ecliPse not a valid ECLIPSE sdfdsf sdfd";
        Map<String, Integer> map = Stream.of(a.split(" "))
                .filter(s -> s.equalsIgnoreCase("eclipse"))
                .map(s -> s.toLowerCase())
                .collect(Collectors.toMap(p -> p, p -> 1, (s1, s2) -> s1+1));
        System.out.println(map);
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        this.permute(result, nums, new ArrayList<>(), visited);
        return result;
    }

    public void permute(List<List<Integer>> result, int[] nums, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            this.permute(result, nums, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
