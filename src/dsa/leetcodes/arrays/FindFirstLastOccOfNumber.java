package dsa.leetcodes.arrays;
import java.util.Arrays;

public class FindFirstLastOccOfNumber {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 50, 50, 50, 60, 70, 70, 70};
        System.out.println(Arrays.toString(getOccOfNumber(a, 70)));
    }
    //find the first and last occ of given number :
    //brute force approach
    public static int[] getOccOfNumber(int[] arr, int target)  {
        return new int[]{getAllOccIndex(arr, target,true), getAllOccIndex(arr, target,false)};
    }
    public static int getFirstOcc(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            if (arr[mid] == target) {
                //might ans even more left side to get first occ
                ans = mid;
                e = mid - 1;
            }
            if (target > arr[mid]) {
                s = mid + 1;
            }
            if (target < arr[mid]) {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }
    public static int getLastOcc(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            if (arr[mid] == target) {
                //might ans even more left side to get first occ
                ans = mid;
                s = mid + 1;
            }
            if (target > arr[mid]) {
                s = mid + 1;
            }
            if (target < arr[mid]) {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }
    //optimal approach
    public static int getAllOccIndex(int[] a, int target, boolean isFirstOcc) {
        int start = 0;
        int end = a.length - 1;
        int ans = -1;
        int mid = start + (end - start)/2;
        while (start <= end) {
            if (target > a[mid]) {
                start = mid + 1;  //go to right side
            }
            if (target < a[mid]) {
                end = mid - 1; //go to left side
            }
            if (a[mid] == target) {
                ans = mid;
                if (isFirstOcc) { //most left side occurrence
                    end = mid - 1;
                } else {  //most right side occurrence
                    start = mid + 1;
                }
            }
            mid = start + (end - start)/2;
        }
        return ans;
    }
}
