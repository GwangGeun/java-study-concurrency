package org.example.executor;

import org.example.util.MyLogger;
import org.example.util.ThreadUtils;

import java.util.Random;

import static org.example.util.MyLogger.log;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "Thread-1");
        thread.start();
        thread.join();

    }

    static class MyRunnable implements Runnable {

        int value;

        @Override
        public void run() {
            log("Runnable 시작");
            ThreadUtils.sleep(2000);
            value = new Random().nextInt(10);
            log("create value = " + value);
            log("Runnable 완료");
        }

    }
}
