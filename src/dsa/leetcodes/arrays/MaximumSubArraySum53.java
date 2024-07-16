package dsa.leetcodes.arrays;

public class MaximumSubArraySum53 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 5, -60};
        System.out.println(getOptimalMaxSumSubArray(arr));
    }

    //brute force
    public static int getSubArray(int[] arr) {
        //lets initialize
        int max = arr[0];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > max) {
                    max = sum;
                }
                //max = Integer.max(max, sum);
            }
        }

        return max;

    }

    public static long getOptimalMaxSumSubArray(int[] arr) {

        long max = arr[0];
        long sum = 0;

        //in case of interviwer ask follow up quetion like print subarray with max sum
        int start = -1;

        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < arr.length; i++) {

            if (sum == 0) start = i;

            //as we know that whenever

            //i am starting forming sub array with sum > 0 , sum always starting with 0  and when ever max > sum cum i can say that curr i might be ending subarray

            // and we can say that when ever sum == 0 it said that subarray starting pos.

                sum += (long)arr[i];

                if (sum > max) {
                    max = sum;
                    ansStart = start;
                    ansEnd = i;
                }
                if (sum < 0) {
                    sum = 0;
                }
        }
        System.out.println("SUB ARRAYS ARE :");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.println(arr[i]);
        }
        return max;
    }
}
