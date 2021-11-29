package edu.northeastern.ashish;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] jumps = {1,3,5,8,9,2,6,7};
        System.out.println(minJumpsToReachEnd(jumps));
    }
    // O(n^2)
    private static int minJumpsToReachEnd(int[] arr){

        // check for base conditions
        if(arr == null || arr.length <=0){
            return 1;
        }
        if(arr.length == 1){
            return 1;
        }

        // Similar to Longest increasing subsequence create jumps array and indexes array
        // fill first one with 0 and first indexes one to 0
        int[] jumps = new int[arr.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] =0;
        int[] indexes = new int[arr.length];
        Arrays.fill(indexes, -1);
        indexes[0] = 0;


        for(int i = 0 ; i < arr.length-1; i ++){
            for(int j = i + 1 ; j < arr.length; j ++){
                // can we make the jump
                if(arr[i] + i >= j){
                    // If we can reach current j value from i
                    // better than before we update the values
                    if(jumps[j] > jumps[i] + 1){
                        jumps[j] = jumps[i] +1;
                        indexes[j] = i;
                    }
                }
            }
        }
        // If the last value is infinite this means we cannot reach end
        if(jumps[jumps.length -1] == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        // Since the values are in reverse we will put it in stack and print it from stack
        int minJumps = jumps[jumps.length -1];
        Stack<Integer> stack = new Stack<>();
        int indexMax = arr.length-1;
        for(int i = 0 ; i < minJumps; i ++){
            stack.push(arr[indexMax]);
            indexMax = indexes[indexMax];
        }
        stack.push(arr[0]);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();
        // return the last value.
        return jumps[arr.length-1];

    }
}
