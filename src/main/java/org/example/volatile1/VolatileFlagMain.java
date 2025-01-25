package org.example.volatile1;

import static org.example.util.MyLogger.*;
import static org.example.util.ThreadUtils.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();
        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    /**
     * Note - cache value is mainly synced to main memory when context switching happens.
     *        That is, using flag without volatile might result in expected result oftentimes when context switching logics exist
     */
    static class MyTask implements Runnable {
        //boolean runFlag = true;
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                //runFlag가 false로 변하면 탈출
                // System.out.println("hi"); // this can cause context switching
            }
            log("task 종료");
        }

    }
}
