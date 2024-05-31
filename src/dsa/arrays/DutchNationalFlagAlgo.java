package dsa.arrays;

import java.util.Arrays;

public class DutchNationalFlagAlgo {
    public static void main(String[] args) {
        int[] num = {1, 2, 0, 1, 0, 2, 2, 1, 0};
        int[] replace = {1, 0, 0, 1, 0, 1, 0, 1, 0};
        // System.out.println(Arrays.toString(replaceZeroAndOne(replace)));
        System.out.println(numStepsLeetCode("1001"));
    }




    public static int[] replaceZeroAndOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
        }
        return arr;
    }

    public static int[] sortArray(int[] num) {

        int left = 0, mid = 0, right = num.length - 1;

        while (mid <= right) {
            if (num[mid] == 0) {
                //   swap(nums[mid], nums[left]);

                int temp = num[left];
                num[left] = num[mid];
                num[mid] = temp;

                left++;
                mid++;
            } else if (num[mid] == 1) {
                mid++;
            } else if (num[mid] == 2) {
                //   swap(nums[mid], nums[right]);
                int temp = num[right];
                num[right] = num[mid];
                num[mid] = temp;

                right--;
            }
        }
        return num;
    }

    //bit Advance
    public static int[] sortColors(int[] nums) {
        int n = nums.length;
        for (int i = 0; n > i; i++) {
            for (int j = i + 1; nums.length > j; j++) {

                if (nums[j] < nums[i]) {

                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;

                }
            }
        }
        return nums;
    }

    public static int[] dutchNational(int[] arr) {
        //brute force approch
        int index, zeroCount = 0, oneCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
            if (arr[i] == 1) {
                oneCount++;
            }
        }
        //put data according to counts

        //put zero's logic
        for (int i = 0; i < zeroCount; i++) {
            arr[i] = 0;
        }
        //put logic of one's
        index = zeroCount;
        for (int i = 0; i < oneCount; i++) {
            arr[index] = 1;
            index++;
        }
        //put two's logic
        for (int i = index; i < arr.length; i++) {
            arr[i] = 2;
        }
        return arr;
    }

    public static int returnNumberOne(int n) {
        int stepsCountToReachOne = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n + 1;
            }
            stepsCountToReachOne++;
        }
        return stepsCountToReachOne;
    }

    public static int numSteps(String s) {  //Number of Steps to Reduce a Number in Binary Representation to One

        //https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/

        //issue when submit the problem using int bcz out of range issue.
        int n = Integer.parseInt(String.valueOf(s));
        int ans = 0;
        int base = 1;

        while (n != 0) {
            int bit = n % 10;
            ans = bit * base + ans;
            n = n / 10;
            base = base * 2;
        }

        int count = 0;
        while (ans > 1) {
            if (ans % 2 == 0) {
                ans = ans / 2;
            } else {
                ans = ans + 1;
            }
            count++;
        }
        return count;
    }

    public static int numStepsLeetCode(String s) {
        // Initialize steps counter and carry flag

        int steps = 0;
        int carry = 0;
        //00 1       - 1
        // Traverse the binary string from the least significant bit (rightmost bit)
        for (int i = s.length() - 1; i > 0; i--) {
            // Current bit plus carry
            int bit = s.charAt(i) - '0' + carry;

            // If bit + carry is odd, increment steps for add and divide operation
            if (bit == 1) {
                carry = 1; // Addition causes a carry
                steps = steps + 2; // One step for addition and one for division
            } else {
                // If bit + carry is even, only division step is needed
                steps = steps + 1;
            }
        }

        // If there's still a carry at the most significant bit
        if (carry == 1) {
            steps++;
        }
        return steps;
    }

    public static int numShiftCount(int n) {
        int cc = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n >> 1;
            } else {
                n = n + 1;
            }
            cc++;
        }
        return cc;
    }
}
