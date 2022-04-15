package com.Tries;

import java.util.HashMap;
import java.util.Optional;

public class Trie {

    static class TrieNode {
        private HashMap<Character, TrieNode> map = new HashMap<>();
        private boolean isTerminatingChar;
    }

    TrieNode root = new TrieNode();

    //Add words to trie
    public Trie(String[] words){
        for(String word: words){
            addWord(word);
        }
    }

    private void addWord(String word){
        if(word ==null || word.isEmpty()) {
            return;
        }
        //every time a word is added, it is added from root ode
        TrieNode node = root;

        for(char c : word.toCharArray()){
            if(!node.map.containsKey(c)){
                node.map.put(c, new TrieNode());
            }
            node = node.map.get(c);
        }
        node.isTerminatingChar = true;
    }

    boolean contains(String word){
        return contains(word, true);
    }

    boolean containsPrefix(String word, boolean isPrefix){
        return contains(word, isPrefix);
    }

    boolean contains(String word, boolean isPrefix){
        TrieNode node = root;

        for(char c : word.toCharArray()){
            if(!node.map.containsKey(c)){
                return false;
            }
            node = node.map.get(c);
        }
        return !isPrefix && node.isTerminatingChar;
    }

    Optional<TrieNode> validatePrefix(TrieNode startingNode, String prefix){
        if(prefix == null || prefix.isEmpty()){
            return null;
        }
        // instead of starting from root node, start from this node, if this is null we can start from root
        TrieNode node = startingNode;
        if(node == null)
            node = root;

        for(char c : prefix.toCharArray()){
            if(!node.map.containsKey(c)){
                return Optional.empty();
            }
            node = node.map.get(c);
        }
        // this will make
        return Optional.of(node);
    }


}
