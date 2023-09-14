package com.interview.takecommand;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gasieugru
 */
public class Sample {

    public static void main(String[] args) {
        List<WorkItem> workItems = List.of(
                new WorkItem("1", "bread", new ArrayList<>()),
                new WorkItem("2", "sandwich_bread", new ArrayList<>()),
                new WorkItem("3", "pop_tart", new ArrayList<>())
        );

        workItems.forEach(Sample::toast);
    }

    static void toast(WorkItem workItem) {
        switch (workItem.configuration) {
            case "1":
                new Toaster1A().toast(workItem);
                break;
            case "2":
                new Toaster1B().toast(workItem);
                break;
            case "3":
                new Toaster1B().toast(workItem);
                break;
        }
    }

    interface Toaster1 {
        void toast(WorkItem workItem);
    }

    static class Toaster1A implements Toaster1 {

        @Override
        public void toast(WorkItem workItem) {
            if (workItem.type == "Bagel") {

            }
        }
    }

    static class Toaster1B implements Toaster1 {
        @Override
        public void toast(WorkItem workItem) {
            if (workItem.type == "Bagel") {

            }
        }
    }


    @AllArgsConstructor
    @Data
    static class WorkItem {
        String configuration;//1, 2, 4

        String type;

        List<String> slides;
    }
}
