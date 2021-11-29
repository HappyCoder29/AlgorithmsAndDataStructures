package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("abdfek", "bdxe"));
    }

    private static int longestCommonSubstring(String str1, String str2){
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxX = -1;

        for (int i = 1; i < rows; i++)
        {
            for (int j = 1; j < cols; j++)
            {
                if ( str1.charAt(i - 1) == str2.charAt(j-1) )
                {
                    matrix[i][ j] = matrix[i - 1][ j - 1] + 1;
                    if (max < matrix[i][ j]){
                        max = matrix[i][ j];
                        maxX = i;
                    }
                }
            }
        }

        String str = str1.substring(maxX -max, maxX);
        System.out.println("Maximum common substring = " + str);


        return max;
    }
}
