package com.String;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstDuplicateCharInString {

    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
         // Time O(n)
        //Space O(1) because map can contain max 26 entries

        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for(char c : string.toCharArray() ){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < string.length() ; i++){
            if(map.get(string.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
