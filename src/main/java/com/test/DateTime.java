package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author gasieugru
 */
public class DateTime {

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(dtf.format(LocalDate.now()));

        dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(dtf.format(LocalTime.now()));

        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));
        System.out.println(dtf.format(ZonedDateTime.now()));

        LocalDateTime date = LocalDateTime.of(2023, 6, 20, 4, 0);
        System.out.println(dtf.format(date));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        String dateInString = "07/06/2013 10:11:59";
        Date date1 = formatter.parse(dateInString);
        System.out.println(date1.toString());

        Map<String, Integer> map = new HashMap<>();
        map.put("z", 10);
        map.put("b", 5);
        map.put("a", 6);
        map.put("c", 20);
        map.put("d", 1);
        map.put("e", 7);
        map.put("y", 8);
        map.put("n", 99);
        map.put("g", 50);
        map.put("m", 2);
        map.put("f", 9);


        System.out.println("Origin:\n" + map);

        Map<String, Integer> map2 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));

        System.out.println("Sort by keys:\n" + map2);

        Map<String, Integer> map3 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));

        System.out.println("Sort by values:\n" + map3);

        List<String> list = List.of("java", "python", "nodejs", "ruby");
        String[] arr = list.stream().toArray(String[]::new);
        System.out.println("arr: " + Arrays.toString(arr));

        //java | python | nodejs | ruby
        String result = list.stream().collect(Collectors.joining(" | "));
        System.out.println(result);

        Map<Character, String> map4 = list.stream()
                .collect(HashMap::new,
                        (m, streamValue) -> m.put((char) ('a' + m.size()), streamValue),
                        (m, m1) -> {});
        System.out.println("map4: " + map4);

        String[] s1 = {"java", "python", "nodejs", "ruby"};
        String[] s2 = {"golang", "reactjs", "mysql", "aws", "java", "python", "nodejs"};

        String[] s3 = Stream.concat(Stream.of(s1), Stream.of(s2)).distinct().toArray(String[]::new);
        System.out.println(Arrays.toString(s3));

        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(x -> System.out.print(x + " "));

    }
}
