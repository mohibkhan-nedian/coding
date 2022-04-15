package com.Arrays;

public class NewerVersion {
    Write a method that takes two version numbers as parameters and returns
    - a -1 if the first one is older
    - a +1 if the second one is older
    - or zero if they are EQUIVALENT.
    Software versions are represented by numbers separated by dots

    e. g. - "1.2.3" > "1.2.1" ---> +1.

    int compare(String v1, String v2) {
        char[] array1 = v1.split(".");
        char[] array2 = v2.split(".");

        int smallerLength = Math.min(array1.length, array2.length);

        int i = 0;
        for(i = 0; i < smallerLength; i++){
            if(array1[i] > array2[i]){
                return 1;
            } else if(array1[i] < array2[i]) {
                return -1;
            }
        }

        // Call in another method
        char[] bigger = array1.length > array2.length ? array1 : array2;

        while(smallerLength < bigger.length) {
            if(bigger[smallerLength] >0){
                if(bigger.length == array1.length) {
                    return 1;
                } else {
                    return -1;
                }
            }
            smallerLength++;
        }
        return 0;
    }

// 1
// 1. not invalid

1.2.3
        [1, 2, 3] [1, 2, 1]

        1.2.1.0, 1.2
        [1, 2, 0] [1, 2]
}
