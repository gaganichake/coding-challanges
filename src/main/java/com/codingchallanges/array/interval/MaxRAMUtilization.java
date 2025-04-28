package com.codingchallanges.array.interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * Oracle Coding Interview: Oct/29/2021
 *
 * Calculate the maximum RAM utilization from the following rages
 * [ram, start, end]
 * [1, 0, 2]
 * [1, 1, 4]
 * [1, 1, 3]
 * [4, 5, 6]
 *
 * Also see MergeIntervals: https://leetcode.com/problems/merge-intervals/
 * Also check opposite problem of this problem MeetingRoomsII: https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MaxRAMUtilization {

	public static class Job {
		int ramUsed;
		long startTime;
		long endTime;

		public Job(int ramUsed, long startTime, long endTime) {
			this.ramUsed = ramUsed;
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public String toString() {
			return "Job{" +
					"ramUsed=" + ramUsed +
					", startTime=" + startTime +
					", endTime=" + endTime +
					'}';
		}
	}

	public static class TimeRangeComparator implements Comparator<Job> {

		// Sort by job start time and end time
		@Override
		public int compare(Job o1, Job o2) {

			if (o1.startTime != o2.startTime)
				return Long.compare(o1.startTime, o2.startTime);
			else
				return Long.compare(o1.endTime, o2.endTime);
		}
	}

	public static class RamComparator implements Comparator<Job> {

		@Override
		public int compare(Job o1, Job o2) {

			return Integer.compare(o1.ramUsed, o2.ramUsed);
		}
	}

	public static long maxRAMUtilization(List<Job> jobs) {

		jobs.sort(new TimeRangeComparator());
		System.out.println(jobs);

		LinkedList<Job> mergedJobs = new LinkedList<>();

		for (Job job : jobs) {
			if (mergedJobs.isEmpty() || mergedJobs.getLast().endTime < job.startTime) {
				mergedJobs.add(job);
			} else {
				mergedJobs.getLast().endTime = Math.max(mergedJobs.getLast().endTime, job.endTime);
				mergedJobs.getLast().ramUsed += job.ramUsed;
			}
		}

//		mergedJobs.sort(new RamComparator()); //Option 1
//		mergedJobs.sort((job1, job2) -> (Integer.compare(job1.ramUsed, job2.ramUsed))); //Option 2
		mergedJobs.sort(Comparator.comparingInt(job -> job.ramUsed)); //Option 3
		System.out.println(mergedJobs);

		return mergedJobs.getLast().ramUsed;

	}

	public static void main(String[] args) {

		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1, 0, 2));
		jobs.add(new Job(1, 1, 4));
		jobs.add(new Job(1, 1, 3));
		jobs.add(new Job(4, 5, 6));

		System.out.print(maxRAMUtilization(jobs));

	}

}
