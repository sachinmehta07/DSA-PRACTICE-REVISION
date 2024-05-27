package dsa.patterns;

public class CharPatterns {
    public static void main(String[] args) {
        charPyramidPattern(5);
//        char as = 'a';
//        System.out.println(as);
    }

    public static void charPyramidPattern(int n) {
        char ch = 'A';
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i+1; j++) {
                int num = i + 1;
                ch = (char) (num + 'A' - 1);
                System.out.print(ch);
            }

//            for (char j = ch; j > 'A';) {
//                j--;
//                System.out.print(j);
//            }
            System.out.println("");
        }
    }
}
