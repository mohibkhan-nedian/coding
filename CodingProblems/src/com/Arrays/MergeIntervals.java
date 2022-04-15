package com.Arrays;

public class MergeIntervals {

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        // sort the intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        intervals.remove(0);

        for(Interval interval : intervals) {

            if(end >= interval.start){
                //overlap
                end = Math.max(interval.end, end);
            } else {
                mergedIntervals.add(new Interval(start,end));
                start = interval.start;
                end= interval.end;
            }
        }
        // add the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
}
