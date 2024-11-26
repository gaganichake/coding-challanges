package com.codingchallanges.hashtable;

import java.util.*;

/*
https://app.codesignal.com/interview-practice/question/rMe9ypPJkXgk3MHhZ/description

You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in it. You want to know how many distinct sums you can make from non-empty groupings of these coins.

Example

For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
solution(coins, quantity) = 9.

Here are all the possible sums:

50 = 50;
10 + 50 = 60;
50 + 100 = 150;
10 + 50 + 100 = 160;
50 + 50 = 100;
10 + 50 + 50 = 110;
50 + 50 + 100 = 200;
10 + 50 + 50 + 100 = 210;
10 = 10;
100 = 100;
10 + 100 = 110.
As you can see, there are 9 distinct sums that can be created from non-empty groupings of your coins.
 */
public class PossibleSums {

    public static void main(String[] arg) {

        System.out.println(solution(new int[]{10, 50, 100}, new int[]{1, 2, 1}));

    }

    //TODO
    static int solution(int[] coins, int[] quantity) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int[] allCoins = new int[Arrays.stream(quantity).sum()];

        for(int i = 0; i < coins.length; i++) {

            for(int j = 0; j < quantity.length; j++, i++) {
                allCoins[i] = coins[i];
            }
        }

        for(int i = 0; i < coins.length; i++) {

            int n = map.get(coins[i]);
            sum += coins[i];

            for(int j = i+1; j < coins.length; j++) {

                for(int k = 0; k < n-1; k++) {
                    j = i;
                }
                sum += coins[j];
                if(!set.contains(sum)) {
                    set.add(sum);
                }
            }
            sum = 0;
        }

        return set.size();
    }
}
