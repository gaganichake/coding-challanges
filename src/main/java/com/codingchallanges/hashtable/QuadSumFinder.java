package com.codingchallanges.hashtable;

import java.util.*;

/**
 * You have to write a Java function that accepts a list of distinct integers and a target sum as input.
 * The aim is to identify exactly four numbers in the list that, when summed, equal this target.
 * Should there be multiple sets that meet this condition, your function should return any one of them.
 * If no such quad exists, the function should return an empty list.
 * Consider this list as an example: [5, 15, 2, 7, 8, 4]. If your target sum is 24, a four-number set that
 * adds up to this value could be [5, 7, 4, 8].
 * The input list will contain at least 4 and at most 1,000 distinct integers.
 * There is a time limit for the solution to evaluate within 3 seconds.
 <p>
 * The simplest solution is the brute-force solution that iterates over every quadruple of numbers in the list.
 * Obviously, the complexity of this solution is O(n^4), which is not acceptable for n = 1000.

 * Assuming that performing an elementary operation in Java can take around 100 nanoseconds, if we have a list
 * of a thousand distinct integers, the total time to perform our O(n^4) operation on our list would be around
 * 100 * 1000^4 = 10^14 nanoseconds, which is over 27 hours. This is definitely not an optimal solution.
 * <p>
 * This class provides a method to find four distinct numbers in a list that sum up to a given target.
 * It uses a HashMap to store the sums of pairs of numbers and checks for complementary pairs.
 *  The algorithm works by:
 *  1. Iterating through all pairs of numbers in the list and storing their sums in a HashMap.
 *  2. For each sum, it checks if the complement (targetSum - sum) exists in the HashMap.
 *  3. If it does, it retrieves the pairs corresponding to both sums and checks for distinct indices.
 *  4. If valid pairs are found, it returns the four numbers as a list.
 */

public class QuadSumFinder {
    public static List<Integer> findQuadSum(int targetSum, List<Integer> numbers) {
        int length = numbers.size();
        Map<Integer, List<int[]>> sumMap = new HashMap<>();

        // Step 2: Populate the HashMap with the sums of all pairs
        for (int i = 0; i < length - 1; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int pairwiseSum = numbers.get(i) + numbers.get(j);
                sumMap.computeIfAbsent(pairwiseSum, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        // Step 3: Iterate over the sums
        for (int sum : sumMap.keySet()) {
            int complement = targetSum - sum;
            if (sumMap.containsKey(complement)) {
                List<int[]> pairs1 = sumMap.get(sum);
                List<int[]> pairs2 = sumMap.get(complement);

                for (int[] pair1 : pairs1) {
                    for (int[] pair2 : pairs2) {
                        int a = pair1[0], b = pair1[1];
                        int c = pair2[0], d = pair2[1];

                        // Ensure all indices are distinct
                        if (a != c && a != d && b != c && b != d) {
                            return Arrays.asList(numbers.get(a), numbers.get(b), numbers.get(c), numbers.get(d));
                        }
                    }
                }
            }
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 15, 2, 7, 8, 4);
        int target = 24;
        System.out.println(findQuadSum(target, numbers));
    }
}
