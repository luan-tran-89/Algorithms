package com.interview.chase;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author gasieugru
 */
public class MergeArrays {

    public static void main(String[] args) {
        MergeArrays solution = new MergeArrays();
        int[] a = {4,6,2};
        int[] b = {3,5,7,2,4};

        int[] merge = solution.mergeArrays(a, b);
        System.out.println(Arrays.toString(merge));

        List<String> list = List.of("a", "b");
//        String[] array = list.stream().map(s -> s).toArray();
//        String[] array = list.toArray(new String[list.size()]);
        String[] array = list.toArray(String[]::new);
        System.out.println(Arrays.toString(array));

        List<Integer> mergeArrays = IntStream.concat(IntStream.of(a), IntStream.of(b))
                .boxed().distinct().collect(Collectors.toList());
        System.out.println(mergeArrays);
    }

    public int[] mergeArrays1(int[] a, int[] b) {
        Stream<Integer> s1 = IntStream.of(a).boxed();
        Stream<Integer> s2 = IntStream.of(b).boxed();
        return Stream.concat(s1, s2).distinct().sorted().mapToInt(i -> i).toArray();
    }

    public int[] mergeArrays(int[] a, int[] b) {
        IntStream s1 = IntStream.of(a);
        IntStream s2 = IntStream.of(b);
        return IntStream.concat(s1, s2).distinct().toArray();
    }

}
