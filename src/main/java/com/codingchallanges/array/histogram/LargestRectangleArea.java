package com.codingchallanges.array.histogram;

import java.util.Stack;

/**
 * histogramSquareArea
 * <p>
 * CodeSignal
 * <p>
 * <a href="https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/">.largest-rectangular-area-in-a-histogram-set-1</a>
 * <a href="https://www.geeksforgeeks.org/largest-rectangle-under-histogram/">largest-rectangle-under-histogram</a>
 */
public class LargestRectangleArea {

    // The function to find the maximum rectangular area under given
    // histogram with n bars
    public static int largestRectangleArea(int[] hist) {

        int n = hist.length;
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int top = -1; // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.isEmpty() || hist[s.peek()] <= hist[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else {
                top = s.peek(); // store the top index
                s.pop(); // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[top] * (s.isEmpty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
            System.out.println(s + ", i = " + i + ", top = " + top);
        }
        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.isEmpty()) {
            top = s.peek();
            s.pop();

            area_with_top = hist[top] * (s.isEmpty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;

    }

    // more simplified
    public static int largestRectangleArea2(int[] ht) {
        int n = ht.length;
        if (n == 1) return ht[0];
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int area = 0;
        while (i < n) {
            if (st.isEmpty() || ht[st.peek()] <= ht[i]) {
                st.push(i++);
            } else {
                int top = st.pop();
                int tempArea = ht[top] * (st.isEmpty() ? i : i - st.peek() - 1);
                if (area < tempArea) area = tempArea;
            }
        }
        while (!st.isEmpty()) {
            int top = st.pop();
            int tempArea = ht[top] * (st.isEmpty() ? i : i - st.peek() - 1);
            if (area < tempArea) area = tempArea;
        }
        return area;
    }

    public static void main(String[] args) {

        int[] hist = {2, 4, 16, 7, 6, 2, 10};
        int[] hist2 = {1,8,6,2,5,4,8,3,7};

        // Expected output 4 x 4 = 16
        System.out.println("RectangleArea = " + largestRectangleArea(hist2));
        System.out.println("RectangleArea = " + largestRectangleArea2(hist2));

    }

}
