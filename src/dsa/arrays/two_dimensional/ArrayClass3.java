package dsa.arrays.two_dimensional;

public class ArrayClass3 {
    public static void main(String[] args) {
        int[][] arr;

        arr = new int[][]{


                //0  1   2
                /*0*/ {10, 11, 12},
                /*1*/ {20, 21, 22},
                /*2*/ {30, 31, 32},};

        //120 , 150 , 180


//        System.out.println(isFound(arr, 2));
//
//
//        System.out.println("FIND MAX AND MIN");
//        findMaxMin(arr);

//        rowColWiseSum(arr);


        sample(arr);

        System.out.println("AFTER CONVERTING \n :  ");

        sample(transposeMatrix(arr));
    }


    public static void sample(int[][] ints) {
//        int[][] arr = new int[3][3];
//
//        arr = new int[][]{
//                //0  1   2
//                /*0*/ {10, 20, 100},
//                /*1*/ {30, 40, 200},
//                /*2*/ {50, 60, 300},};
//
//        int colSize = 3;
//        int rowSize = 3;

        //printing raw wise


        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println("");
        }


        //printing col wise  //for rectangle Array
//        for (int i = 0; i < colSize; i++) {
//            for (int j = 0; j < rowSize; j++) {
//                System.out.print(arr[j][i] + " ");
//            }
//            System.out.println("");
//        }

        //for square array
//        for (int i = 0; i < colSize; i++) {
//            for (int j = 0; j < rowSize; j++) {
//                System.out.print(arr[j][i] + " ");
//            }
//            System.out.println("");
//        }

        //diagnol matrix ->Square matrix only 
//
//        for (int i = 0; i < rowSize; i++) {
//            for (int j = 0; j < colSize; j++) {
//                if (i + j == 2) {
//                    System.out.println(arr[i][j] + " ");
//                }
//            }
//        }
//
//        for (int i = 0; i < rowSize; i++) {
//            for (int j = 0; j < colSize; j++) {
//                if (i == j) {
//                    System.out.println(arr[i][j] + " ");
//                }
//            }
//        }
//
//        for (int i = 0; i < rowSize; i++) {
//            System.out.println(arr[i][i] + " ");
//        }
    }

    //Search in 2d Array

    public static boolean isFound(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (target == arr[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //find Min-Max

    public static void findMaxMin(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {

                //max flex krne kilye that i know these function
//                max = Integer.max(max, arr[i][j]);
//                min = Integer.min(min, arr[i][j]);

                //if normal understanding
                if (min > ints[j]) {
                    min = ints[j];
                } else if (max < ints[j]) {
                    max = ints[j];
                }

            }
        }
        System.out.println("Min : " + min + " Max :" + max);
    }

    //ROW WISE SUM
    public static void rowColWiseSum(int[][] arr) {
        int rowSum;
        for (int i = 0; i < arr[0].length; i++) {
            rowSum = 0;
            for (int j = 0; j < arr.length; j++) {
                rowSum = rowSum + arr[j][i];
            }
            System.out.println(rowSum);

        }

        for (int i = 0; i < arr.length; i++) {
            rowSum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                rowSum = rowSum + arr[i][j];
            }
            System.out.println(rowSum);

        }

        //Transpose of matrix

    }

    public static int[][] transposeMatrix(int[][] arr) {

        for (int row = 0; row < arr.length; row++) {
            for (int col = row; col < arr[0].length; col++) {
                if (row == col) {

                } else { 
                    int temp = arr[row][col];
                    arr[row][col] = arr[col][row];
                    arr[col][row] = temp;
                }
            }
        }

        return arr;
    }
}
