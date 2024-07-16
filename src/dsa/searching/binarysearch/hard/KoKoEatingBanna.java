package dsa.searching.binarysearch.hard;

import java.util.Arrays;
import java.util.Collections;

public class KoKoEatingBanna {
    public static void main(String[] args) {

    }

    public int getMinBanana(int[] bananaArr, int minHours) {

        //search space
        long s = 1;  // min banana eaten is by pr hour is 1
        long e = 0;


        for (int j : bananaArr) {
            if (j > e) {
                e = j;
            }
        }
        long ans = -1;
        //bs
        while (s <= e) {
            long mid = s + (e - s) / 2; // number of banana consume per hour
            if (isPossible(bananaArr, mid, minHours)) {
                e = mid - 1;  // this possible ans so decrease the number of banana
                ans = mid;
            } else {
                s = mid + 1;  // taking too much time to complete then simply increase the number of banana
            }
        }
        return (int) ans;
    }

    private boolean isPossible(int[] bananaArr, long mid, int minHours) {

        long totalHours = 0;
        for (int i = 0; i < bananaArr.length; i++) {
            totalHours += bananaArr[i] / mid; // calculating total banana per hour
            if (bananaArr[i] % mid != 0) {
                totalHours++;
            }
        }

        return totalHours <= minHours;
    }


}
