package dsa.searching.binarysearch;

public class DivideTwoInt {

    public static void main(String[] args) {

    }
    public int divide(int dividend, int divisor) {
        // case 0 : divisor will be zero return INT_MAX
        // case 1 : dividend will be zero return 0;

        // case 2 : we get dividend INT_MIN VALUE & divisor is -1; // we will return the
        // INT_MAX
        // bcz it will over flow INT_MAX -> LIMIT

        // happy case : number postive and in the limit of INT we simple put our formula

        // case 3 : negative number we simpley do the operation part with positive and
        // we will letter convert the result in negative

        // case 4 : where our result value is > INT_MAX and <INT _MIN in both return
        // their respective LIMITS

        // Handle the edge case
        if (divisor == 0) { // handle the case where divisor is 0
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend <= Integer.MIN_VALUE && divisor == -1) {  //safe from overflow
            return Integer.MAX_VALUE;
        }

        //check int sign
        boolean isNegative = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0));

        //apply bs
        long s = 0;
        long abDividend = Math.abs((long) dividend);
        long abDivisor = Math.abs((long) divisor);
        long e = abDividend;
        long mid = s+(e-s)/2;  //safe from overflow
        long result = 0;

        while(s<=e){
            long quotient = abDivisor * mid;
            if(quotient <= abDividend){
                result = mid; //this might be our ans
                s = mid + 1; //go right for more accurate result
            }else{
                e = mid - 1;
            }
            mid = s+(e-s)/2;
        }

        // lets take out final result apply sign if neg div or dev

        result = isNegative ? -result : result;

        //case where result is > INT MAX
        if(result > Integer.MAX_VALUE ){
            return Integer.MAX_VALUE;
        }

        if(result < Integer.MIN_VALUE ){
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

}
