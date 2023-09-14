package com.interview.chase.threads;

/**
 * @author gasieugru
 */
public class ThreadDemo {

    static class MyThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.print("MyThread");
            }
        }
    }

    static class MyThread1 implements Runnable {

        @Override
        public void run() {
            int n = 0;
            while (n < 10) {
                System.out.println("MyThread1");
                n++;
            }

        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        MyThread1 myThread1 = new MyThread1();

        Thread thread = new Thread(myThread);
        Thread thread1 = new Thread(myThread1);

        thread.start();
        thread1.start();
    }

}
