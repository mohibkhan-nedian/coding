package com.Arrays;

import java.util.Arrays;

public class WindowAverage {
    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= K - 1) {
                //3 steps always when windowEnd is over K
                result[windowStart] = windowSum / K; // 1. calculate the average
                windowSum -= arr[windowStart]; // 2. subtract the element going out
                windowStart++; // 3.  slide the window ahead
            }
        }

        return result;
    }

    public static void main(String[] args) {
        double[] result = findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
