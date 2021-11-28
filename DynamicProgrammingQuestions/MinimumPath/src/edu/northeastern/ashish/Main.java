package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                        { 1,10,3,5  },
                        { 8,7,4,3  },
                        { 2,3,1,2  },
                        { 6,3,1,8  }
                     };

        System.out.println(getMinPath(matrix));
    }

    private static int getMinPath(int[][] matrix){
        int rows = matrix[0].length;
        int cols = matrix[1].length;

        int[][] table = new int[rows][cols];
        table[0][0] = matrix[0][0];

        for(int i = 1 ; i < rows; i ++){
            table[i][0] = table[i-1][0] + matrix[i][0];
        }

        for(int i = 1 ; i < cols; i ++){
            table[0][i] = table[0][i-1] + matrix[0][i];
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                table[i][j] = matrix[i][j] +  Math.min(    table[i-1][j-1],
                        Math.min(   table[i-1][j],
                                table[i][j-1])
                );
            }
        }

        return table[rows-1][cols-1];

    }
}
