package dsa.searching.binarysearch;

public class GetPivotIndex {
    public static void main(String[] args) {

    }

    public static int getPivotIndex(int[] arr) {
        int s = 0, e = arr.length - 1;
        if (s == e) {
            return s;
        }
        int mid = s + (e - s) / 2;
        while (s <= e) {
            //mid is greater then its next ele then we found our pivot
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            //decide to go left or right
            if (arr[s] > arr[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        return -1;
    }

    public static int getTarget(int s, int e, int[] arr, int target) {

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {

        int pivotIndex = getPivotIndex(nums);
        //if given target is exist at left side
        if (pivotIndex == -1) {
            return getTarget(0, nums.length - 1, nums, target);
        }

        if (target >= nums[0] && target <= nums[pivotIndex]) {
            return getTarget(0, pivotIndex, nums, target);
        }
        return getTarget(pivotIndex + 1, nums.length - 1, nums, target);
    }
}
