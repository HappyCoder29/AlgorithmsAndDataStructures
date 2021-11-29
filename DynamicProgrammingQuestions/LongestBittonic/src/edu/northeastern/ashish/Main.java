package edu.northeastern.ashish;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {12, 11, 40, 5, 3, 1};
        System.out.println(longestBittonic(arr));
    }

    private static  int longestBittonic(int[] arr){
        // Base conditions
        if(arr == null || arr.length <=0){
            return 1;
        }
        if(arr.length == 1){
            return 1;
        }

        // Create lis and lds array and fill it with 1 since atleast there will be 1 longest increasing subsequence
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);
        int[] lds = new int[arr.length];
        Arrays.fill(lds, 1);

        for(int i = 0 ; i < arr.length-1 ; i ++){
            for(int j = i+1; j < arr.length; j ++){
                if(arr[j] > arr[i]){
                    // If lis of i + 1 is bigger than lis of j then update the lis j Value
                    // Update the index too if needed
                    if(lis[i] + 1 > lis[j]){
                        lis[j] =  lis[i]+1;
                    }
                }
            }
        }

        for(int i = arr.length-1 ; i >=1  ; i --){
            for(int j = i-1; j >=0; j --){
                if(arr[j] > arr[i]){
                    // If lis of i + 1 is bigger than lis of j then update the lis j Value
                    // Update the index too if needed
                    if(lds[i] + 1 > lds[j]){
                        lds[j] =  lds[i]+1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if (max < lis[i] + lds[i] - 1)
                max = lis[i] + lds[i] - 1;
        }
        return max;
    }
}
