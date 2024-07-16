package dsa.searching.binarysearch.hard;

import java.util.ArrayList;

public class arrays {
    public static void main(String[] args) {
        expressionAddOperator(6, "123");
    }

    public static void expressionAddOperator(int target, String num) {
        ArrayList<Integer> arrNum = new ArrayList<>();
        // step 1 : take out the string digit into array
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            arrNum.add(digit);
        }

        int sum ;
        int mul ;
        int minus ;


        ArrayList<String> arrAns = new ArrayList<>();


        // subArray approach

        int sumStart = -1;
        int sumEnd = -1;
        int sumAnsStart = -1;


        for (int i = 0; i < arrNum.size(); i++) {
            sum = 0;
            for (int j = i; j < arrNum.size(); j++) {
                if (sum == 0) sumAnsStart = j;
                sum += arrNum.get(j);
                if (sum == target) {
                    sumStart = sumAnsStart;
                    sumEnd = j;
                    break;
                }
            }
        }


        int multiAnsStart = -1;
        int multiAnsEnd = -1;
        int multiStart;


        for (int i = 0; i < arrNum.size(); i++) {
            multiStart = 0;
            mul = 1;
            for (int j = i; j < arrNum.size(); j++) {
                if (mul == 1) multiStart = j;
                mul *= arrNum.get(j);
                if (mul == target) {
                    multiAnsStart = multiStart;
                    multiAnsEnd = j;
                    break;
                }
            }
        }


        int minusAnsStart = -1;
        int minusAnsEnd = -1;
        int start = -1;


        for (int i = 0; i < arrNum.size(); i++) {
            minus = 0;
            for (int j = i; j < arrNum.size(); j++) {
                if (minus == 0) start = j;
                minus -= arrNum.get(j);
                if (minus == target) {
                    minusAnsStart = start;
                    minusAnsEnd = j;
                    break;
                }
            }
        }

        System.out.println("SUM RANGE : \n");
        if (sumStart >= 0 && sumEnd >= 0) {
            for (int i = sumStart; i <= sumEnd; i++) {
                System.out.println(arrNum.get(i));
            }
        }


        System.out.println("MUL RANGE : \n");
        if (multiAnsStart >= 0 && multiAnsEnd >= 0) {
            for (int i = multiAnsStart; i <= multiAnsEnd; i++) {
                System.out.println(arrNum.get(i));
            }
        }


        System.out.println("MINUS RANGE : \n");
        if (minusAnsStart >= 0) {
            for (int i = minusAnsStart; i <= minusAnsEnd; i++) {
                System.out.println(arrNum.get(i));
            }
        }


//        System.out.println("SUM" + sumStart + "to" + sumEnd);
//
//        System.out.println("MUL" + multiAnsStart + " to " + multiAnsEnd);
//
//        System.out.println("MINUS" + minusAnsStart + " to " + minusAnsEnd);

    }
}
