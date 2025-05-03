package com.codingchallanges.array.math;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Facebook Coding interview
 * May 29, 2024
 * <p>
 * Problem 2
 * <p>
 * [[“NY” : “8”],
 * [“CF” : “5”],
 * [“SF” : “7”]]
 * <p>
 * 8/20 = 40%
 * 5/20 = 25%
 * 7/20 =  35%
 * <p>
 * Where 20 is the sum of all weightage 8 +  5 + 7 = 20
 * Implements the function to return the city name, randomly, based on the weightage provided in the table.
 * How you would you avoid the space complexity if the table is provided as an input?
 * <p>
 * String getRandomCity(String[][] cityTable){
 * <p>
 * return "city code"
 * }
 */

public class RandomCity {

    public static void main(String[] args) {

        String[][] cityTable = new String[][]{{"NY", "8"}, {"CH", "5"},{"SF", "7"}};

//        System.out.println("City code = " + getRandomCity(cityTable));
        System.out.println("City code = " + getRandomCityWithoutUsingMap(cityTable));
    }

    private static String getRandomCity(String[][] cityTable){

        Map<Integer, String> map = new TreeMap<>();

        int totalWeightage = 0;

        for(String[] pair : cityTable) {

            totalWeightage += Integer.valueOf(pair[1]);

            map.put(totalWeightage, pair[0]);
        }

        System.out.println(map);
        System.out.println("totalWeightage = " + totalWeightage);

        int randomNumber = (int)(Math.random() * totalWeightage+1);
        System.out.println("randomNumber = " + randomNumber);
        int prevAccumulatedWeightage = 0;

        for(Integer accumulatedWeightage : map.keySet()) {

            if(randomNumber > prevAccumulatedWeightage && randomNumber <= accumulatedWeightage) {
                return map.get(accumulatedWeightage);
            }
            prevAccumulatedWeightage = accumulatedWeightage;
        }
        return "";
    }

    // Avoid use of Map to reduce space complexity
    private static String getRandomCityWithoutUsingMap(String[][] cityTable){

        int totalWeightage = Arrays.stream(cityTable).mapToInt(l -> Integer.parseInt(l[1])).sum();
        System.out.println("totalWeightage = " + totalWeightage);

        int randomNumber = (int)(Math.random() * totalWeightage+1);
        System.out.println("randomNumber = " + randomNumber);

        int accumulatedWeightage = 0;

        for(String[] city : cityTable) {

            int cityWeightage = Integer.valueOf(city[1]);
            int nextAccumulatedWeightage = accumulatedWeightage + cityWeightage;

            if(randomNumber > accumulatedWeightage && randomNumber <= nextAccumulatedWeightage) {
                return city[0];
            }
            accumulatedWeightage = nextAccumulatedWeightage;
        }

        return "";
    }
}
