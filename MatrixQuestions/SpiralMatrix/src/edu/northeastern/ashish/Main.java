package edu.northeastern.ashish;
//https://leetcode.com/problems/spiral-matrix/
public class Main {

    enum Direction{ UP, DOWN, LEFT, RIGHT};
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {12,13,14,5},
                {11,16,15,6},
                {10, 9, 8,7},

        };
        printSpiral(matrix);
    }

    private static void printSpiral(int[][] matrix){
        Direction dir = Direction.RIGHT;
        int count = matrix.length * matrix[0].length;

        int upLimit = 0;
        int leftLimit = 0;
        int rightLimit = matrix[0].length -1;
        int downLimit = matrix.length -1;
        int row = 0;
        int col = 0;

        while(count >0){
            System.out.print(matrix[row][col] + ", ");
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

    }
}
