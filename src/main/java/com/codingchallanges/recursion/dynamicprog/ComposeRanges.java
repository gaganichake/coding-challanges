package com.codingchallanges.recursion.dynamicprog;

import java.util.ArrayList;
import java.util.List;

/**
 * composeRanges
 * https://app.codesignal.com/interview-practice/task/cHYqbQ9DiWmejAdeG/description
 *
 * Given a sorted integer array that does not contain any duplicates, return a summary of the number ranges it contains.
 *
 * Example
 *
 * For nums = [-1, 0, 1, 2, 6, 7, 9], the output should be
 * solution(nums) = ["-1->2", "6->7", "9"].
 *
 */
public class ComposeRanges {

    String[] solution(int[] nums) {

        if(nums.length == 0) return new String[0];

        List<String> result = new ArrayList<>();

        int startRange = nums[0];

        for(int i = 1; i < nums.length; i++){

            if(Math.abs(nums[i] - nums[i - 1]) > 1) {
                result.add(createItem(startRange, nums[i - 1]));
                startRange = nums[i];
            }
        }

        result.add(createItem(startRange, nums[nums.length - 1]));

        return result.toArray(new String[0]);
    }

    private String createItem(int item1, int item2){
        return item1 == item2 ? (item1 + "") : (item1 + "->" + item2);
    }

}
