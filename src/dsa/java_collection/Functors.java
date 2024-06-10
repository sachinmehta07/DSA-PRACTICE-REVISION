package dsa.java_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Functors {
    public static void main(String[] args) {
        functorsExample();
    }

    public static void functorsExample() {
//        compare compare;
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(20);
        arrayList.add(50);

        arrayList.sort((a, b) -> a - b);

        System.out.println(arrayList);

    }

    public static Integer diff(Integer a, Integer b) {
        return a > b ? b : a;
    }
}
