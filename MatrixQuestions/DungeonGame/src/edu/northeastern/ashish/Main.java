package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        System.out.println(findMinHealthForPrince(matrix));
    }

    private static int findMinHealthForPrince(int[][] matrix){
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
                result[i][j] = matrix[i][j] + Math.max(result[i-1][j], result[i][j-1]);
            }
        }

        return result[rows-1][cols-1] > 0 ? 0 : result[rows-1][cols-1]* -1;

    }


}
