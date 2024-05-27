package dsa.arrays;

import java.util.Arrays;

public class rotateArray {
    public static void main(String[] args) {
        int[] rotateArray = {33, 22, 55, 66, 77, 99,};
        rotateArray(rotateArray, rotateArray.length, 4);
    }

    public static void rotateArray(int[] arr, int size, int k) {
        k = k % size;

        if (k == 0) {
            return;
        }
        //step 1 lets copy K-th last element of array into temp
        int[] temp = new int[size];
        int index = 0;
        //here size-k will help us to know where to start copy from original array
        // as our logic say that copy K-th last element , So we have to know where to start to pick last kth element

        for (int i = size - k; i < size; i++) {
            temp[index] = arr[i];
            index++;
        }
        //step 2 lets shift the element by K-th element in original array
        for (int i = size - 1; i >= 0; i--) {
            //shift the element kth
            if (i - k >= 0) {
                arr[i] = arr[i - k];
            }
        }

        //step 3 copy the temp array into original array
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
    }
}
