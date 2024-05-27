package dsa.patterns;

public class PracticePatterns {

    public static void main(String[] args) {
        fancyPatternChatGpt(5);
    }


    public static void floydTriangle(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(num++);
            }
            System.out.println();
        }

    }


    public static void fancyPatternChatGpt(int n) {
        // Growing Part
//        System.out.println("*");
        for (int i = 0; i < n; i++) {

//            System.out.print("*");
            for (int j = 0; j < i + 1; j++) {
//                System.out.print(j + 1);
            }
            for (int k = i - 1; k >= 0; k--) {
//                System.out.print(k + 1);
            }
//            System.out.print("*");

            System.out.println("");
        }

        // Shrinking Part
        for (int i = n - 1; i >= 0; i--) {
            System.out.print("*");
            for (int j = 0; j < i + 1; j++) {
                System.out.print(j + 1);
            }
            for (int k = i - 1; k >= 0; k--) {
                System.out.print(k + 1);
            }
            System.out.print("*");
            System.out.println();
        }
        System.out.println("*");
    }

    private static void printRow(String borderChar, int maxNum) {

    }


//    public static void fancyPattern3(int n) {
//        System.out.println("*");
//        for (int i = 0; i < n; i++) {
//            int cond;
//            if (i <= n / 2) {
//                cond = 2 * i;
//            } else {
//                cond = 2 * (n - i - 1);
//            }
//            System.out.print("*");
//            for (int j = 0; j <= cond; j++) {
//                if (j <= cond / 2) {
//                    System.out.print(j + 1);
//                } else {
//                    System.out.print(cond - j + 1);
//                }
//            }
//            System.out.print("*");
//            System.out.println("");
//        }
//    }

    public static void fancyPattern(int n) {
        // Growing Part
        System.out.println("*");
        for (int i = 0; i < n; i++) {
            System.out.print("*");
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            int temp = i;
            for (int j = 0; j < i; j++) {
                if (temp > 0) {
                    System.out.print(temp);
                }
                temp--;
            }
            System.out.print("*");
            System.out.println();
        }

        // Shrinking Part
        for (int i = 0; i < n; i++) {
            System.out.print("*");
            int temp = 0;
            for (int j = i; j < n; j++) {
                System.out.print(temp + 1);
                temp++;
            }
            int temp2 = n - i - 1;
            for (int j = i; j < n - 1; j++) {
                System.out.print(temp2);
                temp2--;
            }
            System.out.print("*");
            System.out.println();
        }
        System.out.println("*");
    }

    public static void fancyPattern(int n, String borderChar) {
        // Growing Part
        System.out.println(borderChar);
        for (int i = 0; i < n; i++) {
            System.out.print(borderChar);
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            int temp = i;
            for (int j = 0; j < i; j++) {
                if (temp > 0) {
                    System.out.print(temp);
                }
                temp--;
            }
            System.out.print(borderChar);
            System.out.println();
        }

        // Shrinking Part
        for (int i = 0; i < n; i++) {
            System.out.print(borderChar);
            int temp = 0;
            for (int j = i; j < n; j++) {
                System.out.print(temp + 1);
                temp++;
            }
            int temp2 = n - i - 1;
            for (int j = i; j < n - 1; j++) {
                System.out.print(temp2);
                temp2--;
            }
            System.out.print(borderChar);
            System.out.println();
        }
        System.out.println(borderChar);
    }


    public static void fancyPattern2(int n) {
        int total = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j % 2 == 0) {
                    System.out.print(total++);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }

        int startRevers = total - n;
        for (int i = 0; i < n; i++) {
            int num = startRevers;
            for (int j = 0; j < (2 * n) - (2 * i) - 1; j++) {
                if (j % 2 == 0) {
                    System.out.print(num++);
                } else {
                    System.out.print("*");
                }
            }
            startRevers = startRevers - (n - i - 1);
            System.out.println("");
        }
    }

//    public static void fancyPattern(int n) {
//
//        for (int i = 0; i < n; i++) {
//
//            for (int j = 0; j < 2 * n - i - 2; j++) {
//                System.out.print("*");
//            }
//            for (int k = 0; k < 2 * i + 1; k++) {
//                if (k % 2 == 0) {
//                    System.out.print(i + 1);
//                } else {
//                    System.out.print("*");
//                }
//            }
//            for (int j = 0; j < 2 * n - i - 2; j++) {
//                System.out.print("*");
//            }
//            System.out.println("");
//        }
//    }

    public static void numberHollowPattern(int n) {
        //outer loop describes Row's
        for (int i = 0; i < n; i++) {
            //How many times inner loop run based on our pattern
            for (int j = 0; j < n - i; j++) {
                if (i == 0) {
                    System.out.print(j + i + 1);
                } else {
                    if (j == 0 || j == (n - i) - 1) {
                        System.out.print(j + i + 1);
                    } else {
                        System.out.print("s");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void numberMountain(int n) {
        //Outer loop for number of row's
        for (int i = 0; i < n; i++) {
            //inner loop for printing space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            //printing numbers
            for (int k = 0; k < i + 1; k++) {
                System.out.print(k + 1);
            }

            //numbers reverse
            for (int j = 0; j < i; j++) {
                System.out.print(i - j);
            }

            System.out.println("");

        }
    }

    public static void uniqueNumberMountain(int n) {
        //outer loop to row
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < 2 * n - (i + 1) - 1; j++) {
                System.out.print("* ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                if (k % 2 == 0) {
                    System.out.print(i + 1 + " ");
                } else {
                    System.out.print("s ");
                }
            }
            for (int j = 0; j < 2 * n - (i + 1) - 1; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void halfTrianglePattern(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

    }

    public static void numberIncrement(int n) {
        for (int i = 0; i < n; i++) {
            int num = i + 1;
            for (int j = 0; j < i + 1; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println("");
        }
    }

    public static void invertedNumPyramid(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print(k + 1 + " ");
            }

            for (int p = 0; p < i; p++) {
                // int totalNum = n - i - 1; //Last Digit to get know number of last digit
                System.out.print(i - p + " ");
            }
            System.out.println("");
        }

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k < n - i; k++) {
                System.out.print(k + 1 + " ");
            }
            for (int p = 0; p < n - i - 1; p++) {
                int totalNum = n - i - 1; //Last Digit to get know number of last digit
                System.out.print(totalNum - p + " ");
            }
            System.out.println("");
        }
    }

    public static void charPattern(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                char ch = (char) (j + 'A' + n - n);
                System.out.print(ch);
            }
            num++;
            System.out.println("");
        }
    }
}
