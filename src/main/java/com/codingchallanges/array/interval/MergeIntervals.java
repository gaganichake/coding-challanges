package com.codingchallanges.array.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * MergeIntervals
 *
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given an array of intervals where intervals[i] = [start, end],
 * merge all overlapping intervals, and return an array of the
 * non-overlapping intervals that cover all the intervals in the input.
 *
 * Also check MeetingRoomsII: https://leetcode.com/problems/meeting-rooms-ii/
 * Also check MaxRAMUtilization
 */
public class MergeIntervals {

	private static class IntervalsComparator implements Comparator<int[]> {

		// Sort by job start time and end time
		@Override
		public int compare(int[] a, int[] b) {

			if (a[0] != b[0])
				return Integer.compare(a[0], b[0]);
			else
				return Integer.compare(a[1], b[1]);
		}
	}

	public static int[][] merge(int[][] intervals) {

		Arrays.sort(intervals, new IntervalsComparator());

		int start = 0, end = 1;

		LinkedList<int[]> mergedIntervals = new LinkedList<>();

		for (int[] interval : intervals) {

			// if the list of merged intervals is empty or if the current
			// interval does not overlap with the previous, simply append it.
			if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[end] < interval[start]) {
				mergedIntervals.add(interval);
			} else {
				// otherwise, there is an overlap, so we merge the current and
				// previous intervals.
				mergedIntervals.getLast()[end] = Math.max(mergedIntervals.getLast()[end], interval[end]);
			}
		}
		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
	}

	public static void main(String[] args) {

//		int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};// Output: [[1,6],[8,10],[15,18]]
		int[][] intervals = { { 1, 4 }, { 4, 5 } };// Output: [[1,5]]
//		int[][] intervals = {{5, 7}, {2, 3}, {7, 9}, {1, 4}, {8, 8}, {9, 5}, {5, 6}, {2, 4}, {7, 8}, {2, 3}};// Expected output: [[1, 4], [5, 9]]

		int[][] output = merge(intervals);

		for (int[] a : output) {
			System.out.println(Arrays.toString(a));
		}
	}
}
