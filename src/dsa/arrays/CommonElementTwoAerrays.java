package dsa.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElementTwoAerrays {
    public static void main(String[] args) {
        int[] A = {1, 5, 10, 20, 40, 80};
        int[] B = {6, 7, 20, 80, 100};
        int[] C = {3, 4, 15, 20, 70, 80, 120};

        threePointerApproach(A, B, C);

    }

//    public static void commonEle(int[] arrA, int[] arrB, int[] arrC) {
//        int bigArray = 0;
//        int smallArray = 0;
//        int smallestArray = 0;
//
//        ArrayList<Integer> commonElement = new ArrayList<>();
//
//        smallestArray = Math.min(arrA.length, Math.min(arrB.length, arrC.length));
//
//        bigArray = Math.max(arrA.length, Math.max(arrB.length, arrC.length));
//
//        smallArray = arrA.length + arrB.length + arrC.length - smallestArray - bigArray;
//
//
//        for (int i = 0; i < bigArray; i++) {
//            for (int j = 0; j < smallArray; j++) {
//                for (int k = 0; k < smallestArray; k++) {
//                    if (arrA[i] == arrB[j] && arrB[j] == arrC[k]) {
//                        if (!commonElement.contains(arrA[i])) {
//                            commonElement.add(arrA[i]);
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(commonElement);
//    }

    public static void commonEle(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        List<Integer> commonElements = new ArrayList<>();

        while (i < A.length && j < B.length && k < C.length) {
            if (A[i] == B[j] && B[j] == C[k]) {

                if (!commonElements.contains(A[i])) {
                    commonElements.add(A[i]);
                }
                i++;
                j++;
                k++;
                // Add the common element to the list and move all pointers forward
            } else if (A[i] < B[j]) {
                // Move pointer i forward
                i++;
            } else if (B[j] < C[k]) {
                // Move pointer j forward
                j++;
            } else {
                k++;
            }
        }
        System.out.println(commonElements);
    }

//    public static void threePointerApproach(int[] arrA, int[] arrB, int[] arrC) {
//        int p1 = 0, p2 = 0, p3 = 0;
//
//        HashMap<Integer, Integer> commonValList = new HashMap<>();
//
//        while (p1 < arrA.length && p2 < arrB.length && p3 < arrC.length) {
//            if (arrA[p1] == arrB[p2] && arrB[p2] == arrC[p3]) {
//                int commonValue = arrA[p1]; // or arrB[p2] or arrC[p3], they are all equal
//                if (!commonValList.containsKey(commonValue)) {
//                    commonValList.put(commonValue, commonValue);
//                }
//                p1++;
//                p2++;
//                p3++;
//            } else if (arrA[p1] < arrB[p2]) {
//                p1++;
//            } else if (arrB[p2] < arrC[p3]) {
//                p2++;
//            } else {
//                p3++;
//            }
//        }
//
//        ArrayList<Integer> commonValListArray = new ArrayList<>(commonValList.values());
//        System.out.println(commonValList); // Print the HashMap (optional for debugging)
//        System.out.println(commonValListArray);
//    }
    //so there is two pointer approach
    public static void threePointerApproach(int[] arrA, int[] arrB, int[] arrC) {

        //pointer initialize

        int p1 = 0, p2 = 0, p3 = 0;

        HashMap<Integer, Integer> commonValList = new HashMap<>();

        while (p1 < arrA.length && p2 < arrB.length && p3 < arrC.length) {

            if (arrA[p1] == arrB[p2] && arrB[p2] == arrC[p3]) {

                if (!commonValList.containsKey(arrA[p1])) {
                    commonValList.put(arrA[p1], arrA[p1]);
                }

                p1++;
                p2++;
                p3++;

                //see if no one is equal
                //bcz its sorted we can move pointers and find out common ele

                //so first array p1 ask to arrb p2 is i am smaller then you
                //if yes then plz move me forward my next ele might be have same value

                //if no then arrB p2 ask to arrC p3 is i am smaller then you if yes then p2++
                //if no then we can say that smallest is arrC so we can p3++

                //so based on that we will  moving pointers and will find put common and
                // end the loop once any array reach to end point

            } else if (arrA[p1] < arrB[p2]) {
                p1++;
            } else if (arrB[p2] < arrC[p3]) {
                p2++;
            } else {
                p3++;
            }
        }

        ArrayList<Integer> commonValListArray = new ArrayList<>(commonValList.values());

        System.out.println(commonValList);

        System.out.println(commonValListArray);

    }

}
