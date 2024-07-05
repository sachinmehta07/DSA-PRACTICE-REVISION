package dsa.leetcodes.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find_K_ClosestTo_X_658 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        System.out.println(findClosestElements(arr, 2, 3));

    }

    //brute force approach --> simple O(n)
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0, right = arr.length - 1;

        // Narrow down the window to size k

        //why : right - left :

        //The goal is to narrow down the array to exactly k closest elements to x.

        // To achieve this, we use two pointers (left and right) and

        // adjust them until the size of the window between them is exactly k.


        while (right - left >= k) {

            int leftDiff = Math.abs(arr[left] - x);

            int rightDiff = Math.abs(arr[right] - x);

            if (leftDiff > rightDiff) {
                left++;
            } else {
                right--;
            }

        }

        // Collect the elements within the window
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;

    }

    //optimal log n

    public static List<Integer> findClosestElementsOp(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;

        // Binary search for the starting point
        while (left < right) {

            int mid = (left + right) / 2;

            int firstClosest = x - arr[mid];

            int lastClosest = arr[mid + k] - x;

            // Compare distances
            if (firstClosest > lastClosest) {
                left = mid + 1;
            } else {
                right = mid;
             }
        }

        // Collect the k closest elements
        List<Integer> result = new ArrayList<>();

        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        // Sort the result in ascending order (not needed if the original array is sorted)
        //Collections.sort(result);

        return result;
    }
}
