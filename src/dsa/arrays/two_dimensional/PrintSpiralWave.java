package dsa.arrays.two_dimensional;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralWave {
    public static void main(String[] args) {
        //int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        System.out.println(spiralOrder(arr));

    }


    //i tried my approch but faild at when to stop loop and not able think where to stop the traversal ;
    //still i am able think about solution come to some point
    //taken approx 30 min

    public static void printSpiralWave() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> oo = new ArrayList<>();
        int rowSize = arr.length;
        int colSize = arr[0].length;

        for (int row = 0; row < rowSize; row++) {

            for (int col = 0; col < colSize; col++) {

                System.out.print(arr[row][col] + ",");

                if (col == colSize - 1) {
                    //right end side
                    for (int rightEnd = row + 1; rightEnd < rowSize; rightEnd++) {

                        System.out.print(arr[rightEnd][col] + ",");

                        if (rightEnd == rowSize - 1) {
                            //reverse from bottom end to left
                            for (int reverseFirst = colSize - 2; reverseFirst >= 0; reverseFirst--) {

                                System.out.print(arr[rowSize - 1][reverseFirst] + ",");
                                if (reverseFirst == 0) {
                                    System.out.println("   STOP LOOKING");
                                    break;
                                }
                            }

                        }

                    }
                }
            }
        }
    }

    //one of the easiest solution
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();

        if (matrix.length == 0)
            return resultList;

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int rowTop = 0;
        int rowBottom = rowSize - 1;

        int colLeft = 0;
        int colRight = colSize - 1;

        int dir = 0;

        while (rowTop <= rowBottom && colLeft <= colRight) {

            System.out.println("Direction: " + dir);

            System.out.println("rowTop: " + rowTop + ", rowBottom: " + rowBottom + ", colLeft: " + colLeft + ", colRight: " + colRight);

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

            dir = (dir + 1) % 4;// 0->3 range only

        }

        return resultList;
    }
}
