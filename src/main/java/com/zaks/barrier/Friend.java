package com.zaks.barrier;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Friend implements Callable<String> {

    private int id;
    private CyclicBarrier barrier;

    public Friend(CyclicBarrier barrier,int id) {
        this.barrier = barrier;
        this.id=id;
    }

    @Override
    public String call() throws Exception {
        try{
            System.out.println(" Friend with Id :  " +  this.id  + " started by thread " + Thread.currentThread().getName());
            Random random=new Random();
            Thread.sleep((random.nextInt(20)*100+100));
            barrier.await();
            System.out.println("Lets go buddy ....");
            return "Ok";
        }catch (InterruptedException e){
            System.out.println(" Thread " + Thread.currentThread().getName() +  " Interrupted ");
        }
        return "NOT-OK";
    }
}
