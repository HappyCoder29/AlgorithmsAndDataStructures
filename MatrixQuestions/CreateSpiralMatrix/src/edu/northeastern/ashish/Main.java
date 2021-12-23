package edu.northeastern.ashish;

import java.util.Arrays;
//https://leetcode.com/problems/spiral-matrix-ii/
public class Main {

    enum Direction {UP,DOWN,LEFT,RIGHT};
    public static void main(String[] args) {
        int[][] matrix = createMatrixForLoop(5);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][]matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0 ; i < rows; i ++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }


    private static int[][] createMatrix(int n ){
        int rows = n;
        int cols = n;
        int[][] matrix = new int[rows][cols];
        int count = rows * cols;
        int upLimit = 0;
        int leftLimit = 0;
        int rightLimit = cols -1;
        int downLimit = rows -1;
        int row = 0;
        int col = 0;
        int currentNumber = 1;
        Direction  dir = Direction.RIGHT;

        while(count > 0){
            matrix[row][col] = currentNumber;
            currentNumber++;
            if(dir == Direction.RIGHT){
                col++;
                if(col > rightLimit){
                    col--;
                    dir = Direction.DOWN;
                    upLimit ++;
                    row++;
                }
            }
            else if (dir == Direction.DOWN){
                row++;
                if(row > downLimit){
                    row--;
                    dir = Direction.LEFT;
                    rightLimit --;
                    col--;
                }

            }else if (dir == Direction.LEFT){
                col--;
                if(col < leftLimit){
                    col ++;
                    dir = Direction.UP;
                    downLimit --;
                    row--;
                }
            }else if(dir == Direction.UP){
                row--;
                if(row < upLimit){
                    row++;
                    dir = Direction.RIGHT;
                    leftLimit ++;
                    col++;
                }
            }
            count--;
        }

        return matrix;

    }


    private static int[][] createMatrixForLoop(int n ){
        int rows = n;
        int cols = n;
        int[][] matrix = new int[rows][cols];
        int count = rows * cols;
        int upLimit = 0;
        int leftLimit = 0;
        int rightLimit = cols -1;
        int downLimit = rows -1;
        int row = 0;
        int col = 0;
        int currentNumber = 1;
        Direction  dir = Direction.RIGHT;

        while(count > 0){

            if(dir == Direction.RIGHT){
                for(int i = col; i <= rightLimit; i ++){
                    matrix[row][i] = currentNumber++;
                    count--;
                }
                dir = Direction.DOWN;
                row ++;
                upLimit ++;
                col = rightLimit;

            }else if (dir == Direction.DOWN){
                for(int i = row; i <= downLimit; i ++){
                    matrix[i][col] = currentNumber++;
                    count--;
                }
                dir = Direction.LEFT;
                col--;
                rightLimit --;
                row = downLimit;
            }
            else if (dir == Direction.LEFT){
                for(int i = col; i >= leftLimit; i--){
                    matrix[row][i] = currentNumber++;
                    count--;
                }
                row --;
                dir = Direction.UP;
                downLimit --;
                col = leftLimit;

            }else if (dir == Direction.UP){
                for(int i = row; i >= upLimit; i--){
                    matrix[i][col] = currentNumber++;
                    count--;
                }
                col ++ ;
                dir = Direction.RIGHT;
                leftLimit ++;
                row = upLimit;
            }
        }

        return matrix;


    }








}
