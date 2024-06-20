package dsa.patterns;

import java.util.Arrays;

public class MoveAllNegtiveToLeft {
    public static void main(String[] args) {
        int[] nums = {1, 2, -2, 4, -5, -6,44,-8,-9};

        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    public static int[] rearrangeArray(int[] arr) {

        //two pointer
        int start = 0;
        int mid = 0;

        while (mid < arr.length) {

            if (arr[mid] < 0) {
                int temp = arr[mid];
                arr[mid] = arr[start];
                arr[start] = temp;
                start++;
            } else {
                mid++;
            }

        }

        return arr;
    }
}
