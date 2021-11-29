package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
       int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(kadane(arr));
    }

    // −2, 1, −3, 4, −1, 2, 1, −5, 4
    // Max is 4,-1,2,1 sum = 6
    static int kadane(int[] arr)
    {
        int max_so_far = 0;
        int max_ending_here = 0;

        for (int i = 0; i < arr.length; i++)
        {
            max_ending_here = max_ending_here + arr[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }

        return max_so_far;
    }
}
