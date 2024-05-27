package dsa.arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] sumArray = {10, 5, 20, 15, 30};
        findPairTriple(sumArray, 35);
    }

    public static boolean findPairTwoSum(int[] a, int target) {
        boolean isPairFound = false;
        for (int i = 0; i < a.length; i++) {
            System.out.println("ROUND :" + i);
            for (int j = 0; j < a.length; j++) {
                if (a[i] + a[j] == target) {
                    isPairFound = true;
                    System.out.println(a[i] + "," + a[j]);
                }
            }
        }
        return isPairFound;

    }

    public static boolean findPairTriple(int[] a, int target) {
        boolean isPairFound = false;
        for (int i = 0; i < a.length; i++) {
            System.out.println("ROUND :" + i);
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    System.out.print("(" + a[i] + "," + a[j] + "," + a[k] + ")");
                }
                System.out.println("____________________");
            }

        }
        return isPairFound;
    }
}
