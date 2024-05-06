package dsa.patterns;

public class BasicPatterns {
    public static void main(String[] args) {
        //hollowPatter(10, 7);
        // AdvanceHollowPatter(5, 5);
        //    invertedHalfPyramid(5);
        fullPyramidHalfPyramid(5);
        // squarePatter(5, 5);
    }

    public static void hollowPatter(int rowNumber, int colNumber) {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                if (i == 0 || i == rowNumber - 1) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || j == colNumber - 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println("    ");
        }
    }

    public static void AdvanceHollowPatter(int rowNumber, int colNumber) {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                if (i == 0 || i == rowNumber - 1) {
                    System.out.print("* ");
                } else {
                    if (i == 1) {
                        if (j == 2 || j == 3) {
                            System.out.print("  ");
                        } else {
                            System.out.print("* ");
                        }
                    } else if (i == 2) {
                        if (j == 1 || j == 3) {
                            System.out.print("  ");
                        } else {
                            System.out.print("* ");
                        }
                    } else if (i == 3) {
                        if (j == 1 || j == 2) {
                            System.out.print("  ");
                        } else {
                            System.out.print("* ");
                        }
                    }
                }
            }
            System.out.println("");
        }
    }


    public static void squarePatter(int rowNumber, int colNumber) {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void halfPyramidPatter(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

    }

    //Your Approach // :) Taken 1 hr while learning Still lot to learn.
    public static void inversePyramidPatter(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = row - 1; j > i; j--) {  //row - i
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    //Love Bhaiya Approach
    public static void inversePyramidPatterOp(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i; j++) {  //row - i
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
//        * * * * *
//        * * * *
//        * * *
//        * *
//        *

    public static void numericHalfPyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" " + (j + 1));
            }
            System.out.println("");
        }
    }

    public static void invertedHalfPyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" " + (j + 1));
            }
            System.out.println("");
        }
    }

    public static void fullPyramidHalfPyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("s");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print(" *");
            }
            System.out.println("");
        }
    }

}
