package edu.northeastern.ashish;

public class Main {
//https://leetcode.com/problems/number-of-islands/
    public static void main(String[] args) {
        String[][] matrix = {
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };

        System.out.println(getNumOfIslands(matrix) );

    }

    private static int getNumOfIslands(String[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for(int i = 0 ; i < rows; i ++){
            for(int j = 0 ; j < cols; j ++){
                // if this is 1 and we have not visited
                if(matrix[i][j].equalsIgnoreCase("1") && visited[i][j] == false){
                    count++;
                    visitNeighbours(matrix,i,j, visited);
                }
            }
        }

        return count;
    }

    private static void visitNeighbours(String[][] matrix, int row, int col,boolean[][] visited ){
        // check if we are out of bounds if yes just return
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length ||
                matrix[row][col].equalsIgnoreCase("0")
                || visited[row][col] == true){
            return;
        }
        visited[row][col] = true;
        visitNeighbours(matrix, row-1, col, visited); // top neighbour
        visitNeighbours(matrix, row +1, col, visited); // bottom neighbour
        visitNeighbours(matrix, row, col -1 , visited); // left neighbour
        visitNeighbours(matrix, row, col + 1 , visited); // right neighbour
    }
}
