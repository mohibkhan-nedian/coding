package com.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        getPermutations(array, new ArrayList<Integer>(), ans);
        return ans;
    }

    //O(n*n*n!) Time complexity, O(n*n!) space complexity because there are n! perms each of length n so we need n*n! space to store them

    //O(n*n*n!) Time complexity: as there are n! leave nodes and n*n! total nodes since each path/branch from root to leaf contains n node
    //and each node has n work to do to remove element on line 34
    // Another way is to see how much time below for loop take, it take n time to remove element, then how many times getPermutations()
    //is called, it is called O(n*n!) time since there are O(n!) leave nodes and path to leave node has n nodes so (n*n!) total nodes in tree
    // and each node has n time so n*n*n!
    static void getPermutations(List<Integer> array, List<Integer> perm, List<List<Integer>> perms) {
        // Write your code here.
        //below if block is call n! times since there are n! permutations
        //perm.size() > 0 because we want to return [] not [[]] when input array is empty, so we make sure that current perm is not empty
        if(array.size() == 0 && perm.size() > 0) {
            perms.add(perm);
            return;
        }

        for(int k =0 ; k < array.size(); k++){
            //append this element to current perm. note that we cant add this element to same perm
            //as it is referenced in other recursive calls, so we need to create a new list to pass in next calls
            List<Integer> newPerm = new ArrayList<Integer>(perm);
            newPerm.add(array.get(k));

            //remove current element from array and pass to next call
            //note that we cant remove from same array as it is referenced in other recursive calls
            List<Integer> newArray = new ArrayList<Integer>(array);
            newArray.remove(k); // when k = 1 , element at 0 and 2 will remain but element at 1 will be removed and we find permutation for [1, 3] no 2 in at index 1

            getPermutations(newArray, newPerm, perms);

        }
    }

    //////////////////////

    //Sol 2 algoexp

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        getPermutations(0, array, ans);
        return ans;
    }

    static void getPermutations(int i , List<Integer> array, List<List<Integer>> permutations) {
        if(i== array.size()-1)
            permutations.add(new ArrayList<Integer>(array));
        else {
            for (int j = i; j < array.size(); j++) {
                //swap(array, i, j);
                getPermutations(i + 1, array, permutations);
                //swap(array, i, j);
            }
        }
    }



}
