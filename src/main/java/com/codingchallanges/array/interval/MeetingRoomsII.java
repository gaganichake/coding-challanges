package com.codingchallanges.array.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * How many meeting rooms are required for given meeting schedule requests?
 *
 * The basic concept of this algorithm is that a meeting room can be used again only if the previously
 *  running meeting has ended. Conflicting (overlapping) meetings will require separate rooms.
 *
 * Also check opposite problem: MaxRAMUtilization
 */
public class MeetingRoomsII {

    private static class IntervalsComparator implements Comparator<int[]>{


        @Override
        public int compare(int[] a, int[] b){

			if (a[0] != b[0])
				return Integer.compare(a[0], b[0]); // Sort by starting number
			else
				return Integer.compare(a[1], b[1]); // As well as ending number
        }
    }

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

    	int rooms = intervals.length; // Maximum rooms required if all intervals overlap.

        Arrays.sort(intervals, new IntervalsComparator());

        int start = 0, end = 1;

        LinkedList<int[]> mergedIntervals = new LinkedList<>();

        for(int[] interval : intervals){
			System.out.println("rooms = " + rooms);
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
//		int[][] intervals = { {0, 30}, {5, 10}, {15, 20} };
		int[][] intervals = { {7, 10}, {2, 4} };

		System.out.println(minMeetingRooms(intervals));
		System.out.println(minMeetingRoomsV2(intervals));
	}

}
