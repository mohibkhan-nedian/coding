package com.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.

        // (n2^n) Time and space. Because there are 2^n subsets. Subset can have items between 0 to n so on avg subsets
        // contains O(n/2) or O(n) items so time to fill 2^n subsets will be O(n2^n)

        List<List<Integer>> subsets = new ArrayList<List<Integer>>();

        subsets.add(new ArrayList<Integer>());
        for(int i = 0 ; i  < array.size(); i++) {
            int len = subsets.size();
            for(int k = 0 ;  k < len; k++) {
                List<Integer> list = new ArrayList<>(subsets.get(k));
                list.add(array.get(i));
                subsets.add(list);
            }
        }
        return subsets;
    }




    ///////////////////////////////// RECURSIVE

    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        //base case
        return getSubsets(array, 0);

    }

    static List<List<Integer>> getSubsets(List<Integer> array, int index){
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        //base case
        if(index==array.size() ) {
            subsets.add(new ArrayList<Integer>());
            return subsets;
        }

        //recursive case  - do recursive call
        int ele= array.get(index);
        subsets = getSubsets(array, index + 1);
        //below code is same as in for loop to add current item in all subset one by one
        int len = subsets.size();
        for(int k = 0 ;  k < len; k++) {
            List<Integer> list = new ArrayList<>(subsets.get(k));
            list.add(array.get(index));
            subsets.add(list);
        }

        return subsets;
    }
}
