package com.LinkedList;

public class ShiftLinkedList {

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    //Time O(n) , Space(1) where n is no. of nodes
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.

        LinkedList p1 = head;
        LinkedList p2 = head;
        for(int i = 0 ; i < k ; i++){
            if(p1!=null)
                p1 = p1.next;
            else return head;
        }
        while(p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        LinkedList newHead = p2.next;
        LinkedList node = p2.next;

        if(node==null) return head;
        p2.next= null;

        while(node.next != null){
            node = node.next;
        }
        node.next = head;

        return newHead;

    }
///////////////////****ALGOEXPERT SOLUTIN BELOW WITH ALL EDGE CASE AND -K HANDLING********/////////////////

     static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.
        int len = 1;
        LinkedList tail = head;

        //we need new tail , new head, old tail, old head
        // for old tail we need to know length and also we can cal newtail pos then
        while(tail.next!=null) {
            tail = tail.next;
            len++;
        }
        int offset = Math.abs(k) % len;
        if(offset == 0) return head; // no shift needed
        int newTailPos = k > 0 ? len - offset : offset;

        LinkedList newTail = head;
        //get to newTail node
         // when i = newTailPos - 1, newTail is set to newTail node
        for(int i = 1; i < newTailPos; i++){
            newTail = newTail.next;
        }

        LinkedList newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }

}

