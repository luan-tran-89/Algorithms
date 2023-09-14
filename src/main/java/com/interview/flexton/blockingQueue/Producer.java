package com.interview.flexton.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author gasieugru
 */
public class Producer implements Runnable {
    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            Message msg = new Message("" + i);
            try {
                Thread.sleep(1);
                queue.put(msg);
                System.out.println("Produced " + msg.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Message msg = new Message("Exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
