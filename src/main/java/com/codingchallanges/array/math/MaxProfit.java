package com.codingchallanges.array.math;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve
 * any profit, return 0.
 *
 * Example:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before
 * you sell.
 */
public class MaxProfit {

	// Approach 1: Brute Force (Two pass). Time: O(n*n)
    public static int maxProfit(int[] prices) {

        int maxprofit = 0;

        for (int i = 0; i < prices.length - 1; i++) {

            for (int j = i + 1; j < prices.length; j++) {

                int profit = prices[j] - prices[i];

                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

	// Approach 2: One Pass.  Time: O(n)
    public static int maxProfit2(int[] prices) {

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int price : prices) {

            if (price < minprice)
                minprice = price;//tracking smallest element
            else {
                int profit = price - minprice;
                if (profit > maxprofit) maxprofit = profit;//tracking max profit
            }
        }
        return maxprofit;
    }

    // Approach 3: One Pass.  Time: O(n)
    public static int maxProfit3(int[] prices) {

        int buyAt = Integer.MAX_VALUE;
        int sellAt = 0;

        for(int price : prices) {

            if(price < buyAt){
                buyAt = price; // When lower buying price found
                sellAt = price; // rest to current price
            }
            if(price > sellAt) sellAt = price; // track the largest selling price
        }

        return Math.max(sellAt - buyAt, 0);
    }

	public static void main(String[] args) {
//		int[] prices = {7,1,5,3,6,4};
		int[] prices = {7,6,4,3,1};
		System.out.println(maxProfit2(prices));

	}

}
