package com.codingchallanges.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor/problem
 * <p>
 * Two friends like to pool their money and go to the ice cream parlor. They always choose two distinct flavors and they spend all of their money.
 * Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.
 * <p>
 * Returns the indices of the prices of the two flavors they buy, sorted ascending
 * <p>
 * Example. m = 6, cost = [1, 2, 3, 4, 5
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

                if (menu[i] + menu[j] == m && i != j) {//If there are two ice creams with the same price

                    return new int[]{Math.min(i, j), Math.max(i, j)};
                }
            }
        }

        return null;
    }

    /*
     * Implement using Hash Map and LinkedList
     */
    public static int[] iceCreamParlor2(int[] menu, int m) {

        int[] buyThis = new int[2];

        Map<Integer, LinkedList<Integer>> priceMap = createMap(menu, m);

        int iceCream2 = 0;

        for (Integer iceCream1 : priceMap.keySet()) {

            if (priceMap.containsKey(iceCream2)) {

                buyThis[0] = priceMap.get(iceCream1).getFirst();

                if (iceCream1 == iceCream2) {//If there are two ice creams with the same price
                    buyThis[1] = priceMap.get(iceCream2).getLast();//We just don't want to repeat the first one.
                } else {
                    buyThis[1] = priceMap.get(iceCream2).getFirst();
                }
            }
        }

        return buyThis;
    }

    private static Map<Integer, LinkedList<Integer>> createMap(int[] menu, int money) {

        Map<Integer, LinkedList<Integer>> map = new HashMap<>();//Price -> Indices
        int price;

        for (int i = 0; i < menu.length; i++) {

            price = menu[i];

            // Since we need to buy two ice creams filter out the one that we cannot buy
            if (price >= money) continue;

            if (!map.containsKey(price)) {
                map.put(price, new LinkedList<>());
            }
            map.get(price).add(i);

        }
        return map;
    }

    /*
     * Using sorting and searching
     */
    public static int[] iceCreamParlor3(int[] menu, int m) {

        int[] sortedMenu = menu.clone();

        Arrays.sort(sortedMenu);

        for (int i = 0; i < sortedMenu.length; i++) {

            int complement = m - sortedMenu[i];

            int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);

            if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
                return getIndicesForValue(menu, sortedMenu[i], complement);
            }
        }
        return null;
    }


    private static int[] getIndicesForValue(int[] menu, int value1, int value2) {
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, index1);

        return new int[]{Math.min(index1, index2), Math.max(index1, index2)};
    }

    private static int indexOf(int[] menu, int value, int excludeThis) {

        for (int i = 0; i < menu.length; i++) {

            if (menu[i] == value && i != excludeThis) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

//		int[] menu = { 6, 1, 7, 4, 2 };
        int[] menu = {1, 5, 4, 5, 2};


        System.out.println(Arrays.toString(iceCreamParlor(menu, 10)));
        System.out.println(Arrays.toString(iceCreamParlor2(menu, 10)));
        System.out.println(Arrays.toString(iceCreamParlor3(menu, 10)));
    }
}
