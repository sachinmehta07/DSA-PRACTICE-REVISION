package dsa.leetcodes.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

    public class findPeekIndex825 {
    public static void main(String[] args) {

        int a[] = {10,20,50,60,50,30,70,30,20,10};

        System.out.println(getPeekIndex(a));
    }

        public static int getPeekIndex(int[] arr) {
            int s = 0;
            int e = arr.length - 1;
            int mid = s + (e - s) / 2;
            int ans = -1;
            while (s <= e) {
                if (arr[mid] < arr[mid + 1]) {
                    s = mid + 1;
                } else {
                    ans = mid;
                    e = mid - 1;
                }
                mid = s + (e - s) / 2;
            }
            return ans;
        }

        public int peakIndexInMountainArray(int[] arr) {

            //brute force approach

            ArrayList<Integer> resArr = new ArrayList<>();

            int ans = -1;

            for(int i : arr){
                resArr.add(i);
            }

            System.out.println(resArr);

            for(int i = 0;i<resArr.size();i++){
                if(resArr.get(i) > ans){
                    ans = resArr.indexOf(i);
                }
            }

            return ans;
        }

        // lets first find pivot index of array so we can search in range of that array

        public int getPivotIndex(int[] arr) {


            if (arr.length - 1 == 0) {
                return -1;
            }

            int start = 0;
            int end = arr.length - 1;
            int mid = start + (end - start) / 2;

            while (start <= end) {


                // mid at pivot
                if (mid + 1 < arr.length - 1  && arr[mid] > arr[mid + 1]) {
                    return mid;
                }
                // mid at B side
                if (arr[mid] < arr[start]) {
                    // move to left side
                    end = mid - 1;
                } else {
                    // mid at A side
                    start = mid + 1;
                }
                mid = start + (end - start) / 2;
            }
            return -1;
        }



        // as we get pivot we will have the index at
        // which our array change it's order we get range of
        // now it s easy to get target

        public int binarySearch(int s, int e, int arr[], int target) {
            int start = s;
            int end = e;
            int mid = start + (end - start) / 2;
            if (arr.length - 1 == 0) {
                return -1;
            }
            while (start <= end) {
                if (target == arr[mid]) {
                    return mid;
                }
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                mid = start + (end - start) / 2;
            }
            return -1;
        }

        public int search(int[] nums, int target) {

            int pivotIndex = getPivotIndex(nums);

            int n = nums.length;

            if (target >= nums[0] && target <= nums[pivotIndex]) {
                int ans = binarySearch(0, pivotIndex, nums, target);
                return ans;
            } else {
                int ans =  binarySearch(pivotIndex + 1, n - 1, nums, target);
                return ans;
            }
        }
}
