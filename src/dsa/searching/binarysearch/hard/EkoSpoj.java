package dsa.searching.binarysearch.hard;

import java.util.Arrays;
import java.util.Collections;

public class EkoSpoj {

    public static void main(String[] args) {
        int[] arr = {4, 42, 40, 26, 46};
//        5 20
//        4 42 40 26 46
        System.out.println(getMinWood(arr, 20));

    }

    public static boolean isPossible(int[] arr, long maxWood, long currHight) {

        long totalWood = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > currHight) {
                totalWood += (long) arr[i] - currHight;
            }
        }

        return totalWood >= maxWood;

//        return totalWood >= maxWood;

    }

    public static long getMinWood(int[] arr, int m) {

        long s = m;

        long e = 0;

        for (int i : arr) {
            if (i > e) {
                e = i;
            }
        }

        long ans = -1;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (isPossible(arr, m, mid)) {
                s = mid + 1;
                ans = mid;
            } else {
                e = mid - 1;
            }
        }
        return ans;

    }
}
