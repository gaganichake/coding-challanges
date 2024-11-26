package com.codingchallanges.array;

import java.util.*;

public class ArrayCopyExample {
    /*
1. Clone an array int[] array = myArray.clone();
2. Copy of array, it will return a new array, int[] newArray = Arrays.copyOf(originalArray, newLength);
3. Copy one array to another array: System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
4. Create a copy of existing ArrayList: new ArrayList<String>(myList)
5. Assigns a default value to each element of the array: Arrays.fill(myArray, -1);
     */

    public static void main(String[] arg) {

        {
            System.out.println("1. Clone an array int[] array");
            int[] myArray = {5, 6, 7};

            int[] array = myArray.clone();

            System.out.println("int[] array = " + Arrays.toString(array));
        }

        {
            System.out.println("2. Copy of array, it will return a new sub-array based on desired size. All positions start from 0");

            int[] myArray = {5, 6, 7};

            int[] array = Arrays.copyOf(myArray, 2);

            System.out.println("int[] array = " + Arrays.toString(array));
        }

        {
            System.out.println("3. Copy one array to another array");

            int[] myArray = {5, 6, 7};

            int[] array = new int[2];

            Arrays.stream(array).sum();

            System.arraycopy(myArray, 1, array, 0, 2);

            System.out.println("int[] array = " + Arrays.toString(array));
        }

        {
            System.out.println("4. Create a copy of existing ArrayList");

            List<Integer> originalArrayList = new ArrayList<>();
            originalArrayList.add(1);
            originalArrayList.add(2);

            List<Integer> arrayList = new ArrayList<>(originalArrayList);

            System.out.println("List<Integer> arrayList = " + arrayList);
        }

        {
            System.out.println("5. Assigns a default value to each element of the array");

            int[] array = new int[10];

            array: Arrays.fill(array, -1);

            System.out.println("int[] array = " + Arrays.toString(array));

        }

        {
            System.out.println("7. Swaps the elements at the specified positions in a Array list: Collections.swap(list, i, j);");

            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);

            Collections.swap(list, 0, 1);
            System.out.println(list);

        }

        {
            System.out.println("'b' - 'a' = " + ('b' - 'a'));
            System.out.println("'z' - 'a' = " + ('z' - 'a'));
            System.out.println("'B' - 'A' = " + ('B' - 'A'));
            System.out.println("'Z' - 'A' = " + ('Z' - 'A'));
            System.out.println("'a' - 'A' = " + ('a' - 'A'));
            System.out.println("'z' - 'Z' = " + ('z' - 'Z'));
            System.out.println("'a' - 'Z' = " + ('a' - 'Z'));
            System.out.println((char)('Z'+1) + ", " + (char)('Z'+2) + ", " + (char)('Z'+3)
                    + ", " + (char)('Z'+4) + ", " + (char)('Z'+5) + ", " + (char)('Z'+6)
                    + ", " + (char)('Z'+7) + ", " + (char)('Z'+8));

        }

        {
            // 1. PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // default is Min heap
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            minHeap.add(100);
            minHeap.add(1);
            minHeap.add(50);

            System.out.println(minHeap.peek());
        }

        {
            // 2. PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            maxHeap.add(100);
            maxHeap.add(1);
            maxHeap.add(50);

            System.out.println(maxHeap.peek());
        }

        {
            char[] chars = {'a', 'b', 'c'};

            System.out.println(new String(chars));
            System.out.println(String.valueOf(chars));
        }

    }

}
