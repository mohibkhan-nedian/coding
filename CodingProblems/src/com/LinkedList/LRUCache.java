package com.LinkedList;

import java.util.HashMap;

public class LRUCache {
    private int maxSize;

    private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();

    LinkedListNode head = null; // we dont need LinkedList class here, a head is also enough to iterate a linkedlist
    LinkedListNode tail =null;

    public LRUCache(int s) {
        maxSize = s;
    }

    public String getValue(int key) {
        LinkedListNode node = map.get(key);
        if (node == null) return null;
        if(node != head) {
            removeNodeFromList(node);
            insertAtFront(node);
        }
        return node.val;
    }

    public void setKeyValue(int key, String value) {
        //insert into cache but it may already exist in cache
        removeKey(key);

        //insert into cache
        //check if full, remove lru item which is tail
        if(map.size() >= maxSize && tail !=null) {
            removeKey(tail.key);
        }
        LinkedListNode node = new LinkedListNode(value);
        insertAtFront(node);
        map.put(key, node);
    }

    private void removeNodeFromList(LinkedListNode node) {
        if(node==null) return;
        //set prev'next to node' next
        if(node.prev!=null)
            node.prev.next = node.next;
        //set next' prev to node' prev
        if(node.next!=null)
            node.next.prev = node.prev;

        //set head and tail if not updated
        if(node==head)
            head = node.next;
        if(node==tail)
            tail = node.prev;
    }

    //remove key from list and map
    private void removeKey(int key) {
        LinkedListNode node = map.get(key);
        removeNodeFromList(node);
        map.remove(key);
    }

    private void insertAtFront(LinkedListNode node) {
        if(head== null){
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = null;

        }
    }
}

class LinkedListNode{
    Integer key;
    String val;
    LinkedListNode next;
    LinkedListNode prev;

    public LinkedListNode(String value) {
        this.val = value;
    }
}