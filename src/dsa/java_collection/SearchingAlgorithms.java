package dsa.java_collection;

import java.util.*;

public class SearchingAlgorithms {

    public static void main(String[] args) {
        iterator();
    }

    public static void binarySearch() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        //only works on Sorted Array

        //mnemonic type
        arrayList.add(50);
        arrayList.add(40);
        arrayList.add(30);
        arrayList.add(20);
        arrayList.add(10);

        //arrayList.sort(Comparator.naturalOrder());

        System.out.println(Collections.binarySearch(arrayList, 50));

    }

    public static void lowerBound() {

//        NavigableSet<Integer> sortedSet = new TreeSet<>(Arrays.asList(1, 3, 3, 5, 10,100));
//
//        int key = 50;
//
//        SortedSet<Integer> tailSet = sortedSet.tailSet(key, true);
//        Integer lowerBound = tailSet.isEmpty() ? null : tailSet.first();
//
//        if (lowerBound == null) {
//            System.out.println("No lower bound found for " + key);
//        } else {
//            System.out.println("The lower bound for " + key + " is: " + lowerBound);
//        }


        List<Integer> sortedList = new ArrayList<>();

        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(5);
        sortedList.add(6);

        int key = 4;


        int index = Collections.binarySearch(sortedList, key);

        // If the element is not found, binarySearch returns -(insertion point) - 1
        System.out.println(index);
        int insertionPoint = index;

        if (index < 0) {
            // Calculate the actual insertion point
            index = -(insertionPoint + 1);
        }

        System.out.println(sortedList);


        if (index < sortedList.size()) {

            System.out.println("The lower bound index for " + key + " is: " + index);

            System.out.println("The value at the lower bound index is: " + sortedList.get(index));

        } else {
            System.out.println("No lower-bond found");
        }


    }

    public static int upperBound() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(5);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);

        int key = 35;


        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > key) {
                return arrayList.get(i);
            }
        }
        return -1;
    }

    public static void equalRange() {


        //Array must be sorted

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(40);
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(40);
        arrayList.add(40);
        arrayList.add(40);
        arrayList.add(40);
        arrayList.add(50);
        int key = 40;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == key) {
                result.add(i);
            }
        }
        if (result.size() != 0) {
            System.out.println("Starting Index : " + result.get(0) + "Ending Index " + result.get(result.size() - 1));
        } else {
            System.out.println("Element Not Found");
        }
    }

    public static void maxMin() {
        ArrayList<Integer> arrayList = new ArrayList<>();


        arrayList.add(10);
        arrayList.add(1);
        arrayList.add(30);
        arrayList.add(35);
        arrayList.add(50);
        arrayList.add(100);
        Iterator<Integer> it = arrayList.iterator();


        System.out.println(Collections.max(arrayList));
        System.out.println(Collections.min(arrayList));


    }


    public static void iterator() {
        //doing operation on each ele
        ArrayList<Integer> arrayList = new ArrayList<>();


        arrayList.add(10);
        arrayList.add(1);
        arrayList.add(30);
        arrayList.add(35);
        arrayList.add(50);
        arrayList.add(100);
        Iterator<Integer> it = arrayList.iterator();


        //do operation on each ele
        it.forEachRemaining(n1 -> doSum(n1));

        while (it.hasNext()) {
            it.remove();
        }
    }

    public static void doSum(int n) {
        int sum  = n+n;
        System.out.println("SUM : " + sum);
    }


}
