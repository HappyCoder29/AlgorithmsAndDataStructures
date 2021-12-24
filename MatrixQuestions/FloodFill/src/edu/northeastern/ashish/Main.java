package edu.northeastern.ashish;

import java.util.Arrays;
//https://leetcode.com/problems/flood-fill/
public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,1,0},
                {1,0,1},
        };
        printMatrix(matrix);
        floodFill(matrix,1,1, 2 );
        System.out.println("********************");
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix){
        for(int i = 0 ; i < matrix.length; i ++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void floodFill(int[][] matrix, int row, int col, int newColor){
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        floodFill(matrix, row, col, newColor, matrix[row][col], visited);
    }

    public static void floodFill(int[][] matrix, int row, int col, int newColor, int oldColor, boolean[][] visited){
        // check if we are out of bounds if yes just return
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length ||
                matrix[row][col] != oldColor
                || visited[row][col] == true){
            return;
        }
        matrix[row][col] = newColor;
        visited[row][col] = true;
        floodFill(matrix, row-1, col, newColor, oldColor, visited); // top neighbour
        floodFill(matrix, row +1, col, newColor, oldColor, visited); // bottom neighbour
        floodFill(matrix, row, col -1 , newColor, oldColor, visited); // left neighbour
        floodFill(matrix, row, col + 1 , newColor, oldColor, visited); // right neighbour
    }
}
