package com.codingchallanges.tree.heap;

import java.util.Arrays;

/*
 * This is a Min Heap implementation using Array
 * 
 * https://www.hackerrank.com/challenges/qheap1/problem
 * 
 * A Min Heap is a Binary Tree where a parent node is always smaller than its child nodes.
 * 
 * The last element of the tree (array) is not necessarily the biggest element.
 * 
 *                               3(0)
 *                      /                     \
 *                     /                       \
 *                    /                         \
 *                  4[1]                        5[2]
 *               /        \                 /          \
 *              /          \               /            \
 *            6[3]         9[4]           10[5]          13[6]
 *           /   \      /         \    /         \     /      \
 *       14[7]   18[8] 17[9]  30[10]  15[11]  20[12]  30[13]   21[14] 
 */
public class MinHeap {

	int capacity = 10;// Max size
	int size = 0; // This is current size on the heap.

	int[] items = new int[capacity];

	void ensureCapacitiy() {

		if (size == capacity) {
			capacity = capacity * 2;
			items = Arrays.copyOf(items, capacity);
		}
	}

	private int getLeftChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return parentIndex * 2 + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}

	private boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) < size;
	}

	private boolean hasParent(int childIndex) {
		return getParentIndex(childIndex) >= 0;
	}

	private int getLeftChild(int parentIndex) {
		return items[getLeftChildIndex(parentIndex)];
	}

	private int getRightChild(int parentIndex) {
		return items[getRightChildIndex(parentIndex)];
	}

	private int getParent(int childIndex) {
		return items[getParentIndex(childIndex)];
	}

	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	// Get the minimal element from the heap
	public int peek() {

		if (size == 0)
			throw new IllegalStateException();

		return this.items[0];
	}

	/*
	 * Remove the minimal element from the heap
	 */
	public int poll() {

		if (size == 0)
			throw new IllegalStateException();

		int minItem = items[0];

		items[0] = items[size - 1];

		size--;

		heapifyDown();

		return minItem;
	}

	private void heapifyDown() {

		int parentIndex = 0;

		while (hasLeftChild(parentIndex)) {

			int smallerIndex = getLeftChildIndex(parentIndex);

			if (hasRightChild(parentIndex) && getRightChild(parentIndex) < getLeftChild(parentIndex)) {

				smallerIndex = getRightChildIndex(parentIndex);
			}

			if (items[parentIndex] > items[smallerIndex]) {
				swap(parentIndex, smallerIndex);
			} else {
				break;
			}
			parentIndex = smallerIndex;
		}
	}

	public void add(int item) {

		ensureCapacitiy();

		items[size] = item;

		size++;

		heapifyUp();
	}

	private void heapifyUp() {

		int index = size - 1;

		while (hasParent(index) && getParent(index) > items[index]) {

			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}

	public String toString() {
		StringBuilder txt = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			txt.append(items[i]);
			if (i < size - 1)
				txt.append(", ");
		}
		txt.append("]");
		return txt.toString();
	}
	
	public static void main(String[] args) {

		MinHeap minHeap = new MinHeap();

		minHeap.add(10);
		minHeap.add(15);
		minHeap.add(20);
		minHeap.add(17);

		System.out.println(minHeap);

		minHeap.add(8);

		System.out.println(minHeap);

		minHeap.poll();

		System.out.println(minHeap);

		minHeap.add(25);

		System.out.println(minHeap);

		minHeap.poll();

		System.out.println(minHeap);
	}
}
