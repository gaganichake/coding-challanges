package com.codingchallanges.array.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/min-partitions">Min Partitions</a>
 * <p>
 * 2, 4, 0, 3, 1
 * 5, 2, 5, 6
 * <p>
 * 2 + 4 + 0 + 3 + 1 = 10
 * <p>
 * 5 + 2 + 5 + 6 = 18
 * <p>
 * Answer: 3
 *
 * <p>
 * <a href="https://www.geeksforgeeks.org/minimum-number-of-partitions-to-allocate-space-in-partitions/">Minimum number of partitions to allocate space in partitions</a>
 * <p>
 *
 * Asked by Walmart on 12/10/2024
 * <p>
 * Consolidating partitions program, returns the minimum partitions by allocating the space to the partitions.
 * used list contains the space used in the partitions and
 * capacity list shows the capacity of the partitions.
 */
public class MinPartitions {

    public static void main(String[] args) {

        System.out.println(minPartitions(Arrays.asList(2, 4, 0, 3, 1), Arrays.asList(5, 2, 5, 6)));
        System.out.println(minPartitions(Arrays.asList(2, 4, 1, 3, 1), Arrays.asList(3, 5, 2, 4, 5)));
    }

    /*
     * Complete the 'minPartitions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY used
     *  2. INTEGER_ARRAY totalCapacity
     */
    private static int minPartitions(List<Integer> used, List<Integer> totalCapacity) {

        int totalUsed = used.stream().reduce(0, Integer::sum);
        totalCapacity.sort(Collections.reverseOrder()); // Sort in descending order

        int count = 0;

        for (int partition : totalCapacity) {

            totalUsed -= partition;
            count++;
            if (totalUsed <= 0) {
                break;
            }
        }
        return count;
    }
}
