package com.common.threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gasieugru
 */
public class ThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPool threadPool = new ThreadPool();

//        threadPool.newSingleThreadExecutor();
//        threadPool.newFixedThreadPool();
        threadPool.newScheduledThreadPool();
//        threadPool.newCachedThreadPool();
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

    public void newScheduledThreadPool() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.schedule(() -> {
            System.out.println("newScheduledThreadPool");
        }, 1, TimeUnit.SECONDS);

        CountDownLatch lock = new CountDownLatch(3);
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("newScheduledThreadPool scheduleAtFixedRate");
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);

        lock.await(1000, TimeUnit.MILLISECONDS);
        future.cancel(true);
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
