package com.Sorting;

public class MergeSort {

    //https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2897/

    static int[] temp;

    public static int[] mergeSort(int[] array) {
        // Write your code here.
        temp = new int[array.length];
        mergeSort(array, 0, array.length-1);
        return array;
    }

    static void mergeSort(int[] array, int leftStart, int rightEnd){
        if(leftStart >= rightEnd) {
            return;
        }
        //find mid point to break
        int middle = (leftStart + rightEnd)/ 2;

        //solve halves first
        mergeSort(array, leftStart, middle);
        mergeSort(array, middle + 1, rightEnd);

        //merge haves from leftStart to middle, and middle+1 to rightEnd
        mergeHalves(array, leftStart, rightEnd);
    }

    static void mergeHalves(int[] array, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd)/2;
        int rightStart = leftEnd + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while(left <= leftEnd && right <= rightEnd) {
            if(array[left] <= array[right]){
                temp[index] = array[left++];
            } else {
                temp[index] = array[right++];
            }
            index++;
        }
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, rightEnd - leftStart + 1);
    }
}
