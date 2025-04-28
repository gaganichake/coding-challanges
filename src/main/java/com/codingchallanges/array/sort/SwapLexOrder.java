package com.codingchallanges.array.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * swapLexOrder
 * <a href="https://app.codesignal.com/interview-practice/question/5vXzdE9yzjsoMZ9sk/description">swapLexOrder</a>
 * <p>
 * Given a string str and array of pairs that indicates which indices in the string can be swapped, return the
 * lexicographically largest string that results from doing the allowed swaps. You can swap indices any number of times.
 * <p>
 * Example
 * For str = "abdc" and pairs = [[1, 4], [3, 4]], the output should be
 * <p>
 * solution(str, pairs) = "dbca".
 * <p>
 * By swapping the given indices, you get the strings: "cbda", "cbad", "dbac", "dbca". The lexicographically
 * largest string in this list is "dbca".
 */
public class SwapLexOrder {

    //
    static String solution(String str, int[][] pairs) {

        Arrays.sort(pairs, Comparator.comparingInt(pair -> {
            Arrays.sort(pair);
            return pair[0];
        }));

        List<Set<Integer>> listOfGraph = findConnectedIndices(pairs);
//        System.out.println(listOfGraph);

        StringBuilder stringBuilder = new StringBuilder(str);

        for(Set<Integer> group : listOfGraph) {

            List<Character> chars = group.stream().map(integer -> str.charAt(integer -1)).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//            System.out.println("chars = " + chars);
            int index = 0;
            for(Integer i : group){
                stringBuilder.setCharAt(i-1, chars.get(index));
                index++;
            }
        }

        return stringBuilder.toString();
    }

    private static List<Set<Integer>> findConnectedIndices(int[][]  pairs) {

        List<Set<Integer>> listOfGraph = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] pair : pairs) {

//            System.out.println("pairs = " + Arrays.toString(pair));
//            System.out.println("visited = " + visited);
            if(!visited.contains(pair[0]) & !visited.contains(pair[1])) {
                Set<Integer> group = new HashSet<>();
                group.add(pair[0]);
                group.add(pair[1]);
                listOfGraph.add(group);
            }
            visited.add(pair[0]);
            visited.add(pair[1]);
//            System.out.println("listOfGraph = " + listOfGraph);

            for(Set<Integer> group : listOfGraph){

                if(group.contains(pair[0]) || group.contains(pair[1])) {
                    group.add(pair[0]);
                    group.add(pair[1]);
                }
            }
        }

        return listOfGraph;
    }

    public static void main(String[] args) {

        System.out.println("abdc" + " {{1, 4}, {3, 4}}");
        System.out.println("solution = " + solution("abdc", new int[][]{{1, 4}, {3, 4}}));
        System.out.println("abcdefgh" + " {{1, 4}, {7, 8}}");
        System.out.println("solution = " + solution("abcdefgh", new int[][]{{1, 4}, {7, 8}}));
        System.out.println("acxrabdz" + " {1,3},{6,8},{3,8},{2,7}}");
        System.out.println("solution = " + solution("acxrabdz", new int[][]{{1,3},{6,8},{3,8},{2,7}}));
    }

}
