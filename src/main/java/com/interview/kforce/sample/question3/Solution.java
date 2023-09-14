package com.interview.kforce.sample.question3;

/**
 * @author gasieugru
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(new File("/root/customers/data.csv"));

        Scanner sc = new Scanner(new File("/Users/gasieugru/Desktop/Opt/MIU/entry_8_2022/Courses/workspaces/LeetCode/src/main/java/com/interview/kforce/sample/question3/data.csv"));

        List<String> lines = new ArrayList<>();
        while(sc.hasNextLine()){
            lines.add(sc.nextLine());
        }

        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] cd = lines.get(i).split(",");
            Customer customer = new Customer(Integer.parseInt(cd[0]), cd[1], cd[2], cd[3], cd[4], cd[5],
                    Integer.parseInt(cd[6]), Double.parseDouble(cd[7]));
            customers.add(customer);
        }

        System.out.println("Total customers:");
        System.out.println(customers.size());

        Map<String, Integer> byCity = customers.stream()
                .collect(Collectors.toMap(c -> capitalizeLetter(c.city), c -> 1, (c1, c2) -> c1 + 1, TreeMap::new));

        System.out.println("Customers by city:");
        byCity.entrySet().stream()
                .forEach(e -> System.out.printf("%s: %s\n", e.getKey(), e.getValue()));


        System.out.println("Customers by country:");
        Map<String, Integer> byCountry = customers.stream()
                .collect(Collectors.toMap(c -> c.country, c -> 1, (c1, c2) -> c1 + 1, TreeMap::new));
        byCountry.entrySet().stream()
                .forEach(e -> System.out.printf("%s: %s\n", e.getKey(), e.getValue()));

        System.out.println("Country with the largest number of customers' contracts:");
        Map.Entry<String, Integer> largestNumberOfContracts = customers.stream()
                .collect(Collectors.toMap(c -> c.country, c -> c.contrcnt, (c1, c2) -> c1 + c2))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get();
        System.out.printf("%s (%s contracts)\n", largestNumberOfContracts.getKey(), largestNumberOfContracts.getValue());

        System.out.println("Unique cities with at least one customer:");
        System.out.println(byCity.size());
    }

    public static String capitalizeLetter(String letter) {
        String[] letters = letter.split(" ");
        StringBuilder result = new StringBuilder();

        for (String s : letters) {
            result.append(s.substring(0, 1).toUpperCase())
                    .append(s.substring(1).toLowerCase())
                    .append(" ");
        }

        return result.toString().trim();
    }

    public static void printCountryWithLargestNumberOfContracts(List<Customer> customers){
        Map<String, Integer> map = new HashMap<>();
        for(Customer c : customers){
            map.put(c.country, map.getOrDefault(c.country, 0) + c.contrcnt);
        }
        Map.Entry<String, Integer> maxEntry = map.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();
        System.out.println(maxEntry.getKey() + " ("+maxEntry.getValue()+" contracts)");
    }
    public static Map<String, Integer> getCountByCity(List<Customer> customers){
        Map<String, Integer> map = new TreeMap<>();

        for(Customer c : customers){
            map.put(c.city, map.getOrDefault(c.city, 0) + 1);
        }
        return map;
    }

    public static Map<String, Integer> getCountByCountry(List<Customer> customers){
        Map<String, Integer> map = new TreeMap<>();

        for(Customer c : customers){
            map.put(c.country, map.getOrDefault(c.country, 0) + 1);
        }
        return map;
    }

    static class Customer{
        int id;
        String name;
        String city;
        String country;
        String cperson;
        String emplcnt;
        int contrcnt;
        double contrcost;


        public Customer(int id, String name, String city, String country, String cperson,
                        String emplcnt, int contrcnt, double contrcost) {
            this.id = id;
            this.name = name;
            this.city = city;
            this.country = country;
            this.cperson = cperson;
            this.emplcnt = emplcnt;
            this.contrcnt = contrcnt;
            this.contrcost = contrcost;
        }
    }
}
