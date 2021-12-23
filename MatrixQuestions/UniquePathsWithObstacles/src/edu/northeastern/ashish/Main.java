package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,1,0},
                {0,0,0,0},
                {1,1,1,0},
                {0,0,0,0},

        };
        System.out.println(getNumberUniquePathsWithObstacles(matrix));
    }

    public static int getNumberUniquePathsWithObstacles(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        if(matrix[0][0] == 1){
            return 0;
        }
        for(int i = 1 ; i < rows; i ++){
            if(matrix[i-1][0] == 1){
                result[i][0] = 1;
            }
        }
        for(int i = 1 ; i < cols; i ++){
            if(matrix[0][i-1] == 1){
                result[0][i] = 1;
            }
        }

        for(int i = 1 ; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                if(matrix[i][j] == 1){
                    result[i][j] = 0;
                    continue;
                }
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }

        return result[rows-1][cols-1];
    }
}
