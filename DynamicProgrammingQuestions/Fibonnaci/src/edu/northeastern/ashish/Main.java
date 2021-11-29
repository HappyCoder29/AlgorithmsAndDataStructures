package edu.northeastern.ashish;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(findFibMemoization(56));
    }
    // O(2^n)
    private static int findFib(int n){
        if(n <= 1){
            return n;
        }
        return findFib(n-1) + findFib(n-2);
    }

    private static Long findFibMemoization(int n){
        if(n <= 1){
            return (long)n;
        }
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, 0L);
        map.put(1, 1L);
        return findFibMemoization(n, map);

    }


    //O(n)
    private static Long findFibMemoization(int n, HashMap<Integer, Long> map){

        if(!map.containsKey(n)){
            map.put(n, findFibMemoization(n-1, map) + findFibMemoization(n-2, map));
        }
        return map.get(n);
    }

    // O(n)
    private static long findFibTabulization(int n){
        if(n <= 1){
            return n;
        }
        long[] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i < arr.length; i ++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[arr.length-1];
    }
}
