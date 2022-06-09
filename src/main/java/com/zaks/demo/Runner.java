package com.zaks.demo;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Test");
        test();
        AbstarctMarker marker1=new MarkerOne();
        AbstarctMarker marker2=new MarkerTwo();
        marker1.mark();
        marker2.mark();
    }
    public static void test(){
        System.out.println("test method");
    }
}
