package org.example.executor.reject;

import org.example.executor.RunnableTask;

import java.util.concurrent.*;

import static org.example.util.MyLogger.log;

public class RejectMainV2 {

    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(1, 1,
                0, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.DiscardPolicy());

        executor.submit(new RunnableTask("task1"));
        executor.submit(new RunnableTask("task2"));
        executor.submit(new RunnableTask("task3"));
        executor.close();
    }

}
