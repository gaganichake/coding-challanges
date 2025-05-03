package com.codingchallanges.array.histogram;

import com.codingchallanges.stack.Stack;

public class LargestSquareArea {

    // Find area of biggest square in a histogram
    public static int biggestSquareArea(int[] hist) {

        int n = hist.length;
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack s = new Stack();

        int max_area = 0; // Initialize max area
        int top; // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar
        int x, y;

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

                x = hist[top];
                y = (s.isEmpty() ? i : i - s.peek() - 1);
                // Only Square shapes will qualify
                if(x == y) {
                    // Calculate the area with hist[tp] stack as smallest bar
                    area_with_top = x * y;
                    // update max area, if needed
                    if (max_area < area_with_top)
                        max_area = area_with_top;
                }
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.isEmpty()) {
            top = s.peek();
            s.pop();

            x = hist[top];
            y = (s.isEmpty() ? i : i - s.peek() - 1);
            // Only Square shapes will qualify
            if(x == y) {
                area_with_top =  x * y;
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        return max_area;
    }

    public static void main(String[] args) {

        int[] hist = { 2, 4, 16, 7, 6, 2, 10 };
        int[] hist2 = {1,8,6,2,5,4,8,3,7};

        System.out.println("SquareArea = " + biggestSquareArea(hist));
        System.out.println("SquareArea = " + biggestSquareArea(hist2));

    }
}
