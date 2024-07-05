package dsa.TEST;

public class LeetCodeTest {
    public static void main(String[] args) {

        int[] ar = {1, 2, 3, 4};

        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                System.out.print("("+ ar[i] + "," + ar[j] +")");
            }
            System.out.println();
        }
    }

}
