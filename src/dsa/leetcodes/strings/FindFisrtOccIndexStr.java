package dsa.leetcodes.strings;

public class FindFisrtOccIndexStr {
    public static void main(String[] args) {

    }

    public int getFirstOcc(String keyString, String str) {

        //sliding window approach
        int keyStrLen = keyString.length();
        int strLen = str.length();

        //case : findS len > str-len
        if (keyStrLen > strLen) {
            return -1;
        }

        //strLen-findStrLen it will not get out of the bound
        
        //all possible subtring with respect to

        //r a c e c a r     key--> c a r
        for (int i = 0; i <= strLen - keyStrLen; i++) {
            if (str.substring(i, i + keyStrLen).equals(keyString)) {
                return i;
            }
        }
        return -1;
    }
}
