package com.codingchallanges.array.binarysearch;

/*
 * Bitonic Array is an array with increasing values in the beginning and decreasing value at the towards the end.
 * Like a Roller Coaster, Temperature data.
 */
public class BitonicArraySearch {

    public static int findPosition(int[] arr, int x) {
        // find peak
        int pick = findPeak(arr);
        // search to the left of the peak
        int i = binarySearch(arr, x, 0, pick, true);
        // search to the right of the peak
        if(i == -1) i = binarySearch(arr, x, pick, arr.length-1, false);

        return i;
    }

    static int findPeak(int[] arr) {
        int low = 0, high = arr.length - 1;
        // implement this
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] < arr[mid +1])
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }

    static int binarySearch(int[] arr, int x, int low, int high, boolean ascending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (ascending) {
                if (arr[mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // implement the descending binary search logic
                if (arr[mid] > x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -2, 4, 6, 10, 8, 7, 1};
        int x = 7;
        int position = findPosition(arr, x);
        if (position == -1) {
            System.out.println("Element Not Present");
        } else {
            System.out.println("Element Present at Index " + position);
        }
    }
}
