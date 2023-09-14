package com.interview.blankfactor.questions;

import java.time.LocalDate;

/**
 * https://www.mycompiler.io/new/java?fork=CJ7wGY81Mrr
 *
 * Output:
 * Not forbidden
 * Either delayed or not
 *
 * @author gasieugru
 */
public class Q5 {
    public static void main(String[] args) {
        boolean isForbidden = false;
        boolean isActive = true;
        boolean isDelayed = true;

        LocalDate threshold = LocalDate.now().plusDays(40);
        //
        if(!isForbidden && isActive && LocalDate.now().isAfter(threshold) || !isForbidden && LocalDate.now().plusDays(35).isBefore(threshold)){
            System.out.println("Not forbidden");
        }

        // true
        if(!isForbidden && isActive && LocalDate.now().isAfter(threshold) ||
                (isDelayed && !isActive || (LocalDate.now().plusDays(35).isAfter(threshold) || isActive))){
            System.out.println("Either delayed or not");
        }

        if(!isForbidden && isActive && LocalDate.now().isBefore(threshold) && !isDelayed){
            System.out.println("Not delayed");
        }
    }
}
