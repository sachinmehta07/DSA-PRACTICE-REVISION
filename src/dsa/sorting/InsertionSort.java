package dsa.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 2, 1, 6, 8,};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {

        //round 1 to <n
        // 5 4 7 2 1 6 8

        for (int i = 1; i < arr.length; i++) {

            int currEle = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < currEle) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = currEle;
        }

    }
}
