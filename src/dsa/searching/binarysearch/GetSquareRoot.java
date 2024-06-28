package dsa.searching.binarysearch;

public class GetSquareRoot {

    public static void main(String[] args) {
        System.out.println(getSquareRoot(100));
    }

    //using bs  //search space method based on ans
    public static int getSquareRoot(int n) {
        int s = 0;
        int e = n;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            long prod = (long) mid * mid;
            if (prod == n) {
                return mid;
            }
            if (prod > n) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        return -1;
    }
}
