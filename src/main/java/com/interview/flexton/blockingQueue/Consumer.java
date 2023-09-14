package com.interview.flexton.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author gasieugru
 */
public class Consumer implements Runnable {
    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Message msg;

            while ((msg = queue.take()).getMessage() != "Exit") {
                Thread.sleep(5000);
                System.out.println("Consumed " + msg.getMessage());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
