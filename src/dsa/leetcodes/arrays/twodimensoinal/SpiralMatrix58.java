package dsa.leetcodes.arrays.twodimensoinal;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix58 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        System.out.println(spiralMatrixPrint(arr));

    }

    public static ArrayList spiralMatrixPrint(int[][] matrix) {

        ArrayList<Integer> resultList = new ArrayList<>();

        if (matrix.length == 0) {
            return resultList;
        }

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        //we will use the for pointer approach
        //4 direction approach


        //dir 0 : left to right
        //dir 1 : top to bottom
        //dir 2 : right to left
        //dir 3 : bottom to top

        int rowTop = 0;
        int rowBottom = rowSize - 1;

        int colRight = colSize - 1;
        int colLeft = 0;

        int dir = 0;
        while (rowTop <= rowBottom && colLeft <= colRight) {
            //moving left to right
            if (dir == 0) {
                //left to right
                //rowTop -> constant
                for (int i = colLeft; i <= colRight; i++) {
                    resultList.add(matrix[rowTop][i]);
                }
                rowTop++;
            } else if (dir == 1) {
                //top to bottom
                //colRight
                for (int i = rowTop; i <= rowBottom; i++) {
                    resultList.add(matrix[i][colRight]);
                }
                colRight--;
            } else if (dir == 2) {
                //right to left
                //rowBottom -->  constant

                for (int i = colRight; i >= colLeft; i--) {
                    resultList.add(matrix[rowBottom][i]);
                }
                rowBottom--;
            } else if (dir == 3) {
                //bottom to top
                //colLeft
                for (int i = rowBottom; i >= rowTop; i--) {
                    resultList.add(matrix[i][colLeft]);
                }
                colLeft++;
            }
            dir = (dir + 1) % 4;  //maintain the direction of array  traversal
        }
        return resultList;
    }
}
