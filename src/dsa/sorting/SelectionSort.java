package dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {50, 60, 20, 10, 1, 0, 5, -5, 2, -3, 200, 100, 105, 300};
        getSelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void getSelectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    public static void swap(int arr[], int firsVal, int secondVal) {
        int temp = arr[firsVal];
        arr[firsVal] = arr[secondVal];
        arr[secondVal] = temp;
    }
}
