package com.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarEvent {

    List<List<Integer>> calendar;

    public MyCalendarEvent() {
        calendar = new ArrayList<List<Integer>>();
    }

    public boolean book(int start, int end) {
        for(List<Integer> interval : calendar){
            if(interval.get(0) < end && interval.get(1) > start) return false;
        }
        calendar.add(new ArrayList<Integer>() {
            {
                add(start);
                add(end);
            }
        });
        return true;
    }


    //// TREE MAP solution
    TreeMap<Integer, Integer> calendar = new TreeMap<>();


    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);

        //check if start is greater than end value of prev start key or end to insert is less than start value or ceilingKey(start)
        if((prev== null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start,end);
            return true;
        }
        return false;
    }

}

}
