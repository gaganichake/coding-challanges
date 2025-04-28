package com.codingchallanges.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayConversionExamples {

    public static void main(String[] arg) {

        System.out.println("*** Examples of array conversions to different data sets ***");
        //-----------------------------------------
        System.out.println("1. Convert ArrayList to Integer[] array");
        {
            List<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            arrayList.add(2);

            Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);

            System.out.println("Integer[] array = " + Arrays.toString(array));
        }

        System.out.println("2. Convert ArrayList to int[] array");
        {
            List<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            arrayList.add(2);

            int[] array = arrayList.stream().mapToInt(i -> i).toArray();

            System.out.println("int[] array = " + Arrays.toString(array));
        }

        System.out.println("3. Convert Integer[] to List<Integer> arrayList");
        {
            Integer[] array = {5, 6, 7};

            List<Integer> arrayList = Arrays.asList(array);

            System.out.println("List<Integer> arrayList = " + arrayList);
        }

        System.out.println("4. Convert int[] to ArrayList<Integer> arrayList");
        {
            int[] array = {5, 6, 7};

            List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());

            System.out.println("List<Integer> arrayList = " + arrayList);
        }

        System.out.println("5. Convert Integer[] to int[] array");
        {
            Integer[] IntegerArray = {3, 4, 5};

            int[] array = Arrays.stream(IntegerArray).mapToInt(i ->  i).toArray();

            System.out.println("int[] array = " + Arrays.toString(array));
        }

        System.out.println("6. Convert int[] to Integer[] array");
        {
            int[] intArray = {3, 4, 5};

//            Integer[] array = Arrays.stream(intArray).boxed().collect(Collectors.toList()).toArray(new Integer[intArray.length]);
            Integer[] array = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

            System.out.println("int[] array = " + Arrays.toString(array));
        }

        System.out.println("7. Convert int[] to Set<Integer> set");
        {
            int[] intArray = {7, 7, 8};

            Set<Integer> set = Arrays.stream(intArray).boxed().collect(Collectors.toSet());

            System.out.println("Set<Integer> set = " + set);
        }

        System.out.println("8. Create Two dimensional array as a linked list");
        {
            int[] intArray1 = {12, 12, 13};
            int[] intArray2 = {33, 44, 55};

            List<int[]> linkedList = new ArrayList<>();
            linkedList.add(intArray1);
            linkedList.add(intArray2);

            System.out.println("List<int[]> linkedList = " + Arrays.toString(linkedList.get(0)) + ", " + Arrays.toString(linkedList.get(1)));


        System.out.println("9. Covert the above linked list to a two dimensional array");


            int[][] twoDimArray = linkedList.toArray(new int[linkedList.size()][]);


            System.out.println("int[][] twoDimArray = " + Arrays.toString(twoDimArray[0]) + ", " + Arrays.toString(twoDimArray[1]));
        }
    }
}
