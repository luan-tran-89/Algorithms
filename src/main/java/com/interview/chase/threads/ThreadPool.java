package com.interview.chase.threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gasieugru
 */
public class ThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPool threadPool = new ThreadPool();

        threadPool.newSingleThreadExecutor();
        threadPool.newFixedThreadPool();
//        threadPool.newScheduleThreadPool();
        threadPool.newCachedThreadPool();
    }

    public void newSingleThreadExecutor() {
        AtomicInteger counter = new AtomicInteger();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            counter.set(1);
            System.out.println("newSingleThreadExecutor");
        });
        executor.submit(() -> {
            counter.compareAndSet(1, 2);
        });
        System.out.println("newSingleThreadExecutor counter: " + counter.get());
    }

    public void newFixedThreadPool() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        System.out.println("newFixedThreadPool executor.getPoolSize() : " + executor.getPoolSize());
        System.out.println("newFixedThreadPool executor.getQueue().size() : " + executor.getQueue().size());
    }

    public void newCachedThreadPool() {
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.submit(() -> {
            Thread.sleep(1000);
            System.out.println("newCachedThreadPool 1");
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            System.out.println("newCachedThreadPool 2");
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            System.out.println("newCachedThreadPool 3");
            return null;
        });
        System.out.println("newCachedThreadPool executor.getPoolSize() : " + executor.getPoolSize());
        System.out.println("newCachedThreadPool executor.getQueue().size() : " + executor.getQueue().size());
    }

}
