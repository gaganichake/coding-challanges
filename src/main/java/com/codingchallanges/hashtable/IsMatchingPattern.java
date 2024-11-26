package com.codingchallanges.hashtable;

import java.util.Objects;

/*
 * Facebook Coding interview
 * May 29, 2024
 *
 * Problem 2
 * Pattern = target
 * ———————————
 * i18n = internationalization
 * k8s = kubernatise
 * 8 = Facebook
 * f3b3 = Facebook
 * Computer = Computer
 *
 * String isMatchingPattern(String pattern, String target) {
 *
 * return true or false;
 * }
 */
public class IsMatchingPattern {

    private static boolean isMatchingPattern(String pattern, String target) {

        if(pattern == null
                || pattern.isEmpty()
                || target == null
                || target.isEmpty()) return Objects.equals(pattern, target);

        return comparePattern(pattern, target)
                && comparePattern(new StringBuilder(pattern).reverse().toString(), new StringBuilder(target).reverse().toString());
    }

    private static boolean comparePattern(String pattern, String target) {
        int targetIndex = 0;

        for(int i = targetIndex; i < pattern.length(); i++) {

            if(Character.isDigit(pattern.charAt(i)) && !Character.isDigit(target.charAt(i))){
                String digits = findNumber(pattern.substring(i));
                targetIndex += Integer.parseInt(digits);
                i+=digits.length();
            } else {
                if(pattern.charAt(i) != target.charAt(targetIndex)) return false;
                targetIndex++;
            }
        }
//        System.out.println("targetIndex = " + targetIndex);
        return true;
    }
    private static String findNumber(String substring) {

        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray = substring.toCharArray();
        for(char ch : charArray){
            if (Character.isDigit(ch))
                stringBuilder.append(ch);
            else
                break;;
        }
       return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println("true : " + isMatchingPattern("i18n", "internationalization"));
        System.out.println("true : " + isMatchingPattern("k8s", "kubernetes"));
        System.out.println("true : " + isMatchingPattern("8", "facebook"));
        System.out.println("true : " + isMatchingPattern("f3b3", "facebook"));
        System.out.println("true : " + isMatchingPattern("facebook", "facebook"));
        System.out.println("false : " + isMatchingPattern("Facebook", "facebook"));
        System.out.println("false : " + isMatchingPattern("", "computer"));
        System.out.println("false : " + isMatchingPattern("computer", ""));
        System.out.println("true : " + isMatchingPattern("9", "9"));
        System.out.println("true : " + isMatchingPattern("18", "18"));
        System.out.println("true : " + isMatchingPattern("i18n", "i18n"));
        System.out.println("true : " + isMatchingPattern("i18nz", "i18nz"));
        System.out.println("false : " + isMatchingPattern("i18n", "i18nz")); // this test cases requires reverse String comparison.
    }

}
