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
    //O(n*n*n!) Time complexity:
    //O(n*n*n!) Time complexity: as there are n! leave nodes and n*n! total nodes since each path contains n node
    //and each node has n work to do to remove element on line 34
    // Another way is to see how much time below for loop take, it take n time to remove element, then how many times getPermutations()
    //is called, it is called O(n*n!) time since there are O(n!) leave nodes and path to leave node has n nodes so (n*n!) total nodes in tree
    // and each node has n time so n*n*n!
    static void getPermutations(List<Integer> array, List<Integer> perm, List<List<Integer>> perms) {
        // Write your code here.
        //below if block is call n! times since there are n! permutations
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
            newArray.remove(k);

            getPermutations(newArray, newPerm, perms);

        }
    }

}
