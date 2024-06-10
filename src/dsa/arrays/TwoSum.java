package dsa.arrays;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] sumArray = {10, 5, 20, 15, 30};
        findPairTriple(sumArray, 35);
    }

    public static boolean findPairTwoSum(int[] a, int target) {
        boolean isPairFound = false;
        for (int i = 0; i < a.length; i++) {
            System.out.println("ROUND :" + i);
            for (int j = 0; j < a.length; j++) {
                if (a[i] + a[j] == target) {
                    isPairFound = true;
                    System.out.println(a[i] + "," + a[j]);
                }
            }
        }
        return isPairFound;

    }

    public static boolean findPairTriple(int[] a, int target) {
        boolean isPairFound = false;
        for (int i = 0; i < a.length; i++) {
            System.out.println("ROUND :" + i);
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    System.out.print("(" + a[i] + "," + a[j] + "," + a[k] + ")");
                }
                System.out.println("____________________");
            }

        }
        return isPairFound;
    }

    //Two pointer approach
    public int[] twoPointer(int n, int[] arr) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int curSum = arr[low] + arr[high];
            if (curSum == n) {
                return new int[]{low, high};
            } else  if (curSum > n) {
                high--;
            } else if (curSum < n) {
                low++;
            }
        }
        return null;
    }
}
