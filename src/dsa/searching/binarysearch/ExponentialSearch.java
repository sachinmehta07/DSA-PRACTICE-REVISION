package dsa.searching.binarysearch;

import java.util.Collections;

public class ExponentialSearch {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 80, 70, 80, 90, 100};
        System.out.println(getEleInInfinite(arr, 80));
    }

    //find the element using exponential search
    public static int getElement(int[] arr, int k) {
        if (arr[0] == k) {
            return 0;
        }
        int i = 1;
        //checking curr i element > k move  right side
        while (i < arr.length && arr[i] < k) {
            i = i * 2;
        }

        // 1 2 3 4 5

        return binarySearch(arr, k, i / 2, Integer.min(i, arr.length - 1));
    }

    private static int binarySearch(int[] arr, int k, int s, int e) {

        int start = s;
        int end = e;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == k) {
                return mid;
            } else if (k > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    //find in element in infinite sorted array
    public static int getEleInInfinite(int[] arr, int k) {

        //as i know how bs work but for infinite we dont have end pointer

        // so we need twerk our bs and ls little bit

        //so we r going to use exponential search

        int start = 0;
        int end = 1;

        while (arr[end] < k) {
            start = end;
            end = end * 2;
        }
        return binarySearch(arr, k, start, end);
    }

}
