package dsa.java_collection;

import java.util.*;
import java.util.Collection;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicInbuiltAlgorithms {
    public static void main(String[] args) {
        iota();
    }
    public void commonAlgoList() {

        ArrayList<Integer> arrayList = new ArrayList<>(10);

        int[] ss = {10, 20, 30, 40};


        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        arr.add(new ArrayList<>(List.of(1, 2, 3)));
        arr.add(new ArrayList<>(List.of(1, 2, 6)));
        arr.add(new ArrayList<>(List.of(1, 5)));
        arr.add(new ArrayList<>(List.of(1, 4)));
        arr.add(new ArrayList<>(List.of(1)));

//        //Row Size (Count)
//        System.out.println(arr.size());
//
//        //Column Size (count)
//        System.out.println(arr.get(0).size());
//
//        System.out.println(arr);


//        arrayList.add(20);
//        arrayList.add(30);
//
//
//        sa.add(50);
//        sa.add(60);
//
//
//        //arrayList.clear();
//
//        arrayList.addAll(sa);
//
////        ArrayList<Integer> arrayLists;
//
//        Iterator<Integer> iterator = arrayList.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());


//        while (iterator.hasNext()) {
//
//        }

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(20);
        arrayList.add(20);
        arrayList.add(40);
        arrayList.add(40);
        arrayList.add(40);
        arrayList.add(50);
        arrayList.add(50);
        arrayList.add(50);
        arrayList.add(60);


        // arrayList.sort(Comparator.naturalOrder());

        //System.out.println("Before rotate : " + arrayList);

        // Collections.rotate(arrayList, 5);

        //removes duplicate from the array
        List<Integer> list = arrayList.stream().distinct().toList();


        //to do partitioning of array based on Predicate
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);

        Map<Boolean, List<Integer>> partitioned = numbers
                .stream()
                .collect(Collectors
                        .partitioningBy(n -> checkEven(n)));

        List<Integer> evenNum = partitioned.get(true);

        List<Integer> greaterOrEqualPartition = partitioned.get(false);

        System.out.println("Even Partition: " + evenNum);

        System.out.println("Odd Partition: " + greaterOrEqualPartition);

        //  System.out.println("After rotate : " + arrayList);


        //reveres the list
        Collections.reverse(arrayList);


        System.out.println("arrayList : reverseOrder : " + arrayList);

        // Check if Prime number exist or not
        // Filter even numbers and print them

        System.out.println(arrayList.stream().filter(num -> num % 2 == 0).count());

        List<Integer> evenNumbers = arrayList.stream()
                .filter(num -> num % 2 == 0)  //if condition is true then only element passed
                .map(n -> doSquare(n)) //helps to transform the element and get the set
                // result from the array or do operation on each ele.
                .toList();

        System.out.println(evenNumbers);


    }
    public static boolean checkEven(int n) {
        return n % 2 == 0;
    }
    public static int doSquare(int n) {
        return n * 2;
    }
    public static void numericAlgorithms() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);

        //see it only works on curr element and do operation on Each eleM
        // NOT SUM WORK --> SUM HAPPENS ON ELEM at  per index Only
        List<Integer> list = arrayList.stream().map(n -> n + n).toList();


        //same as c++ accumulate > reduce
        //SUM DONE --> TO GET SINGLE DIGIT FROM GOING THROUGH ENTIRE ARRAY DOING SOME OPERATION
        int totalSum = arrayList.stream().reduce(0, (subTotal, currElement) -> sumTotal(subTotal, currElement));

        System.out.println("Using Reduce : " + totalSum);
    }
    //See you can do anything to with those value to get single value by traveling entire array.
    public static int sumTotal(int subTotal, int currE) {
        return subTotal + currE;
    }
    public static void multiplicationOfTwoDArray() {

        ArrayList<Integer> arrayListOne = new ArrayList<>();
        ArrayList<Integer> arrayListTwo = new ArrayList<>();

        arrayListTwo.add(1);
        arrayListTwo.add(2);
        arrayListTwo.add(3);
        arrayListTwo.add(4);

        arrayListOne.add(1);
        arrayListOne.add(2);
        arrayListOne.add(3);
        arrayListOne.add(4);

        System.out.println("IntStream : min : " + IntStream.of(10, 5, 4).min());
        System.out.println("IntStream : max : " + IntStream.of(10, 5, 4).max());
        System.out.println("IntStream : sum : " + IntStream.of(10, 5, 4).sum());

        //run through each element
        IntStream.iterate(0, i -> i + 1).limit(15).forEach(System.out::println);

        System.out.println(getInnerMulTwoArrays(arrayListOne, arrayListTwo));
    }
    //in c++ it's called inner product
    public static long getInnerMulTwoArrays(ArrayList<Integer> one, ArrayList<Integer> two) {
        if (one.size() != two.size()) {
            System.out.println("array LIST SIZE MUST BE SAME");
        } else {
            return IntStream.
                    range(0, one.size())
                    .mapToLong(i -> (long) one.get(i) * two.get(i))
                    .sum();
        }
        return -1;
    }
    public static void partialSum() {


        //Sum of All value

        List<Integer> integerList = Arrays.asList(10, 20, 30, 40);

        System.out.println("Contents of the list - " + integerList);

        //for understanding
        Stream<Integer> integerStream = integerList.stream();
        List<Integer> sumOfElements = Collections.singletonList(integerStream.collect(Collectors.summingInt(e -> e)));

        System.out.println("Sum of the stream - " + sumOfElements);


        //sum of partial way : 0 =  0+1,3=1+2 ,6=3+3 ,10=6+4,15 = 10+5 --> 15 ---->1,3,6,10,15

        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);


//        List<Integer> partialSums = IntStream
//                .range(0, numbers.size())
//                .mapToObj(i -> numbers.subList(0, i + 1)
//                        .stream()
//                        .mapToInt(j -> j)
//                        .sum())
//                .toList();
//        System.out.println("Partial sums: " + partialSums);


        //logic wise partial sum
//        for (int i = 0; i < numbers.size(); i = i + 2) {
//            for (int j = i + 1; j <= i + 1; j++) {
//                if (i == numbers.size() - 1) { //odd size array
//                    System.out.println("Odd Size Array Last: Element" + numbers.get(i));
//                } else { //even size array
//                    System.out.println("Partial sums : " + numbers.get(i) + numbers.get(j));
//                }
//            }
//        }

        //logic wise partial sum

        //System.out.println();


        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {

            sum = sum + numbers.get(i);

            System.out.println("Partial sums: " + sum);

//            if (i == numbers.size() - 1) { // odd size array
//                sum = sum + numbers.get(i);
//                System.out.println("Partial sums: " + numbers.get(i));
//            } else { // even size array
//                sum = sum + numbers.get(i);
//                System.out.println("Partial sums: " + sum);
//            }


        }
    }
    public static void iota() {

        ArrayList<Integer> arrayList = new ArrayList<>();

        //exclusive end
        IntStream.range(0, 5).forEach(i -> arrayList.add(i));
        System.out.println(arrayList);

        //inclusive end
        arrayList.clear();
        IntStream.rangeClosed(0, 5).forEach(i -> arrayList.add(i));

        System.out.println(arrayList);
    }
}

