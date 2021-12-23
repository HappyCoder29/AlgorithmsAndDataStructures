package edu.northeastern.ashish;

import javax.swing.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {
    static final int  inf = Integer.MAX_VALUE;
    public static void main(String[] args) {

        int[][] matrix = {
                {0,0,inf,0},
                {0,0,0,0},
                {inf,inf,0,0},
                {0,0,0,0},

        };
        System.out.println(getNumberUniquePathsWithObstacles(matrix));
    }

    public static int getNumberUniquePathsWithObstacles(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];


        if(matrix[0][0] == inf){
            return 0;
        }
        result[0][0] = 1;
        // For rows and col of the matrix value is infinite make the result value = infinite
        // if previous value is infinite then next value would also be infinite
        // else it will be 1
        for(int i = 1 ; i < rows; i ++){
            result[i][0] = (matrix[i][0] == inf) || (matrix[i-1][0] == inf) ? inf : 1;
        }
        for(int i = 1 ; i < cols; i ++){
            result[0][i] = (matrix[0][i] == inf) ||  (matrix[0][i-1] == inf) ? inf : 1;
        }

        for(int i = 1 ; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                if(matrix[i][j] == inf){
                    result[i][j] = inf;
                }
                else if(result[i-1][j] == inf && result[i][j-1] == inf){
                    result[i][j] = inf;
                }
                else  if(result[i-1][j] != inf && result[i][j-1] != inf){
                    result[i][j] =  result[i-1][j] + result[i][j-1];
                }else{
                    result[i][j] = Math.min(result[i-1][j] ,result[i][j-1]);
                }
            }
        }

        return result[rows-1][cols-1];
    }
}
