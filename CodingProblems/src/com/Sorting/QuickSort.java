package com.Sorting;

public class QuickSort {


    public static int[] quickSort(int[] array) {
        // Write your code here.
        quickSort(array, 0, array.length-1);
        return array;
    }

    static void  quickSort(int[] array, int left, int right) {
        if(left >= right) return;

        int pivot = array[(left+right)/2];
        //find point to break and apply quick sort on halves
        int index = partition(array, left, right, pivot);
        //apply quicksort on each halve
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    static int partition(int[] array, int left, int right, int pivot){
        while(left <= right){
            while(array[left] < pivot){
                left++;
            }
            while(array[right] > pivot){
                right--;
            }

            if(left <= right){
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    static void swap(int[] arr, int left, int right){
        int t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;
    }

}
