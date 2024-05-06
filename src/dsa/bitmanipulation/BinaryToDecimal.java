package dsa.bitmanipulation;

public class BinaryToDecimal {

    public static void main(String[] args) {
        System.out.println(decimalToBinary(1110));
    }

    public static int decimalToBinary(int n) {
        int ans = 0;
        int pow = 1;
        while (n != 0) {
            int lastDig = n % 10;
            ans = ans + lastDig * pow;
            n = n / 10;
            pow = pow * 2;
        }
        return ans;
    }
}
