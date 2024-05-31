package dsa.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SampleArrays {
    public static void main(String[] args) {
        int[] a = {0, 1, 1, 1, 0, 0, 1, 1};
        int[] pairArray = {10, 20, 40, 50, 30, 40, 10, 30, 20};
//        System.out.println(Arrays.toString(sortArray(a)));
        if (!FindSingle(pairArray)) {
            System.out.println("NO UNIQUE ELEMENT FOUND :(");
        }
    }


    //help to learn array travels technique.
    public static void pairArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i] + "," + arr[j]);
            }
        }
    }

    public static void pairArray2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("STEP" + i);
            for (int j = i; j < arr.length; j++) {
                System.out.println(arr[i] + "," + arr[j]);
            }
        }
    }

    public static void pairArray3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("STEP" + i);
            for (int j = 0; j < i; j++) {
                System.out.println(arr[i] + "," + arr[j]);
            }

        }
    }

    public static void pairArray4(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println(arr[i] + "," + arr[j]);
            }
            System.out.println("ROUND" + i);
        }
    }

    public static void pairArray5(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("ROUND" + i);
            for (int j = arr.length - 1; j >= 0; j--) {
                System.out.println(arr[i] + "," + arr[j]);
            }

        }
    }

    public static void pairArray6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("ROUND" + i);
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + "," + arr[j]);
            }
        }
    }


    public static int[] sortArray(int[] arr) {

        //counter approach


//        int zeroCount = 0;
//        int oneCount = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 0) {
//                zeroCount++;
//            } else if (arr[i] == 1) {
//                oneCount++;
//            }
//        }
//
//        for (int i = 0; i < zeroCount; i++) {
//            arr[i] = 0;
//        }
//        for (int i = zeroCount; i < arr.length; i++) {
//            arr[i] = 1;
//        }


        //two pointer approach

        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] == 1 && arr[end] == 0) {
                arr[start] = 0;
                arr[end] = 1;
                start++;
                end--;
            } else {
                if (arr[start] == 0) {
                    start++;
                }
                if (arr[end] == 1) {
                    end--;
                }
            }
        }
        return arr;
    }

    public static boolean stringFindSingle(String[] arr) {
        // String uniqueVal = "null";
        for (int i = 0; i < arr.length; i++) {
            boolean uniqueVal = true;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i].equals(arr[j])) {
                    uniqueVal = false;
                    break;
                }
            }
            if (uniqueVal) {
                System.out.println("Unique element :" + arr[i]);
            }
        }
        return false;
    }

    public static int findKeyArray(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                return i;
            }
        }
        System.out.println("Not Found");
        return 0;
    }


    public static void sumOfaArray(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        System.out.println(sum);
    }

    public static void maxMinArray(int[] arr) {
        int max = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            //using inbuilt function
            //    max = Integer.max(max,arr[i]);
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("MAX : " + max);
        System.out.println("MIN : " + min);
    }


    //print extreme
    public static void printExtreme(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            if (i == j) {
                System.out.print(a[i] + " ");
            } else {
                System.out.print(a[i] + " " + a[j]);
            }
            i++;
            j--;
        }
    }

    public static int[] reverseString(int[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start <= end) {
            // Swap the characters at start and end indices
            int temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            // Move the pointers towards the center
            start++;
            end--;
        }
        return s;
    }

    public static int[] reverseArray(int[] mainArr) {
        // brute force
        int j = mainArr.length - 1;
        int[] reversedArr = new int[mainArr.length];
        int i = 0;
        while (j >= 0) {
            reversedArr[i] = mainArr[j];
            i++;
            j--;
        }
        //optimal approach

//        int[] reversedArrOp = new int[mainArr.length];
////        for (int i = 0, j = mainArr.length - 1; j >= 0; i++, j--) {
////            reversedArrOp[i] = mainArr[j];
////        }
        return reversedArr;
    }

    public static boolean FindSingle(int[] arr) {
        // String uniqueVal = "null";
        for (int i = 0; i < arr.length; i++) {
            boolean uniqueVal = true;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    uniqueVal = false;
                    break;
                }
            }
            if (uniqueVal) {
                System.out.println("Unique element :" + arr[i]);
                return true;
            }
        }
        return false;
    }
}