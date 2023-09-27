package com.interview.interactivebrokers.taxCalc;

/**
 * payers make increasing amounts of money, the tax rate they pay on every
 * In a marginal tax rate system, as tax
 * extra unit of income increases incrementally as their income passes certain cutoffs (referred to as "tax brackets").
 *
 * Write a program that takes inputs:
 * doubles, (cutoff, marginal tax rate),
 * where the marginal tax rate is expressed as marginal tax rate system
 * 1 - A vector of sorted pairs of decimal, describing the tax brackets In a
 * 2 - An income amount as a double that will calculate the amount of tax the tax payer owes.
 *
 * Example:
 * bracket_cutoffs (input1) = {0, 1000.0}
 * bracket_rates (input2) = {0.1, 0.5}
 * income (input3) = 2000.0
 * answer = 600.0
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        double[] bracket_cutoffs = {0, 1000};
        double[] bracket_rates = {0.1, 0.5};
        double income = 2000.0;
        System.out.println(s.tax_calculator(bracket_cutoffs, bracket_rates, income));
    }

    public double tax_calculator(double[] input1, double[] input2, double input3) {
        double tax = 0.0;
        int n = input1.length;

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                tax += (input3 - input1[i]) * input2[i];
            } else {
                double taxableIncome = Math.min(input3, input1[i + 1] - input1[i]) - input1[i];
                tax = taxableIncome * input2[i];

                if (input3 <= input1[i + 1]) {
                    break;
                }
            }
        }

        return tax;
    }

}
