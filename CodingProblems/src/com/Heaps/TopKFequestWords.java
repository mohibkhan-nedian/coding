package com.Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFequestWords {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        for(String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<String>((w1, w2) -> {

            if(map.get(w2) - map.get(w1) != 0)
                return map.get(w2) - map.get(w1);
            else
                return w1.compareTo(w2);
        });

        for(String key: map.keySet()) {
            queue.add(key);
        }

        ArrayList<String> list = new ArrayList<>();

        while(!queue.isEmpty() && k>0){
            list.add(queue.remove());
            k--;
        }
        return list;
    }

}
