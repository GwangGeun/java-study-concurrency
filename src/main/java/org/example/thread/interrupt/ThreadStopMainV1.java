package org.example.thread.interrupt;

import static org.example.util.MyLogger.*;
import static org.example.util.ThreadUtils.sleep;

/*
The downside of this approach to stop thread is that "resource clean up" is not called immediately
 */
public class ThreadStopMainV1 {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "myTask");
        thread.start();

        sleep(4000);
        log("force to stop work");
        myTask.runFlag = false;

    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag) {
                log("progress");
                sleep(3000);
            }
            log("resource clean up");
            log("complete");

        }

    }
}
