package edu.northeastern.ashish;

import java.util.Arrays;

public class Main {

    enum Direction {UP,DOWN,LEFT,RIGHT};
    public static void main(String[] args) {
        int[][] matrix = createSpiralMatrix(4);
        for (int i = 0 ; i < 4; i ++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }



    private static int[][] createSpiralMatrix(int n){
        Direction dir = Direction.RIGHT;
        int[][] matrix = new int[n][n];
        int count = matrix.length * matrix[0].length;
        int row = 0;
        int col =0;
        int currentVal = 1;
        int leftLimit = 0;
        int upLimit = 0;
        int rightLimit = matrix[0].length;
        int downLimit = matrix.length;



        while(count > 0){

            if(dir == Direction.RIGHT){
                for(int i = col; i < rightLimit; i ++){
                    matrix[row][i] = currentVal++;
                    count--;
                }
                dir = Direction.DOWN;
                row ++;
                col = rightLimit -1;
                upLimit --;
            }
            else if (dir == Direction.DOWN) {
                for(int i = row; i < downLimit; i ++){
                    matrix[i][col] = currentVal++;
                    count--;
                }
                dir = Direction.LEFT;
                row = downLimit -1;
                col = rightLimit -1;
                rightLimit --;

            }
            else if (dir == Direction.LEFT) {
                for(int i = col; i > leftLimit; i --){
                    matrix[row][i] = currentVal++;
                    count--;
                }
                dir = Direction.UP;
                row--;
                col = leftLimit-1;
                downLimit--;

            }else if (dir == Direction.UP) {
                for(int i = row; i > upLimit; i --){
                    matrix[i][col] = currentVal++;
                    count--;
                }
                dir = Direction.RIGHT;
                col++;
                row = upLimit -1;
                upLimit ++;
            }

        }


        return matrix;

    }

}
