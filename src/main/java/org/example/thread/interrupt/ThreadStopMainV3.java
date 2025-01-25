package org.example.thread.interrupt;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "myTask");
        thread.start();

        sleep(100);
        log("force to stop work - interrupt");
        thread.interrupt();
        log("InterruptedException state1 = " + thread.isInterrupted());

    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) { // Even though InterruptedException happens, it doesn't set "isInterrupted to false" yet.
                log("progress");
            }
            log("InterruptedException state2 = " + Thread.currentThread().isInterrupted());

            try {
                log("resource clean up attempt");
                Thread.sleep(1000);
                log("resource clean up success");
            } catch (InterruptedException e){
                log("resource clean up fail");
                log("InterruptedException state3 = " + Thread.currentThread().isInterrupted()); // isInterrupted will be set as false **at this moment** !!
            }
            log("complete");

        }

    }
}
