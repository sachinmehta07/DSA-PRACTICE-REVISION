package dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {10, 1, 6, 7, 14, 9};
        bubbleSortDec(arr);
    }

    //ascending order
    public static void bubbleSort(int[] arr) {

        //hold the value and compare it to next ele
        for (int i = 1; i < arr.length; i++) {
            //why arr.length - i
            // it ignores the already sorted index
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }

            if (!isSwapped) {
                break;
            }

        }
        System.out.println(Arrays.toString(arr));
    }


    //descending order
    public static void bubbleSortDec(int[] arr) {
        //hold the value and compare it to next ele
        for (int i = 1; i < arr.length; i++) {
            //why arr.length - i // it ignores the already sorted index
            boolean isSwapped = false;

            for (int j = 0; j < arr.length - i; j++) {

                if (arr[j] < arr[j + 1]) {
                    //swap
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }

            }

            if (!isSwapped) {
                break;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int j, int nextEle) {
        int temp = arr[nextEle];
        arr[nextEle] = arr[j];
        arr[j] = temp;
    }


}
