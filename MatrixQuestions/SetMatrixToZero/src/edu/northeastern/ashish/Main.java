package edu.northeastern.ashish;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeros(matrix);
        printMatrix(matrix);
    }
    private static void printMatrix(int[][] matrix){
        for(int i = 0 ; i < matrix.length; i ++){
            int[] arr = matrix[i];
            for (int val : arr) {
                System.out.print(val + ", ");
            }
            System.out.println();
        }
    }

    private static void setZeros(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        HashSet<Integer> setRows = new HashSet<Integer>();
        Set<Integer> setCols = new HashSet<Integer>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    setRows.add(i);
                    setCols.add(j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (setRows.contains(i) || setCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
