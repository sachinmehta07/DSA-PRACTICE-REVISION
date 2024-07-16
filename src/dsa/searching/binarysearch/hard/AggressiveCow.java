package dsa.searching.binarysearch.hard;

import java.util.Arrays;

public class AggressiveCow {
    public static void main(String[] args) {
        int[] a = { 1, 2, 5, 7,5 };
        System.out.println(getMaximumDiff(a, 3));
    }

    public static int getMaximumDiff(int[] stalls, int allCows) {

        Arrays.sort(stalls); //to get the correct ans

        int start = 1; //minimum difference is 1

        int end = stalls[stalls.length - 1] - stalls[0];  // max diff bw two cow

        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;  // safe int overflow

            if (isMaxDiff(stalls, allCows, mid)) {
//                all cow  placed go right find max the diff
                start = mid + 1;
                ans = mid;
            } else {
//                all cow not placed come left and minimize the diff
                end = mid - 1;
            }
        }

        return ans;

    }

    public static boolean isMaxDiff(int[] stalls, int allCows, int diff) {

        int currCow = 1;

        int currCowPlaced = stalls[0];

        // will check all remaining stalls in array is my nextCow is able
        // placed based on given currCowPlaced + diff

        for (int i =  1; i < stalls.length; i++) {
            if (stalls[i] >= currCowPlaced + diff) {
                currCow++;
                currCowPlaced = stalls[i];
            }
        }

//        if(currCow < allCows){
//            return false;
//        }else {
//            return true;
//        }


        return currCow >= allCows;
        //if true that mean all currCow placed go right by true
        // if currCow < allCows that means all cows not placed go left by false
    }
}
