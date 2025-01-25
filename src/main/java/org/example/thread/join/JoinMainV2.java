package org.example.thread.join;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

/*
Question from this code.
- What if main thread should wait for sub threads to be done ?

 */
public class JoinMainV2 {

    public static void main(String[] args) throws InterruptedException {

        SumTask sumTask1 = new SumTask(1,50);
        SumTask sumTask2 = new SumTask(51,100);

        Thread thread1 = new Thread(sumTask1, "Thread1");
        Thread thread2 = new Thread(sumTask2, "Thread2");

        thread1.start();
        thread2.start();

        // wait until thread1, thread2 to be terminated
        log("join() - main thread will wait for thread1. thread2 to be completed");
        thread1.join(); // ref) thread1.join(1000) -> wait max 1 sec
        thread2.join();
        log("main thread finishes to wait for thread1, thread2");

        log("thread1.result = " + sumTask1.result);
        log("thread2.result = " + sumTask2.result);

        int sumAll = sumTask1.result + sumTask2.result;
        log("sumAll = " + sumAll);
        log("end");
    }

    static class SumTask implements Runnable {

        int start;
        int end;
        int result;

        public SumTask(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for(int i=start; i<=end; i++){
                sum += i;
            }
            result = sum;
            log("작업 완료");
        }
    }
}
