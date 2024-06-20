package dsa.conversion;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //   System.out.println(reverseInteger(-123));
//        setKthBit(6, 3);
        //   System.out.println(countSetBit(8));
//        genTheNumFromDigit(3);

//        setKthBit(12, 2);
        int[] a = {4, 1, 2, 1, 10, 2, 4, 5, 5};
//        System.out.println();

        charPrint(5);


    }
    public static void normalPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("S");
            }
            System.out.println();
        }
    }
    public static void genTheNumFromDigit(int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Number : ");
            ans = ans * 10 + sc.nextInt();
        }
        System.out.println(ans);
    }
    public static int countSetBit(int n) {
        int ans = 0;
        while (n != 0) {
            int bit = n & 1;
            if (bit == 1) {
                ans++;
            }
            // n = n >>1 ;
            n >>= 1;
        }
        return ans;
    }
    public static void setKthBit(int n, int k) {
        if (k < n) {
            int mask = 1 << k;
            int ans = n | mask;
            System.out.println(ans);
        }
    }
    public static int reverseInteger(int n) {
        int ans = 0;
        while (n != 0) {
            int digit = n % 10;
            if ((ans > Integer.MAX_VALUE / 10) || (ans < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            ans = (ans * 10) + digit;

            n = n / 10;
        }
        return ans;
    }
    public static int reverseInt(int n) {
        int ans = 0;
        boolean isNeg = false;
        if (n <= Integer.MIN_VALUE) {
            return 0;
        }
        if (n < 0) {
            isNeg = true;
            n = -n;
        }
        while (n != 0) {
            if (ans >= Integer.MAX_VALUE) {
                return 0;
            }
            int digit = n % 10;
            ans = ans * 10 + digit;
            n = n / 10;
        }
        return isNeg ? -ans : ans;
    }
    public static void findFactorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        System.out.println(f);
    }
    public static float kilometerToMiles(int kilometer) {
        return kilometer * 0.621371f;
    }
    public static void intToDigit(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int ans = 0;
        while (n != 0) {
            int digit = n % 10;
            ans = ans * 10 + digit;
            System.out.println(ans);
            //  stringBuilder.insert(0,digit);
            n = n / 10;
        }

    }
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);  //o(nlogn)
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }
    public void getTheLargeFactorial() {}
    public static void hollowPattern(int n) {
        //outer loop
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || j == n - 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println("");
        }
    }
    public static void charPrint(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = (char) (j + 1 + 'A' - 1);
                System.out.print(ch);
            }
            System.out.println("");
        }
    }
}
