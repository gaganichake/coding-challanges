package com.codingchallanges.graph.dfs;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/find-the-celebrity/
 */
public class FindACelebrity {

	// A Matrix representation of graph
	private static final HashMap<Integer, Integer> edges = new HashMap<>();

	// Where n is the number of celebrities
    public static int findCelebrity(int n) {
        for (int i = 1; i <= n; i++) {
            if (isCelebrity(i, n)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isCelebrity(int i, int n) {
        for (int j = 1; j <= n; j++) {
            if (i == j) continue; // Don't ask if they know themselves.
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }

    /*
     * This is a predefined method.
	 * [1, 2]
	 * [1, 3]
	 * [3, 4]
	 * [4, 2]
	 * [3, 2]
     */
	private static boolean knows(int guest, int j) {
		return (edges.containsKey(guest) && edges.get(guest) == j);
	}

	public static void main(String[] args) {

		edges.put(1, 2);
		edges.put(3, 4);
		edges.put(4, 2);

		System.out.println(findCelebrity(4));

	}

}
