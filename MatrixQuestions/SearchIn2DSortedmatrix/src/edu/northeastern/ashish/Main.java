package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(search2dSorted(matrix, 54));
    }

    private static boolean search2dSorted(int[][] matrix, int target){

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = matrix[0].length -1;

        while(row < rows && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;


    }
}
