package com.codingchallanges.hashmap;

import java.util.ArrayList;
import java.util.List;
/**
 * Task Statement
 * • Array with at most 1000 elements
 * • Millions of queries possible
 * • Each query: pair of integers 1 and r
 * • Goal: Return the minimum value in array between 1 and r
 * • Example input: arr = {2, 1, 3, 7, 53, Ls = £0, 2, 43, Rs = 11, 3, 4}
 * • Based on the input, queries are [0, 11], [2, 3], and [4, 4]
 * • Expected output: {1, 3, 5}
 * <p>
 *  Techniques: Skipping Redundant Cases, Optimization Using Precalculation, and Picking the Best Variable to Iterate Over
 * <p>
 *  Our task here involves an array composed of at most 1,000 elements and potentially millions of queries.
 *  Each query is a pair of integers denoted as l and r, which correspond to some indices in the array.
 *  Your goal is to write a Java method that, for each query, returns the minimum value in the array between indices l and r (inclusive).
 * <p>
 *  The catch is this: rather than directly finding the minimum value for each query one by one, we're required to optimize
 *  the process. The idea here is to precalculate the minimum value for each possible l and r, store these values, and
 *  then proceed with the queries. This way, we can simplify the problem and enhance the speed of our solution by eliminating
 *  redundant computations.
 *  <p></p>
 *  The method will accept three parameters: arr, Ls, and Rs. The primary array is arr, while Ls and Rs are ArrayLists that
 *  hold the l and r values respectively for each query.
 */
public class RangMinimumQuery {

    public static List<Integer> rangMinimumQuery(int[] arr, List<Integer> Ls, List<Integer> Rs) {
        int n = arr.length;
        int[][] precalc = new int[n][n];
        for (int l = 0; l < n; ++l) {
            int minVal = arr[l];
            for (int r = l; r < n; ++r) {
                minVal = Math.min(minVal, arr[r]);
                precalc[l][r] = minVal;
            }
        }
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < Ls.size(); ++i) {
            int l = Ls.get(i);
            int r = Rs.get(i);
            res.add(precalc[l][r]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 7, 5};
        List<Integer> Ls = new ArrayList<>();
        List<Integer> Rs = new ArrayList<>();

        Ls.add(0);
        Rs.add(1);
        Ls.add(2);
        Rs.add(3);
        Ls.add(4);
        Rs.add(4);

        List<Integer> result = rangMinimumQuery(arr, Ls, Rs);

        for (int val : result) {
            System.out.println(val);
        }
    }
}
