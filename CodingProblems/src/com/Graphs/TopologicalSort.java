package com.Graphs;

import java.util.HashSet;
import java.util.Stack;

public class TopologicalSort {

    //https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/TopologicalSort.java
    // backtracking or simply postorder DFS (depth-first search).


    public List<Node> sort(Graph graph) {
        Stack<Node> stack = new Stack<Node>();
        Set<Node> set = new HashSet<>();

        //visit all nodes if not visited already
        for (Node node : graph.lookup.getValues()){
            if(!visited.contains(node)){
                DFS(visited, stack, node);
            }
        }
        return stack;
    }

    void DFS(Set<Node> visited, Stack<Node> stack, Node node) {
        visited.add(node);

        //visit all child first - post order
        for(Node child : node.adjacentVertices) {
            if(!visited.contains(node))
                DFS(visited, stack, node);
        }

        stack.push(node);
    }
}
