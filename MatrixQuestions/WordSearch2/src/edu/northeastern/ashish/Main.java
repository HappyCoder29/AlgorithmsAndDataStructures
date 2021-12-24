package edu.northeastern.ashish;

import java.util.ArrayList;

public class Main {
//https://leetcode.com/problems/word-search-ii/
    public static void main(String[] args) {

        String[][] matrix = {
                {"o","a","a","n"},
                {"e","t","a","e"},
                {"i","h","k","r"},
                {"i","f","l","v"}
        };
        String[] words = {"oath","pea","eat","rain"};
        ArrayList<String> matchingWords =  getAllWordsInMatrix(matrix, words);

        for (String str: matchingWords) {
            System.out.println(str);
        }

    }

    private static ArrayList<String> getAllWordsInMatrix(String[][] matrix, String[] words){
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            if(searchWordInMatrix(word, matrix) == true){
                list.add(word);
            }
        }
        return list;
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

    }

}
