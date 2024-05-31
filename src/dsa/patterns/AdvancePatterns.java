package dsa.patterns;

public class AdvancePatterns {
    public static void main(String[] args) {

        //diamondPattern(4);
        // fullHallowPyramidOp(4);

//        butterFlyPattern(4);
        examPattern(4);


        //  invertedHollowDiamond(5);
    }

    public static void diamondPattern(int n) {

        int firstHalfPyramid = n;

        for (int i = 0; i < firstHalfPyramid; i++) {

            for (int j = 0; j < firstHalfPyramid - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

        int secondHalfPyramid = n;

        for (int i = 0; i < secondHalfPyramid; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < secondHalfPyramid - i; k++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

//   *
//  * *
// * * *
//* * * *
//* * * *
// * * *
//  * *
//   *

    }


    public static void invertedHollowDiamond(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //print the spaces first portion
                System.out.print(" ");
            }
            for (int k = 0; k < n - i; k++) {
                //Printing star at first pos || printing start at last pos
                if (k == 0 || k == (n - i) - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void advanceDiamondP(int n) {
        //Outer layer
        for (int i = 0; i < n; i++) {

            //Space print
            //Printing Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            //Printing Star
            //start print
            for (int k = 0; k < i + 1; k++) {
                //print the star at only first pos and last pos >> to achieve our pattern
                if (k == 0 || k == (i + 1) - 1) {  // k == i // also works same logic
                    System.out.print("* ");
                } else {
                    //print spaces at middle
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }

        int p = 5;
        for (int i = 0; i < p; i++) {

            //Space print
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }

            //start print
            for (int k = 0; k < p - i; k++) {
                if (k == 0 || k == (p - i) - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

    public static void inverseHollowDiamond(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }
            int starNo = 2 * i + 1;  //2 * i + 1  //(n + (i + 1) + i - n);
            for (int k = 0; k < starNo; k++) {
                if (k == 0 || k == starNo - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            int starNo = (n - i) * 2 - 1; //(2*n)-(2*i)+1
            for (int k = 0; k < starNo; k++) {
                if (k == 0 || k == starNo - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }


    //Your Approach
    public static void advanceMultiTriangle(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("s ");
            }

            for (int k = 0; k < i; k++) {
                System.out.print("s ");
            }
            for (int k = 0; k < n - i; k++) {
                System.out.print("* ");
            }

            System.out.println("");
        }

        for (int i = 0; i < n; i++) {

            for (int k = 0; k < i + 1; k++) {
                System.out.print("* ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("s ");
            }
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print("s ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("* ");
            }
            System.out.println("");

        }
    }

    public static void fullHallowPyramidOp(int n) {
        for (int i = 0; i < n; i++) {
            //First half inverted pyramid
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }

            //full pyramid center with spaces
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("s ");
            }

            //Last half pyramid
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

        for (int i = 0; i < n; i++) {
            //First half inverted pyramid
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }

            //full pyramid center with spaces
            for (int k = 0; k < (2 * n) - (2 * i) - 1; k++) {
                System.out.print("s ");
            }

            //Last half pyramid
            for (int j = 0; j < i + 1; j++) { //
                System.out.print("* ");
            }
            System.out.println("");
        }
    }


    public static void ex(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col < row - 1; col++) {
                System.out.print("  ");
            }
            int spaceNo = (2 * n) - (2 * row) - 1;
            for (int col = 0; col < spaceNo; col++) {
                if (col == 0 || col == spaceNo - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("s ");
                }
            }
            System.out.println("");
        }
    }

    public static void butterFlyPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            int spaces = (2 * n) - (2 * i) - 1;
            for (int k = 0; k < spaces; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void examPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {

                if (j == 0 || j == (2 * i + 1) - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

                if (i == n - 1) {
                   // System.out.print("* ");
                } else {

                }

            }
            System.out.println("");
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < (2 * n) - (2 * i) - 1; j++) {
                if (j == 0 || j == ((2 * n) - (2 * i) - 1) - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }
}
