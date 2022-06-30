package com.codingchallanges.array;

import java.util.*;
import java.util.stream.Collectors;

public class DataConversionTests {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(2);

		System.out.println(list);

		Integer[] array = list.toArray(new Integer[0]);

		System.out.println(Arrays.toString(array));

		int[] arrayInt = list.stream().mapToInt(i -> i).toArray();

		System.out.println(Arrays.toString(arrayInt));

		arrayInt = Arrays.stream(array).mapToInt(i -> i).toArray();

		System.out.println(Arrays.toString(arrayInt));

		list = Arrays.asList(array);

		System.out.println(list);

		Set<Integer> set = new HashSet<>(Arrays.asList(array));

		System.out.println(set);

		Collections.swap(list, 0, 1);

		System.out.println(list);

		LinkedList<int[]> linkedList = new LinkedList<>();
		linkedList.add(arrayInt);

		int[][] twoDArray = linkedList.toArray(new int[linkedList.size()][]);

		System.out.println(Arrays.toString(twoDArray));

		int[] cloneArrayInt = arrayInt.clone();

		System.out.println(Arrays.toString(cloneArrayInt));

		int[] copyArrayInt = Arrays.copyOf(arrayInt, 10);

		System.out.println(Arrays.toString(copyArrayInt));

		System.arraycopy(arrayInt, 0, copyArrayInt, 8, arrayInt.length);

		System.out.println(Arrays.toString(copyArrayInt));

		List<Integer> copyList = new ArrayList<>(list);

		System.out.println(copyList);

		Arrays.fill(arrayInt, -1);

		System.out.println(Arrays.toString(arrayInt));

		System.out.println(Arrays.binarySearch(arrayInt, -1));

		System.out.println('b' - 'a');
		System.out.println('z' - 'a');

	    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	    minHeap.add(100);
	    minHeap.add(1);
	    minHeap.add(50);

	    System.out.println(minHeap.peek());

	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	    maxHeap.add(100);
	    maxHeap.add(1);
	    maxHeap.add(50);

	    System.out.println(maxHeap.peek());

	    char[] chars = {'a', 'b', 'c'};

	    System.out.println(new String(chars));
	    System.out.println(String.valueOf(chars));

	    System.out.print(Arrays.toString(arrayInt));
	    System.out.println(Arrays.toString(arrayInt));

//		List<Integer> arrayList = Arrays.stream(arrayInt).mapToObj(i -> Integer.valueOf(i)).collect(Collectors.toList());
		List<Integer> arrayList = Arrays.stream(arrayInt).boxed().collect(Collectors.toList()); //Short version
		Set<Integer> Intset = Arrays.stream(arrayInt).boxed().collect(Collectors.toSet());
//		Integer[] integerArray = Arrays.stream(arrayInt).mapToObj(i -> Integer.valueOf(i)).toArray(Integer[]::new);
		Integer[] integerArray = Arrays.stream(arrayInt).boxed().toArray(Integer[]::new); // Short version
		arrayInt = Arrays.stream(integerArray).mapToInt(i -> i).toArray();
		System.out.println(Arrays.toString(arrayInt));


	}

}
