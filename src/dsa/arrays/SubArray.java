package dsa.arrays;

public class SubArray {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 5, -60};
        getMaxSumSubArray(a);
    }


    // only printing the last sub Array
    public static void getSubArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print(arr[j] + ",");
            }
            System.out.println("\n  SUB ARRAY : NEW");
        }
    }

    public static void getSubArraysWhole(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + ",");
                }
                System.out.println("\n EACH");
            }
        }
    }

    //for getting maximum sub array q
    public static void getMaxSumSubArray(int[] arr) {
        int sum = 0;
        int start = -1;
        int ansStart = -1;
        int ansEnd = -1;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) start = i;

            sum += arr[i];
            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(max);
    }

}
