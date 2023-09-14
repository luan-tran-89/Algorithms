package com.interview.kforce.sample.question3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author gasieugru
 */
public class Solution1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/gasieugru/Desktop/Opt/MIU/entry_8_2022/Courses/workspaces/LeetCode/src/main/java/kforce/question3/data.csv"));

        List<String> lines = new ArrayList<>();

        while(scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        List<Customer> customers = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(",");
            int emplcnt = Integer.parseInt(data[5]);
            int contrcnt = Integer.parseInt(data[6]);
            double contrcost = Double.parseDouble(data[7]);
            Customer customer = new Customer(data[0], data[1], data[2], data[3], data[4], emplcnt, contrcnt, contrcost);
            customers.add(customer);
        }

        System.out.println("Total customers: ");
        System.out.println(customers.size());

        System.out.println("Customers by city: ");
        Map<String, Integer> countCustomerByCity = Solution1.countCustomerByCity(customers);
        for (Map.Entry<String, Integer> entry : countCustomerByCity.entrySet()) {
            System.out.println(String.format("%s: %s", entry.getKey(), entry.getValue()));
        }

        System.out.println("Customers by country: ");
        Map<String, Integer> countCustomerByCountry = Solution1.countCustomerByCountry(customers);
        for (Map.Entry<String, Integer> entry : countCustomerByCountry.entrySet()) {
            System.out.println(String.format("%s: %s", entry.getKey(), entry.getValue()));
        }

        System.out.println("Country with the largest number of customers contracts: ");
        Customer largestNumberOfContracts = Solution1.getLargestNumberOfContracts(customers);
        System.out.println(String.format(("%s (%s contracts)"), largestNumberOfContracts.getCountry(), largestNumberOfContracts.getContrcnt()));

        System.out.println("Unique cities with at least one customer: ");
        System.out.println(countCustomerByCity.size());
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

    public static Map<String, Integer> countCustomerByCity(List<Customer> customers) {
        Map<String, Integer> result = new TreeMap<>();

        if (customers != null && customers.size() > 0) {
            for (Customer customer : customers) {
                String city = Solution1.capitalizeLetter(customer.getCity());
                result.put(city, result.getOrDefault(city, 0) + 1);
            }
        }

        return result;
    }

    public static Map<String, Integer> countCustomerByCountry(List<Customer> customers) {
        Map<String, Integer> result = new TreeMap<>();

        if (customers != null && customers.size() > 0) {
            for (Customer customer : customers) {
                String country = customer.getCountry();
                result.put(country, result.getOrDefault(country, 0) + 1);
            }
        }

        return result;
    }

    public static Customer getLargestNumberOfContracts(List<Customer> customers) {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getContrcnt)
                        .thenComparing(Customer::getCountry).reversed()).toList().get(0);
    }

    static class Customer {
        private String id;

        private String name;

        private String city;

        private String country;

        private String cperson;

        private int emplcnt;

        private int contrcnt;

        private double contrcost;

        public Customer(String id, String name, String city, String country, String cperson, int emplcnt, int contrcnt, double contrcost) {
            this.id = id;
            this.name = name;
            this.city = city;
            this.country = country;
            this.cperson = cperson;
            this.emplcnt = emplcnt;
            this.contrcnt = contrcnt;
            this.contrcost = contrcost;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        public String getCperson() {
            return cperson;
        }

        public int getEmplcnt() {
            return emplcnt;
        }

        public int getContrcnt() {
            return contrcnt;
        }

        public double getContrcost() {
            return contrcost;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    ", cperson='" + cperson + '\'' +
                    ", emplcnt=" + emplcnt +
                    ", contrcnt=" + contrcnt +
                    ", contrcost=" + contrcost +
                    '}';
        }
    }
}
