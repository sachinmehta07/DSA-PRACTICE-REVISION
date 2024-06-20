package dsa.leetcodes.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber287 {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 2, 3};

//        //brute force approach
//        System.out.println(" O(n2) : " + findDuplicate(arr));
//
//        //sorting array approach
//        System.out.println(" O(n log n): " + findDuplicateOp(arr));
//
//        //Contains Approach
//        System.out.println(" O( log n) : " + findDuplicateSetOp(arr));
//
//        //visited value approach
//        System.out.println(" O(n) O(1): " + visitedApproach(arr));

        sampledApproach(arr);
    }

    public static int findDuplicate(int[] arr) {
//        Brute Force (findDuplicate):
        //O(n2)
        //O(1)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
    public static int findDuplicateOp(int[] arr) {

        //O(nlogn)
        //O(n)
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;

    }
    public static int findDuplicateSetOp(int[] arr) {

        //T.C    //O(n)

        //S.C   //O(n)
        ArrayList<Integer> integerSet = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (integerSet.contains(arr[i])) {
                return arr[i];
            }
            integerSet.add(arr[i]);
        }
        return -1;

    }
    public static int visitedApproach(int[] nums) {

        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            //visiting index based on index

            int index = nums[i];//so based on value we r visiting each index value

            if (nums[index] < 0) {
                return index;   // value already visited
            }

            nums[index] = -nums[index];  //visited that value
        }

        return ans;

    }
    public static void sampledApproach(int[] nums) {
        int n = nums.length - 1;
        int sum = n * (n + 1) / 2;
        int originalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //visiting index based on index
            originalSum = originalSum + nums[i];
        }
        System.out.println(originalSum-sum);
    }


}
