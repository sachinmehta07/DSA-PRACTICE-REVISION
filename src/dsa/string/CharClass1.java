package dsa.string;

public class CharClass1 {

    public static void main(String[] args) {

//        getLowerToUpper(new char[]{'S', 'a', 'b', 'c', 'd', 'D'});
//        System.out.println("\n");
//        getReverse(new char[]{'L', 'n', 'i', 'h', 'c', 'a', 's'});
//        System.out.println(isPalindrome( new char[]{'A', 'm', 'a', 'n', 'a', 'p', 'l', 'a', 'n', 'a', 'c', 'a', 'n', 'a', 'l', 'P', 'a', 'n', 'a', 'm', 'a'}));
//        System.out.println(isPalindrome(new char[]{'m', 'O', 'M'}));
//
//        System.out.println(isPalindrome(new char[]{'r', 'a', 'c', 'e', 'C', 'A', 'R'}));
        getString();

        //what if user throw mix both lower and upper then

    }

    public void getSampleChar() {
        char[] arr = new char[1000];
        arr[0] = 's';
        arr[1] = '@';
        arr[2] = 'c';
        arr[3] = 'h';
        arr[4] = '@';
        arr[5] = 'n';
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '\0') {
                break;
            } else {
                System.out.print(arr[i]);
                count++;
            }
        }
        System.out.println("\nAfter replace ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '\0') {
                break;
            } else {
                if (arr[i] == '@') {
                    arr[i] = '_';
                }
                System.out.print(arr[i]);
            }
        }
        System.out.println(count);
    }

    public static void getLowerToUpper(char[] aToA) {
        for (char value : aToA) {
            char c = value;
            if (value >= 'a' && value <= 'z') {
                c = (char) (value - 'a' + 'A');
            }
            System.out.print(c);
        }
    }

    public static void getUpperToLower(char[] AToa) {
        for (char value : AToa) {
            char c = value;
            if (value >= 'A' && value <= 'Z') {
                c = (char) (value - 'A' + 'a');
            }
            System.out.print(c);

        }
    }

    public static void getReverse(char[] chars) {
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        System.out.println(chars);
    }

    public static boolean getPalindrome(char[] chars) {

        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {

            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return false;
            }

        }
        String s = "asa";
        System.out.println(s);
        char ch = s.charAt(i);
        System.out.println(s.replace(ch, 'c'));
        System.out.println(chars);
        return true;
    }

    public static boolean isPalindrome(char[] s) {

        //remove unwanted char or space

        for (int i = 0; i < s.length; i++) {
            char ch = s[i];
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                if (ch <= 'Z') {
                    char lowerCh = (char) (ch - 'A' + 'a');
                    s[i] = lowerCh;
                }
            } else {
                s[i] = ' ';
            }
        }

        System.out.println(s);


        int i = 0;

        int j = s.length - 1;


        while (i <= j) {

            if (s[i] == s[j]) {
                i++;
                j--;
            } else {
                return false;
            }

        }


        return true;
    }

    public static void getSomeCommonMethods() {
        //https://chatgpt.com/share/b606ce04-73ff-48af-b59e-ef2fea1e3472

        // in java we dont have any direct method to merge the char
        // so we have put both char Arr and placed in java and do that thing

        char[] array1 = {'H', 'e', 'l', 'l', 'o'};
        char[] array2 = {'W', 'o', 'r', 'l', 'd'};
        String str1 = new String(array1);
        String str2 = new String(array2);
        String result = str1 + str2;
    }

    public static void getString() {


        //string are immmutable in nature so u cant chnage value


        String s = "sachin";

        System.out.println(s);

        //but u can update it by concating
        //which same way of creating new object

        s = s.concat("mehta");


        System.out.println(s);

        System.out.println(s.substring(1));

        System.out.println(s.contains("o"));
        System.out.println(s.compareTo("sa"));
    }


}
