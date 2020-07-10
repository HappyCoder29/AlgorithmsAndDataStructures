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

    private static void swap(int[] arr, int i, int j){
        if( arr == null || i <  0 || j < 0 || i == j || i >= arr.length || j >= arr.length)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //https://leetcode.com/problems/shuffle-the-array/
    private static void shuffleArray(int[] arr){
        int n = arr.length/2;
        for(int i = 0 ; i < n ; i ++){
            swap(arr, i , i + n);
        }
    }


    //https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

    private static boolean[] kidsWithGreatestNumberOfCandies(int[] candies, int numLeft){
        boolean[] answer = new boolean[candies.length];
        int maxNum = 0;
        for (int candy : candies) {
            if(candy > maxNum)
                maxNum = candy;
        }

        for (int i = 0 ; i < candies.length; i ++) {
          answer[i] = candies[i] + numLeft > maxNum? true : false;
        }
        return  answer;
    }
}
