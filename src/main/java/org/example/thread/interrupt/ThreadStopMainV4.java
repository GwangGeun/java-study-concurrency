package org.example.thread.interrupt;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;
/*
**Thread.interrupted()**
스레드의 인터럽트 상태를 단순히 확인만 하는 용도라면 `isInterrupted()` 를 사용하면 된다. 하지만 직접 체크해서 사용할 때는 `Thread.interrupted()` 를 사용해야 한다.
이 메서드는 다음과 같이 작동한다.
- 스레드가 인터럽트 상태라면 `true` 를 반환하고, 해당 스레드의 인터럽트 상태를 `false` 로 변경한다.
- 스레드가 인터럽트 상태가 아니라면 `false` 를 반환하고, 해당 스레드의 인터럽트 상태를 변경하지 않는다.
*
 */
public class ThreadStopMainV4 {

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
            while (!Thread.interrupted()) { // set interrupt state to false
                log("progress");
            }
            log("InterruptedException state2 = " + Thread.currentThread().isInterrupted());

            try {
                log("resource clean up attempt");
                Thread.sleep(1000);
                log("resource clean up success");
            } catch (InterruptedException e){
                log("resource clean up fail");
                log("InterruptedException state3 = " + Thread.currentThread().isInterrupted());
            }
            log("complete");

        }

    }
}
