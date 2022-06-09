package com.zaks.barrier;

import java.util.ArrayList;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MICROSECONDS;

public class BarrierRunner {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("Barrier Opened!!"));

        //We have intentionally kept thread count=2 while barrier count =4 to test the exception scenario and close
        //JVM gracefully
        //Try changing thread count and play with tasks behaviour
        ExecutorService service = Executors.newFixedThreadPool(4);
        ArrayList<Future<String>> futures = new ArrayList<>();
        try {
            for (int i = 0; i < 4; i++) {
                futures.add(service.submit(new Friend(barrier, i)));
            }
            futures.forEach(future -> {
                try {
                    String result = future.get(10, TimeUnit.SECONDS);
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Exception Occurred " + e.getMessage());
                } catch (TimeoutException e) {
                    System.out.println("Timed Out !!!");
                    future.cancel(true);
                }

            });
        } finally {
            service.shutdown();
        }

    }
}
