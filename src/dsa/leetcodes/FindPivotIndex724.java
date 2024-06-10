package dsa.leetcodes;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPivotIndex724 {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();

        a.add(10);
        a.add(4);
        a.add(30);
        a.add(2);
        a.add(5);
        a.add(7);

        System.out.println("Arrays : " + a);

        System.out.println("Pivot index is : " + pivotIndexFind(a));

    }

    //learning approach

    //brute force
    public static int sample(ArrayList<Integer> arr) {

        for (int i = 0; i < arr.size(); i++) {

            //left sum  -> excluding curr element
            int leftSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum = leftSum + arr.get(j);
            }

            //right sum  -> excluding curr element
            int rightSum = 0;
            for (int k = i + 1; k < arr.size(); k++) {
                rightSum = rightSum + arr.get(k);
            }

            if (leftSum == rightSum) return i;
        }
        return -1;
    }

    //optimize approach
    public static int pivotIndexFind(ArrayList<Integer> arrayList) {
//         = arrayList.stream().reduce(0,(s,c)->s+c);
        int totalSum = 0;

        for (Integer num : arrayList) {
            totalSum = totalSum + num;
        }

        int leftSum = 0;
        int rightSum;

        for (int i = 0; i < arrayList.size(); i++) {
            //get the right sum
            rightSum = totalSum - arrayList.get(i) - leftSum;

            if (rightSum == leftSum) {
                return i;
            }

            //get the left sum
            leftSum = leftSum + arrayList.get(i);
        }

        return -1;
    }
}
