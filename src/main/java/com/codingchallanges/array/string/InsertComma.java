package com.codingchallanges.array.string;

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
   String = "AS123-asdmnas-123lasdknw13==121232"
   int [] = [4, 5, 2, 10, 2, 6, 8]
 * <p>
Output: "AS12,3-asd,mn,as-123lasd,kn,w13==1,21232"
 */
public class InsertComma {

    public static void main(String[] args) {

        System.out.println(solution("AS123-asdmnas-123lasdknw13==121232139sdmjlasd12321llall123213213klasdlasdsadas",
                new int[]{4, 5, 2, 10, 2, 6, 8}));
        System.out.println(solution("AS123-asdmnas-123lasdknw13==121232",
                new int[]{4, 5, 2, 10, 2, 6, 8}));

    }

    private static String solution(String str, int[] offsets) {

        StringBuffer sb = new StringBuffer();

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
