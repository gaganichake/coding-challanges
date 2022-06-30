package com.codingchallanges.tree.heap;

import java.util.Arrays;

/*
 * This is a Max Heap implementation using Array
 *
 * A Max Heap is a Binary Tree where a parent node is always bigger than its child nodes.
 *
 * The last element of the tree (array) is not necessarily the smallest element.
 *
 *                               30(0)
 *                      /                     \
 *                     /                       \
 *                    /                         \
 *                  21[1]                      20[2]
 *               /        \                 /         \
 *              /          \               /           \
 *            18[3]         17[4]        15[5]          14[6]
 *           /   \      /         \   /         \   /      \
 *       11[7]   10[8] 17[9]  9[10]  7[11]  6[12]  4[13]   2[14]
 */
public class MaxHeap {

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

	public int peek() {

		if (size == 0)
			throw new IllegalStateException();

		return this.items[0];
	}

	/*
	 * Remove the maximum element from the heap
	 */
	public int poll() {

		if (size == 0)
			throw new IllegalStateException();

		int maxItem = items[0];

		items[0] = items[size - 1];

		size--;

		heapifyDown();

		return maxItem;
	}

	private void heapifyDown() {

		int parentIndex = 0;

		while (hasLeftChild(parentIndex)) {

			int biggerIndex = getLeftChildIndex(parentIndex);

			if (hasRightChild(parentIndex) && getRightChild(parentIndex) > getLeftChild(parentIndex)) {

				biggerIndex = getRightChildIndex(parentIndex);
			}

			if (items[parentIndex] < items[biggerIndex]) {
				swap(parentIndex, biggerIndex);
			} else {
				break;
			}
			parentIndex = biggerIndex;
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

		while (hasParent(index) && getParent(index) < items[index]) {

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

		MaxHeap maxHeap = new MaxHeap();

		maxHeap.add(10);
		maxHeap.add(15);
		maxHeap.add(20);
		maxHeap.add(17);

		System.out.println(maxHeap);

		maxHeap.add(8);

		System.out.println(maxHeap);

		maxHeap.poll();

		System.out.println(maxHeap);

		maxHeap.add(25);

		System.out.println(maxHeap);

		maxHeap.poll();

		System.out.println(maxHeap);
	}
}
