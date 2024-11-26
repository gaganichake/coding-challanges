package com.codingchallanges.tree.heap;

import java.util.*;

/*
 * https://www.hackerrank.com/challenges/find-the-running-median/problem
 * CTCI: Number are randomly generated and stored into an (expanding) array. How would you keep track of the median?
 * 
 * You can implement this algorithm using two approaches
 * Approach 1: Sort the array first then find median
 * Approach 2: Using MinHeap & MaxHeap
 */
public class TrackMedian {

	// Approach 2: Using MinHeap & MaxHeap
//	public Integer findMedian(List<Integer> arrayList) {
//
//		MinHeap minHeap = new MinHeap();
//		MaxHeap maxHeap = new MaxHeap();
//
//		for (Integer i : arrayList) {
//
//			minHeap.add(i);
//		}
//
//		// Let's balance both Heaps
//		balanceHeaps(minHeap, maxHeap);
//
//		int median = 0;
//
//		// Find median
//		if (minHeap.size > maxHeap.size) {
//			median = minHeap.peek();
//		} else if (minHeap.size < maxHeap.size) {
//			median = maxHeap.peek();
//		} else {
//			median = (maxHeap.peek() + minHeap.peek()) / 2; // Calculate mean of two
//		}
//
//		return median;
//	}

//	private void balanceHeaps(MinHeap minHeap, MaxHeap maxHeap) {
//
//		while (Math.abs(minHeap.size - maxHeap.size) > 1) {
//			maxHeap.add(minHeap.poll());
//		}
//
//		System.out.println("MinHeap: " + minHeap);
//		System.out.println("MaxHeap: " + maxHeap);
//	}
	
	// Approach 2: Using MinHeap & MaxHeap
	// Using PriorityQueue - Java's in build data structure for Heap
	public double findMedian(List<Integer> arrayList) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

		minHeap.addAll(arrayList);

		// Let's balance both Heaps
		balanceHeaps(minHeap, maxHeap);

		double median;

		// Find median
		if (minHeap.size() > maxHeap.size()) {
			median = minHeap.peek();
		} else if (minHeap.size() < maxHeap.size()) {
			median = maxHeap.peek();
		} else {
			median = (Optional.ofNullable(maxHeap.peek()).orElse(0)
					+ Optional.ofNullable(minHeap.peek()).orElse(0)) / 2.0; // Calculate mean of two
		}

		return median;
	}

	private void balanceHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

		while (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
			maxHeap.add(minHeap.poll());
		}

		System.out.println("MinHeap: " + minHeap);
		System.out.println("MaxHeap: " + maxHeap);
	}	

	public static void main(String[] args) {

		Integer[] a = { 2, 10, 21, 23, 23, 38, 38, 1027892 };
		List<Integer> arrayList = new ArrayList<>(Arrays.asList(a));// Expanding & unsorted array

		System.out.println(arrayList);

		TrackMedian trackMedian = new TrackMedian();

		System.out.println("Median = " + trackMedian.findMedian(arrayList));

	}
}
