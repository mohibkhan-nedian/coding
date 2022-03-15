package com.Heaps;

import java.util.PriorityQueue;

public class RunningContinuousMedian {

        PriorityQueue<Integer> lowers = new PriorityQueue<>((i1, i2) -> i2 - i1); //max heap
        PriorityQueue<Integer> greaters = new PriorityQueue<>(); // min heap

        double median = 0;

        //O(logn) time because we have to insert all numbers in heap
        //O(n) space where n is number of inserted numbers
        public void insert(int number) {
            // Write your code here.
            if(lowers.size() == 0 || number < lowers.peek()) {
                lowers.add(number);
            } else{
                greaters.add(number);
            }
            rebalanceHeaps();
            updateMedian();
        }

        void rebalanceHeaps() {
            if(Math.abs(lowers.size()- greaters.size()) > 1) {
                if(lowers.size() > greaters.size()){
                    greaters.add(lowers.remove());
                } else {
                    lowers.add(greaters.remove());
                }
            }
        }

        void updateMedian() {
            if(lowers.size() == greaters.size()){
                median = ((double) lowers.peek() + (double) greaters.peek()) /2;
            } else if (lowers.size() > greaters.size()) {
                median = lowers.peek();
            } else {
                median = greaters.peek();
            }
        }

        public double getMedian() {
            return median;
        }
    }

