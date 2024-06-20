package dsa.arrays.two_dimensional;

import java.util.ArrayList;
import java.util.List;

public class PrintWaveMatrix {
    public static void main(String[] args) {
        printWaveRowWise();
    }

    public static void printWaveMatrix() {

        //col wise

        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int rows = a.length;

        int colum = a[0].length;

        for (int col = 0; col < colum; col++) {
            if (col % 2 != 0) {
                for (int k = rows - 1; k >= 0; k--) {
                    System.out.print("-->bottom - up " + a[k][col]);
                }
                System.out.println();
            } else {
                for (int row = 0; row < rows; row++) {
                    System.out.print("-->top - down" + a[row][col] + ",");
                }
            }
            System.out.println();
        }
    }

    public static void printWaveRowWise() {

        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int rowsSize = a.length;

        int columSize = a[0].length;

        for (int row = 0; row < rowsSize; row++) {

            if ((row & 1) == 1) {
                System.out.print("REVERSE COLUMN : \n");
                for (int k = columSize - 1; k >= 0; k--) {
                    System.out.println(a[row][k]+",");
                }
            } else {
                System.out.println("STRAIGHT COLUMN : \n");
                for (int col = 0; col < columSize; col++) {
                    System.out.println(a[row][col] +",");
                }
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> resultList = new ArrayList<>();
        if (matrix.length == 0) {
            return resultList;
        }

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int rowTop = 0;
        int rowBottom = rowSize - 1;

        int colLeft = 0;
        int colRight = colSize - 1;

        int dir = 0;

        while (rowTop <= rowBottom && colLeft <= colRight) {
            if (dir == 0) {
                // Moving left to right
                for (int i = colLeft; i <= colRight; i++) {
                    resultList.add(matrix[rowTop][i]);
                }
                rowTop++;
            } else if (dir == 1) {
                // Moving top to bottom
                for (int i = rowTop; i <= rowBottom; i++) {
                    resultList.add(matrix[i][colRight]);
                }
                colRight--;
            } else if (dir == 2) {
                // Moving right to left
                for (int i = colRight; i >= colLeft; i--) {
                    resultList.add(matrix[rowBottom][i]);
                }
                rowBottom--;
            } else if (dir == 3) {
                // Moving bottom to top
                for (int i = rowBottom; i >= rowTop; i--) {
                    resultList.add(matrix[i][colLeft]);
                }
                colLeft++;
            }
            dir = (dir + 1) % 4;
        }

        return resultList;
    }


}
