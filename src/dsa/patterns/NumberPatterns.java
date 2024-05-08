package dsa.patterns;

public class NumberPatterns {

    public static void main(String[] args) {
        // numberPattern(4);
        HallowHalfPyramid(5);
    }

    public static void invertedHallowHalfPyramid(int n) {
        //outer loop
        for (int i = 0; i < n; i++) {
            //half inverted pyramid
            for (int j = 0; j < n - i; j++) {
                if (i == 0) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || j == (n - i) - 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println("");
        }
    }

    public static void HallowHalfPyramid(int n) {
        //outer loop
        for (int i = 0; i < n; i++) {
            //half inverted pyramid
            for (int j = 0; j < i + 1; j++) {
                if (i == n - 1) {
                    System.out.print(j + 1 + " ");
                } else {
                    if (j == 0 || j == (i + 1) - 1) {
                        System.out.print(j + 1 + " ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println("");
        }
    }

    public static void numberPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j % 2 == 0) {
                    System.out.print(i + 1);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
        int p = 4;
        for (int i = 0; i < p; i++) {
            for (int k = 0; k < (2 * p) - (2 * i) - 1; k++) {
                if (k % 2 == 0) {
                    System.out.print(p - i);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }
}
