package com.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarEvent {
    //
    // Leetcode

    List<List<Integer>> calendar;

    public MyCalendarEvent() {
        calendar = new ArrayList<List<Integer>>();
    }

    public boolean book(int start, int end) {
        for(List<Integer> interval : calendar){
            if(interval.get(0) < end && start < interval.get(1) ) return false;
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

    /*
    We need a data structure that keeps elements sorted and supports fast insertion. In Java, a TreeMap is the perfect candidate. In Python, we can build our own binary tree structure.

    For Java, we will have a TreeMap where the keys are the start of each interval, and the values are the ends of those intervals.
    When inserting the interval [start, end), we check if there is a conflict on each side with neighboring intervals: we would like
    calendar.get(prev)) <= start <= end <= next for the booking to be valid (or for prev or next to be null respectively.)
     */

    //Time Complexity (Java): O(N log N), where N is the number of events booked. For each new event, we search
    // that the event is legal in O(log N) time, then insert it in O(1) time.
    //Size O(N) the size of the data structures used.
    public boolean book(int start, int end) {


        //if there is (5,6) and 2,3 in calendar and new interval = 3,4 then by using floor(3) we get 2, and by ceil(3) we get 5
        //takes logn each
        Integer prev = calendar.floorKey(start);   //2
        Integer next = calendar.ceilingKey(start); // 5

        //check if start 3 is greater than or equal to end value of prev start key  calendar.get(prev)
        // && end of new interval insert is less than start value or ceilingKey(start) then we can insert
        if((prev== null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }

}

}
