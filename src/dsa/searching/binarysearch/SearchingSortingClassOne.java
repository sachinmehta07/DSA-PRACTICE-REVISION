package dsa.searching.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SearchingSortingClassOne {
    public static void main(String[] args) {
        int[] arr1 = {5, 7, 7, 8, 8, 10};

        System.out.println(firstRepeated(arr1, 7));

    }

    //normal function
    public static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int mid = s + e >> 1;
        while (s <= e) {
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                s = mid + 1;
            } else if (target < nums[mid]) {
                e = mid - 1;
            }
            mid = s + e >> 1;
        }
        return -1;
    }

    //in Build function
    public static void getSorting() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);

        int s = Collections.binarySearch(arrayList, 10);  //returns index
    }

    public static int firstRepeated(int[] arr, int n) {
        // Your code here
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == n) {
                ans = mid;
            }if (n > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }
}
