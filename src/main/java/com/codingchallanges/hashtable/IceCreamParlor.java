package com.codingchallanges.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor/problem
 * <p>
 * Two friends like to pool their money and go to the ice cream parlor. They always choose two distinct flavors and they spend all of their money.
 * Given a list of prices for the flavors of ice cream, select the two that will cost all the money they have.
 * <p>
 * Returns the indices of the prices of the two flavors they buy, sorted ascending
 * <p>
 * Example. m = 6, cost = [1, 2, 3, 4, 5]
 * The two flavors that cost  and  meet the criteria. Using -based indexing, they are at indices  1 and 4 .]
 * <p>
 * https://www.youtube.com/watch?v=Ifwf3DBN1sc
 * <p>
 * https://www.youtube.com/watch?v=shs0KM3wKv8
 * <p>
 * Compare with https://leetcode.com/problems/two-sum/
 */
public class IceCreamParlor {

    /*
     *
     * -- Example 1
     * 6
     * {1,3,4,5,6}
     *
     * [1,3] [1,4] [1,5] [1,6] >>> [1, 5]
     *
     * [3,4] [3,5] [3,6]
     *
     * [4,5] [4,6]
     *
     * [5,6]
     *
     * [1, 4]
     *
     * -Example 2----------
     *
     * 10
     *
     * {2, 4, 8, 9, 3, 6, 1, 7, 5, 10} {1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     *
     * 2,4 2,8 >> 2,9 2,3 2,6 2,1 2,7 2,5 2,10
     *
     * 4,8 4,9 4,3 4,6 >>>> 4,1 4,7 4,5 4,10
     *
     * 8,9 8,6 8,1, 8,7 8,5 8,10
     *
     * 9,3 9,1>>> 9,7 9,5 9,10
     *
     * 3,6 3,1 3,7>>> 3,6 3,10
     *
     * 6,1 6,7 6,5 6,10
     *
     * 1,7 1,5 1,10
     *
     * 7,5 7,10
     *
     * 5,10
     *
     * [2, 8][4,6][9,1][3,7] [1, 3][2,6][4,7][5,8]
     */

    /*
     * Brute force approach
     * Time complexity: O(n pow 2)
     * Time complexity: O(n)
     */
    public static int[] iceCreamParlor(int[] menu, int m) {

        for (int i = 0; i < menu.length; i++) {

            for (int j = 0; j < menu.length; j++) {

                if (menu[i] + menu[j] == m && i != j) {//They always choose two distinct flavors

                    int[] result = {i , j};
                    Arrays.sort(result);
                    return result;
                }
            }
        }

        return null;
    }

    /*
     * BEST SOLUTION
     * Implement using Hash Map
     */
    public static int[] iceCreamParlor2(int[] menu, int m) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < menu.length; i++){
            if(menu[i] < m) map.put(menu[i],i); //Price of each ice cream must less than total money in pocket.
        }

        int iceCream2 = 0;

        for (Integer iceCream1 : map.keySet()) {

            iceCream2 = m - iceCream1;

            if(map.containsKey(iceCream2)){

                int[] result = new int[]{map.get(iceCream1), map.get(iceCream2)};
                Arrays.sort(result);
                return result;
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {

		int[] menu = { 6, 1, 7, 4, 2 };
//        int[] menu = {1, 5, 4, 5, 2};

        System.out.println(Arrays.toString(iceCreamParlor(menu, 10)));
        System.out.println(Arrays.toString(iceCreamParlor2(menu, 10)));

    }
}
