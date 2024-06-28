package dsa.bitmanipulation;

public class FindComplement {
    public static void main(String[] args) {

    }

    public int findComplement(int num) {

        int ans = 0;
        int pow = 1;

        while (num != 0) {

            int lastBit = (num & 1) == 1 ? 0 : 1;  //simple flip the bit
            ans = ans + lastBit * pow;  //binary to decimal approach
            num = num >> 1;// update the num
            //process the next digit
            pow = pow * 2; // for calculation purpose

        }
        return ans;
    }

}
