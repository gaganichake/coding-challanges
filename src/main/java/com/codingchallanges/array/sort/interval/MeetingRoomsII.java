package com.codingchallanges.array.sort.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 *
 * Also check opposite problem of this problem: https://leetcode.com/problems/merge-intervals/
 */
public class MeetingRoomsII {

    private static class IntervalsComparator implements Comparator<int[]>{

    	// Sort by starting number
        @Override
        public int compare(int[] a, int[] b){

        	if(a[0] < b[0]) {
        		return -1;
        	} else if(a[0] > b[0]) {
        		return 1;
        	} else {
        		return Integer.compare(a[1], b[1]);
        	}
        }
    }
	/*
	 * The basic concept of this algorithm is that a meeting room can be used again only
	 * if a previously running meeting has ended
	 */
	public static int minMeetingRooms(int[][] intervals) {

		if (intervals.length == 0) {
			return 0;
		}

		Integer[] startTimes = new Integer[intervals.length];
		Integer[] endTimes = new Integer[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			startTimes[i] = intervals[i][0];
			endTimes[i] = intervals[i][1];
		}

		Arrays.sort(startTimes);
		Arrays.sort(endTimes);

		int rooms = 0;
		int end = 0;

		for (Integer startTime : startTimes) {

			rooms++;// room occupied

			// if a previously running meeting as ended
			if (startTime >= endTimes[end]) {// This will not be true in the first iteration
				end++;// because a previous meeting has ended
				rooms--;// now I can use this room
			}
		}
		return rooms;
	}

	// This more generic and better approach
    public static int minMeetingRoomsV2(int[][] intervals) {

    	int rooms = 0;

        Arrays.sort(intervals, new IntervalsComparator());

        int start = 0, end = 1;

        LinkedList<int[]> mergedIntervals = new LinkedList<>();

        for(int[] interval : intervals){

        	rooms++;

            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[end] <= interval[start]){
            	mergedIntervals.add(interval);
                rooms--;
            } else {
            // otherwise, there is an overlap, so we merge the current and
            // previous intervals.
            	mergedIntervals.getLast()[end] = Math.max(mergedIntervals.getLast()[end], interval[end]);
            }
        }
        return rooms;
    }

	public static void main(String[] args) {
//		int[][] intervals = { {0, 30 }, {5, 10 }, {15, 20}};
		int[][] intervals = { {7, 10}, {2, 4 } };

		System.out.println(minMeetingRooms(intervals));
		System.out.println(minMeetingRoomsV2(intervals));
	}

}
