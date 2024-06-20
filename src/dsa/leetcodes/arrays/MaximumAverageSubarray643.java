package dsa.leetcodes.arrays;

import java.util.Arrays;
import java.util.jar.JarEntry;

public class MaximumAverageSubarray643 {

    public static void main(String[] args) {
//        int[] nums = {1, 12, -5, -6, 50, 3};

//        int[] nums = {5, 2, 7, 9, -10, -30};


        int[] nums = {2,0,1};

        int k = 3;

       // System.out.println("max sub array : " + findSubArrayMaxAvg(nums, k));

        System.out.println("max sub array : " + Arrays.toString(sortArrays(nums)));

    }

    //brute force approach
    public static double findMaxAverage(int[] nums, int k) {

        int j = k;

        double maxSum = Integer.MIN_VALUE;

        int start = 0;

        while (j <= nums.length) {

            int sum = 0;

            for (int i = start; i < j; i++) {
                sum = sum + nums[i];
            }

            System.out.print("FROM INDEX: " + start);
            System.out.print(" TO : " + j);
            System.out.println(" SUB ARRAY SUM : " + sum);


            start++;

            j++;
            maxSum = Integer.max(sum, (int) maxSum);

        }
        return maxSum / k;

    }

    //optimal approach
    public static double findSubArrayMaxAvg(int[] arr, int k) {

        // Efficient approach using a sliding window

        // First, we are going to calculate the sum of the first window of size k

        double avg;

        double ans;


        int sum = 0;
        // Compute the sum of the first k elements
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // Calculate the average of the first window
        avg = (double) sum / k;

        // Initialize the answer with the first window average
        ans = avg;

        // Iterate through the rest of the array
        for (int i = k; i < arr.length; i++) {
            // Add the new element that enters the window
            int nextPart = arr[i];

            // Subtract the element that is left behind by the window
            int minusPart = arr[i - k];

            // Update the sum to include the new element and exclude the old element
            sum = sum + nextPart - minusPart;

            // Calculate the new average
            avg = (double) sum / k;

            // Update the answer if the current average is greater than the previous maximum average
            ans = Double.max(avg, ans);

        }

        // Return the maximum average found
        return ans;
    }


    public static int[] sortArrays(int[] arr) {
        int s = 0;
        int mid = 0;
        int end = arr.length - 1;

        //  [0,0,2,1,1,2]

        while (mid <=   end) {

            if (arr[mid] == 0) {

                int temp = arr[mid];
                arr[mid] = arr[s];
                arr[s] = temp;
                s++;
                mid++;

            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                int temp = arr[mid];
                arr[mid] = arr[end];
                arr[end] = temp;
                end--;
            }
        }
        return arr;
    }
}