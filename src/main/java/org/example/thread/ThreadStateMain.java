package org.example.thread;

import static org.example.util.MyLogger.*;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState()); // New
        log("myThread.start()");
        thread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + thread.getState()); // TIME_WAITING
        Thread.sleep(4000);
        log("myThread.state4 = " + thread.getState()); // TERMINATED
        log("end");


    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                log("start");
                log("myThread.state2 = " + Thread.currentThread().getState()); // Runnable
                log("sleep start()");
                Thread.sleep(3000);
                log("sleep end()");
                log("myThread.state4 = " + Thread.currentThread().getState()); // Runnable
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
