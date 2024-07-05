package dsa.leetcodes.arrays.twodimensoinal;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        getRotatedImage(matrix);
    }

    public static void getRotatedImage(int[][] matrix) {

        int colSize = matrix[0].length;
        int rowSize = matrix.length;

        int[][] copiedMatrix = new int[rowSize][colSize];
        int n = matrix.length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                copiedMatrix[col][n - 1 - row] = matrix[row][col];
            }
        }


        System.out.println(Arrays.deepToString(copiedMatrix));
    }

    //Optimal solution
    public static void getRotatedImageOp(int[][] matrix) {

        int colSize = matrix[0].length;
        int rowSize = matrix.length;


        //transpose the array
        for (int row = 0; row < rowSize; row++) {
            for (int col = row; col < colSize; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        //simply reverse it matrix each row
        //for each row
        for (int i = 0; i < rowSize; i++) {
            int start = 0;
            int end = rowSize - 1;
//           0 --> 0 1 2 3

            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }


    }
}
