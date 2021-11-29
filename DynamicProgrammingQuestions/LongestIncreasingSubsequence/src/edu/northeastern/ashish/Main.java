package edu.northeastern.ashish;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,2,3};
        System.out.println(longestIncreasingSubSequence(arr));
    }

    private static int longestIncreasingSubSequence(int[] arr){

        // Base conditions
        if(arr == null || arr.length <=0){
            return 1;
        }
        if(arr.length == 1){
            return 1;
        }

        // Create lis array and fill it with 1 since atleast there will be 1 longest increasing subsequence
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);

        // fill the indexes to the i since every index will start with their index
        int[] indexes = new int[arr.length];
        for(int i = 0 ; i < arr.length; i ++){
            indexes[i] = i;
        }

        // Variables for storing max LIS and index of max
        int maxLIS = 1;
        int indexMax = -1;


        for(int i = 0 ; i < arr.length-1 ; i ++){
            for(int j = i+1; j < arr.length; j ++){
                if(arr[j] > arr[i]){
                    // If lis of i + 1 is bigger than lis of j then update the lis j Value
                    // Update the index too if needed
                    if(lis[i] + 1 > lis[j]){
                        lis[j] =  lis[i]+1;
                        indexes[j] = i;
                    }
                }

                // Update the maxLIS and index if needed
                if(maxLIS < lis[j]){
                    maxLIS = lis[j];
                    indexMax = j;
                }
            }
        }

        // Since the values we are getting will be in opposite we will store in stack
        // and print in reverse
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < maxLIS; i ++){
            stack.push(arr[indexMax]);
            indexMax = indexes[indexMax];
        }
        // Print the values in increasing order
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();

        // return length of maximum lis
        return maxLIS;
    }
}
