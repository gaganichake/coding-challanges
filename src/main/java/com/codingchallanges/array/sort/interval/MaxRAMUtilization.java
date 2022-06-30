package com.codingchallanges.array.sort.interval;

import java.util.*;

/*
 * Oracle Coding Interview: Oct/29/2021
 *
 * Calculate the maximum CPU utilization from the following rages
 * [ram, start, end]
 * [1, 0, 2]
 * [1, 1, 4]
 * [1, 1, 3]
 * [4, 5, 6]
 *
 * Also see MergeIntervals: https://leetcode.com/problems/merge-intervals/
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
	}

	public static class JobTimeComparator implements Comparator<Job> {

		// Sort by job start time and end time
		@Override
		public int compare(Job o1, Job o2) {

			if (o1.startTime < o2.startTime) {
				return -1;
			} else if (o1.startTime > o2.startTime) {
				return 1;
			} else {
				return Long.compare(o1.endTime, o2.endTime);
			}
		}
	}

	public static class JobRamComparator implements Comparator<Job> {

		@Override
		public int compare(Job o1, Job o2) {

			return Integer.compare(o1.ramUsed, o2.ramUsed);
		}
	}

	public static long maxRAMUtilization(List<Job> jobs) {

		jobs.sort(new JobTimeComparator());

		LinkedList<Job> mergedJobs = new LinkedList<>();

		for (Job job : jobs) {

			if (mergedJobs.isEmpty() || mergedJobs.getLast().endTime < job.startTime) {
				mergedJobs.add(job);
			} else {
				mergedJobs.getLast().endTime = Math.max(mergedJobs.getLast().endTime, job.endTime);
				mergedJobs.getLast().ramUsed += job.ramUsed;
			}
		}

		mergedJobs.sort(new JobRamComparator());

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
