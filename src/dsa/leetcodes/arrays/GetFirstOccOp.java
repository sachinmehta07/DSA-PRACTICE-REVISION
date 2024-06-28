package dsa.leetcodes.arrays;

import java.util.HashMap;

public class GetFirstOccOp {

    //brute force
    public static int getFirstOcc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int getFirstOccOp(int[] arr) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int minIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                if (minIndex == -1 || hashMap.get(arr[i]) < minIndex) {
                    minIndex = hashMap.get(arr[i]);
                }
            } else {
                hashMap.put(arr[i], i);
            }
        }

        return minIndex;
    }
}
