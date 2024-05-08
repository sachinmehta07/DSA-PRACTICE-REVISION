package dsa.patterns;

public class CharPatterns {
    public static void main(String[] args) {
        charPyramidPattern(5);
    }

    public static void charPyramidPattern(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                int num = i + 1;
                char ch = (char) (num + 'A' - 1);
                System.out.print(ch);
            }
            System.out.println("");
        }
    }
}
