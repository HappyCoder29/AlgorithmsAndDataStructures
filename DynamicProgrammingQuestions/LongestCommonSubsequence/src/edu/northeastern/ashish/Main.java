package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    static int longestCommonSubsequence(String str1, String str2){
        if(str1.length() == 0 || str2.length() == 0){
            return 0;
        }
        int[][] matrix = new int[str1.length() +1][str2.length()+1];
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0 ; i < rows; i ++ ){
            matrix[i][0] = 0;
        }
        for(int i = 0 ; i < cols; i ++ ){
            matrix[0][i] = 0;
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                if ( str1.charAt(i-1) == str2.charAt(j-1) )
                {
                    matrix[i][ j] = matrix[i - 1][ j - 1] + 1;
                }
                else
                {
                    matrix[i][ j] = Math.max(matrix[i - 1][ j], matrix[i][ j - 1]);
                }
            }
        }
        return matrix[rows-1][ cols-1];
    }

}
