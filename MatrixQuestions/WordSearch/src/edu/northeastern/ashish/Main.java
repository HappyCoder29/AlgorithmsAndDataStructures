package edu.northeastern.ashish;

public class Main {
//https://leetcode.com/problems/word-search/
    public static void main(String[] args) {

        String[][] matrix = {
                {"A","B","C","E"},
                {"S","F","C","S"},
                {"A","D","E","E"}
        };
        searchWordInMatrix("ABCCDE", matrix);
    }

    private static boolean searchWordInMatrix(String word, String[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        BoxValue<Boolean> box = new BoxValue<>(false);
        for(int i = 0 ; i < rows; i ++){
            for(int j = 0 ; j < cols; j ++){
                visitNeighbours(matrix, i,j, visited, word, 0, box);
                if(box.value == true){
                    System.out.println("Found the word " + word);
                    return true;
                }
            }
        }
        return box.value;

    }
    private static void visitNeighbours(String[][] matrix, int row, int col , boolean[][] visited, String word, int index,
                                           BoxValue<Boolean> box){
        String charAtIndex =  Character.toString(word.charAt(index));
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length ||
                !matrix[row][col].equalsIgnoreCase(charAtIndex)
                || visited[row][col] == true){
            return ;
        }
        // this is the last character and we have matched
        if(matrix[row][col].equalsIgnoreCase(charAtIndex) && index == word.length() -1){
            box.value = true;
            return ;
        }
        visited[row][col] = true;
        visitNeighbours(matrix, row-1, col, visited, word, index+1, box); // top neighbour
        visitNeighbours(matrix, row +1, col, visited, word, index+1, box); // bottom neighbour
        visitNeighbours(matrix, row, col -1 , visited, word, index+1, box); // left neighbour
        visitNeighbours(matrix, row, col + 1 , visited, word, index+1, box); // right neighbour

//        // Diagonals
//        visitNeighbours(matrix, row-1, col-1, visited, word, index+1, box); // top left diagonal  neighbour
//        visitNeighbours(matrix, row - 1, col + 1, visited, word, index+1, box); // top right diagonal  neighbour
//        visitNeighbours(matrix, row + 1, col -1 , visited, word, index+1, box); // bottom left diagonal  neighbour
//        visitNeighbours(matrix, row + 1, col + 1 , visited, word, index+1, box); // bottom right diagonal  neighbour

    }



}
