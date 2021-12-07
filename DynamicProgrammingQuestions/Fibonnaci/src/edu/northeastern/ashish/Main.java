package edu.northeastern.ashish;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(fibonacciRecursive(5));
    }

    private static long fibonacciRecursive(int n){
        if (n <= 1){
            return n;
        }
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);

    }




}
