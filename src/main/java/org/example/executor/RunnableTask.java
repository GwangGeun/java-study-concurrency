package org.example.executor;

import org.example.util.MyLogger;
import org.example.util.ThreadUtils;

import static org.example.util.ThreadUtils.sleep;

public class RunnableTask implements Runnable {

    private final String name;
    private int sleepMs = 1000;

    public RunnableTask(String name) {
        this.name = name;
    }

    public RunnableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        MyLogger.log(name + " 시작");
        sleep(sleepMs);
        MyLogger.log(name + " 완료");
    }
}
