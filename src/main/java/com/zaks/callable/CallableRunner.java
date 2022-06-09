package com.zaks.callable;

import java.util.concurrent.*;

public class CallableRunner {

    public static void main(String[] args) {

        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().getName());
            return "HELLO";
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for(int i=0;i<=10;i++){
            Future<String> future = executor.submit(callable);
            try {
                System.out.println(" Result : " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
