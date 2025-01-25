package org.example.thread.join;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

/*
Question from this code.
- What if main thread should wait for sub threads to be done ?

 */
public class JoinMainV0 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Job(), "Thread1");
        Thread thread2 = new Thread(new Job(), "Thread2");
        log("start");
        thread1.start();
        thread2.start();
        log("end");
    }

    static class Job implements Runnable {

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            log("작업 완료");
        }
    }
}
