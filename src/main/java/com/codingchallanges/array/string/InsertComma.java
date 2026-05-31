package com.codingchallanges.array.string;

import java.util.Arrays;

/**
Given a String and Array of Integer, Insert comma to the string based on the Array.
 * <p>
For Example:
 * <p>
   String = "AS123-asdmnas-123lasdknw13==121232139sdmjlasd12321llall123213213klasdlasdsadas"
   int [] = [4, 5, 2, 10, 2, 6, 8]
Output: "AS12,3-asd,mn,as-123lasd,kn,w13==1,21232139,sdmjlasd12321llall123213213klasdlasdsadas"
 * <p>
Another Example:
 * <p>
   String = "AS123-asdmnas-123lasdknw13==21232139"
   int [] = [4, 5, 2, 10, 2, 6, 8]
 * <p>
Output: "AS12,3-asd,mn,as-123lasd,kn,w13==1,21232139,"
 */
public class InsertComma {

    public static void main(String[] args) {

//        System.out.println(solution2("AS123-asdmnas-123lasdknw13==121232139sdmjlasd12321llall123213213klasdlasdsadas",
//                new int[]{4, 5, 2, 10, 2, 6, 8}));
        System.out.println(solution2("AS123-asdmnas-123lasdknw13==21232139",
                new int[]{4, 5, 2, 10, 2, 6, 8}));

    }
    private static String solution2(String str, int[] offsets) {

        char[] src = str.toCharArray();
        char[] dest = new char[str.length()+offsets.length];

        int totalOffset = 0;

        for (int i = 0; i < offsets.length; i++) {
            System.out.println(totalOffset + ", " + (totalOffset+i) + ", " + (totalOffset + offsets[i]));
            System.arraycopy(src, totalOffset, dest, totalOffset+i, totalOffset + offsets[i]);

            totalOffset = totalOffset + offsets[i];
            dest[totalOffset + i] = ',';
            System.out.println(new String(dest));
        }
        System.out.println(totalOffset + ", " + (totalOffset+offsets.length) + ", " + (str.length() - totalOffset));
        if(totalOffset < src.length) {
            System.arraycopy(src, totalOffset, dest, totalOffset+offsets.length, str.length() - totalOffset);
        }

        return new String(dest);
    }

    private static String solution(String str, int[] offsets) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < offsets.length; i++){

            int offset = offsets[i];
            int start = sb.length() - i;
            int end = sb.length()+offset;

            if(end < str.length()) {
                sb.append(str, start, end);
                sb.append(",");
            }
        }

        if(sb.length()-offsets.length < str.length()){
            sb.append(str,sb.length()-offsets.length, str.length());
        }

        return offsets.length == 0 ? str : sb.toString();
    }
}
