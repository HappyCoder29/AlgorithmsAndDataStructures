package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}

        };

        int[][] rotated = rotateMatrix(matrix);
        rotated = rotateMatrix(rotated);
        rotated = rotateMatrix(rotated);
        rotated = rotateMatrix(rotated);
        printMatrix(rotated);


    }

    private static int[][] rotateMatrix(int[][] matrix){
        int[][] transpose = transposeMatrix(matrix);

        for(int i = 0 ; i < transpose.length; i ++){
            rotateRow(transpose, i);
        }
        return transpose;
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
    private static void rotateRow( int[][] matrix, int row)
    {
        int iStart = 0;
        int iEnd = matrix[0].length - 1;
        while (iEnd > iStart)
        {
            swapRow(matrix, row, iStart, iEnd);
            iStart++;
            iEnd--;
        }
    }
    private static void swapRow(int[][] matrix, int row, int start, int end){
        int temp = matrix[row][start];
        matrix[row][start] = matrix[row][end];
        matrix[row][end] = temp;
    }



    private  static int[][] transposeMatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] transpose = new int[col][row];

        for (int i = 0; i < row; i++)
        {
            int[] arr = matrix[i];
            for(int j = 0 ; j < col; j ++){
                transpose[j][i] = arr[j];
            }
        }
        return transpose;


    }

}
