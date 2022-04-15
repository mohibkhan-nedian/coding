package com.String;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        if(strs.length == 0) return new ArrayList();

        for(String s: strs){
            char[] str = s.toCharArray();
            Arrays.sort(str); // Take K(logK) time for string of len k
            String key = String.valueOf(str);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(s);

        }
        return new ArrayList<>(map.values());
    }
}
