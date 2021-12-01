package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static int findMinRotated(int[] arr){
        if(arr == null || arr.length == 0){
            return Integer.MIN_VALUE;
        }
        if(arr.length == 1){
            return arr[0];
        }

        int start = 0;
        int end = arr.length-1;
        if(arr[start]> arr[end]){
            return arr[start];
        }

        while(end >= start){
            int mid = (start + end)/2;
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
            if (arr[mid - 1] > arr[mid]) {
                return arr[mid];
            }
            if (arr[mid] > arr[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;

    }
}
