package edu.northeastern.ashish;

import java.util.Stack;

//https://leetcode.com/problems/minimum-path-sum/
public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,8,7},
                {4,2,3,1},
                {9,8,4,2},
                {7,6,3,1}
        };
        System.out.println(minPathSum(matrix) );
    }

    private static int minPathSum(int[][] matrix){

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];
        int sum = 0;
        for(int i = 0 ; i < rows; i ++){
            sum += matrix[i][0];
            result[i][0] = sum;
        }
        sum = 0;
        for(int i = 0 ; i < cols; i ++){
            sum += matrix[0][i];
            result[0][i] = sum;
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1 ; j< cols; j ++){
                result[i][j] = matrix[i][j] + Math.min(result[i-1][j], result[i][j-1]);
            }
        }

        Stack<Integer> stack = new Stack<>();
        int row = rows-1;
        int col = cols-1;
        stack.push(matrix[row][col]);

        while( row != 0 && col != 0){
            int val = result[row][col] - matrix[row][col];
            if(row == 0 ){
                col --;
            }
            else if(col == 0){
                row --;
            }
            else if(val == result[row][col-1]){

                col --;
            } else if(val == result[row-1][col]){
                row--;
            }
            stack.push(matrix[row][col]);
        }
        stack.push(matrix[0][0]);

        // Stack has all the values in reverse order
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " -> ");
        }
        System.out.println( "End");



        return result[rows-1][cols-1];
    }
}
