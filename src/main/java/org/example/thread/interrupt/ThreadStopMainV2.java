package org.example.thread.interrupt;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class ThreadStopMainV2 {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "myTask");
        thread.start();

        log("force to stop work - interrupt");
        thread.interrupt();
        log("InterruptedException state1 = " + thread.isInterrupted());

    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    log("progress");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log("InterruptedException state2 = " + Thread.currentThread().isInterrupted()); // FALSE : As it wakes up from interrupt.
                log("interrupt message = " + e.getMessage());
                log("state = " + Thread.currentThread().getState()); // Runnable

            }
            log("resource clean up");
            log("complete");

        }

    }
}
