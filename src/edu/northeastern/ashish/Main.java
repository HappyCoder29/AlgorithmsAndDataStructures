package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    //Leetcode link https://leetcode.com/problems/running-sum-of-1d-array/
    private static int[] getRunningSumArray(int[] arr){
        if(arr == null || arr.length == 0)
            return  null;

        int[] runningSum = new int[arr.length];
        int sum = 0;
        for(int i = 0 ; i <  arr.length ; i ++){
            sum += arr[i];
            runningSum[i] = sum;
        }
        return runningSum;
    }
}
