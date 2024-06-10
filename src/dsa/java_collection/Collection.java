package dsa.java_collection;

import java.util.*;
import java.util.stream.Collectors;

public class Collection {
    public static void main(String[] args) {
        arrayList();
    }

    public static void arrayList() {


        ArrayList<Integer> arrayList = new ArrayList<>(10);
        ArrayList<Integer> sa = new ArrayList<>(10);

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

        //to do partitioning of array based on condtion
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
        //Collections.reverse(arrayList);


        //  System.out.println("arrayList : reverseOrder : " + arrayList);

        // Check if Prime number exist or not
        // Filter even numbers and print them

        //System.out.println(arrayList.stream().filter(num -> num % 2 == 0).count());

//        List<Integer> evenNumbers = arrayList.stream()
//                .filter(num -> num % 2 == 0)  //if condition is true then only element passed
//                .map(n -> doSquare(n)) //helps to transform the element and get the set
//                                   // result from the array or do operation on each ele.
//                .toList();
//
//        System.out.println(evenNumbers);


//        for (int i : arrayList) {
//
////            if (checkEven(i)) {
////                countEven++;
////            }
//
////            if (arrayList.contains(printDouble(i))) {
////                System.out.println(i);
////            }else {
////                System.out.println("NOT EVEN");
////            }
//            // System.out.println(Collections.frequency(arrayList);
//
//
//        }
        //  System.out.println(countEven);

    }

    public static boolean checkEven(int n) {
        return n % 2 == 0;
    }

    public static int doSquare(int n) {
        return n * 2;
    }

    public static void list() {

        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list2.add(100);
        list2.add(200);
        list2.add(300);


        //  list.clear();
        list.addAll(list2);

        // list.add(0,1);
        System.out.println(list);
        list.getFirst();
        list.getLast();

    }

    public static void queue() {

        Queue<Integer> integerQueue = new LinkedList<>();

        integerQueue.offer(10);
        integerQueue.offer(50);
        integerQueue.offer(80);
        System.out.println(integerQueue);

        System.out.println(integerQueue.poll());  //removes first element

        integerQueue.offer(20);
        System.out.println("Peek ele : " + integerQueue.peek()); //see the peek element

        System.out.println("After removed" + integerQueue.remove(50)); //see the peek element

        System.out.println(integerQueue);


        System.out.println("Peek ele : " + integerQueue.peek()); //see the peek element

        integerQueue.clear();

        integerQueue.offer(20);

        System.out.println("After clear");

        Iterator<Integer> iterator = integerQueue.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(integerQueue);  //printing queue


    }

    public static void stack() {

        Stack<String> stack = new Stack<>();

        stack.push("S");
        stack.push("A");
        stack.push("C");
        stack.push("H");
        stack.push("I");
        stack.push("N");
        Iterator<String> iterator = stack.iterator();

        while (iterator.hasNext()) {
            System.out.println("While loop " + iterator.next());
        }

        System.out.println(stack);

        System.out.println("Pop : " + stack.pop());

        System.out.println("Peek : " + stack.peek());

        System.out.println("Search : " + stack.search("S"));

        System.out.println("First : " + stack.firstElement());

        System.out.println("Last " + stack.lastElement());

        stack.clear();
        stack.add("sachin");
        stack.add("karan");


        System.out.println(stack + "LATEST");

    }

    public static void dequeue() {

        Deque<String> stringDeque = new ArrayDeque<>();

        stringDeque.add("S"); //at the tail of this deque
        stringDeque.push("O"); //at the head of this deque


        stringDeque.addFirst("C"); // if space is not avb throw exp //IllegalStateException
        stringDeque.addLast("D");

        stringDeque.offerFirst("E"); // return true if space avb or false
        stringDeque.offerLast("F");

        System.out.println("Peek First : " + stringDeque.peekFirst());
        System.out.println("Peek last :" + stringDeque.peekLast());


        for (String s : stringDeque) {
            System.out.println(s);
        }

//        stringDeque.add("B");  //Tail of deque
//        stringDeque.push("A"); //Head of deque
//
//        Iterator<String> iteratorReverse = stringDeque.descendingIterator();
//
//        Iterator<String> iterator = stringDeque.iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println("While : " + iterator.next());
//        }
//
//        System.out.println("Normal String Print : " + stringDeque);
//
//        System.out.println("After delete : ");
//
//        System.out.println(stringDeque.poll());  // remove the head of element  // returns null if this deque is empty.
//        System.out.println(stringDeque.remove());  // remove the head of element  // throws an exception if this deque is empty.
//
//
//        System.out.println(stringDeque.pollLast());  // last element removed if empty returns null
//
//        System.out.println(stringDeque.removeLast());  // last element removed if empty returns NoSuchElementException
//        stringDeque.clear();
//
//        System.out.println(stringDeque);

    }

    public static void priorityQueue() {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> priorityQueueModification = new PriorityQueue<>(Comparator.reverseOrder());


        priorityQueue.offer(10);
        priorityQueue.offer(20);
        priorityQueue.offer(30);
        priorityQueue.offer(40);
        priorityQueue.offer(50);
        priorityQueue.offer(5);


        System.out.println(priorityQueue);


        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());

    }

    public static void maps() {
        HashMap<Integer, String> multipleSelection = new HashMap<>();  //un ordered
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();  //ordered
        TreeMap<Integer, String> treeMap = new TreeMap<>(); //ordered

        multipleSelection.put(1, "sachin");
        multipleSelection.put(2, "karan");
        multipleSelection.put(3, "jay");
        multipleSelection.put(4, "love");

        //print  the entire map
        System.out.println(multipleSelection.entrySet());

        //prints the all keys in map
        System.out.println(multipleSelection.keySet());

        //print all values from map
        System.out.println(multipleSelection.values());

        //print through iterate
        for (Map.Entry<Integer, String> entry : multipleSelection.entrySet()) {
            System.out.println(entry.getKey() + "" + entry.getValue());

            if (entry.getKey().equals(1)) {

            }


            if (entry.getValue().equals("1")) {

            }
        }

        int findValFromKey = 1;

        //containsKey  --> check the key is  existed or not
        if (multipleSelection.containsKey(findValFromKey)) {
            System.out.println(multipleSelection.get(findValFromKey));

        }

        if (multipleSelection.containsValue("sachin")) {
            System.out.println("true");
        }

        Iterator<Integer> iterator = multipleSelection.keySet().iterator();

        //print the Keys only
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

    public static void set() {
        Set<Integer> setInteger = new HashSet<>();
        Set<Integer> setIntegerOrdered = new LinkedHashSet<>();
        Set<Integer> setTree = new TreeSet<>();

        setInteger.add(4);
        setInteger.add(55);
        setInteger.add(10);
        setInteger.add(2);
        setInteger.add(3);


        setIntegerOrdered.add(10);
        setIntegerOrdered.add(2);
        setIntegerOrdered.add(30);
        setIntegerOrdered.add(4);
        setIntegerOrdered.add(585);

        setTree.add(10);
        setTree.add(5600);
        setTree.add(38);
        setTree.add(1);
        setTree.add(45);

        System.out.println("HashSet : " + setInteger);
        System.out.println("Set LinkedList : " + setIntegerOrdered);
        System.out.println("Set Tree : " + setTree);


    }
}
