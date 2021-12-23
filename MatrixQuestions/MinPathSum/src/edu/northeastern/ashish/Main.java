package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,1},{1,5,1},{4,2,1}};
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

        return result[rows-1][cols-1];
    }
}
