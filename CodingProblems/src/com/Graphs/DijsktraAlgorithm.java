package com.Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class DijsktraAlgorithm {

    //https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
    //https://www.youtube.com/watch?v=CerlT7tTZfY - queue visuals


    HashSet<Integer> visited = new HashSet<>();
    //keep nodes with respect to there costs
    PriorityQueue<Node> pq = new PriorityQueue<Node>((Node n1, Node n2) -> n1.cost - n2.cost);

    void dijkstra(List<List<Node>> edges, int src){
        int ans[] = new int[edges.size()];
        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        for (int i = 0; i < edges.size(); i++)
            ans[i] = Integer.MAX_VALUE;

        // Distance to the source is 0
        ans[src] = 0;

        while (visited.size() < edges.size()) {
            // Terminating condition check when
            // the priority queue is empty, return
            if(pq.isEmpty()) return;


            // Removing the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            if(visited.contains(u)){
                //already visited before from some other path so ignore as this path cant be more optimal (greedy) then
                continue;
            }

            visited.add(u);

            //updateHeapByVisitingAllEdgeFromThisNode
            visitNeighbors(u, ans, edges);
        }
    }

    private void visitNeighbors(int u, int[] ans, List<List<Node>> edges) {
        int edgeDistance = -1;
        int newDistance = -1;

        for(Node v: edges.get(u)) {
            if(visited.contains(v.node))
                continue;

            edgeDistance = v.cost;
            newDistance = ans[u] + edgeDistance;

            // If new distance is cheaper in cost, if not visited before than ans[v.node] = Integer.MAX_VALUE
            if(newDistance < ans[v.node]) {
                ans[v.node] = newDistance;
            }

            // Add the current node to the queue with this new cost, if it already exists in pq then we will
            //have two nodes in pq with same node number but different costs, and the pq node with lesser cost will be picked first
            //from the pq so the pq node with higher cost will remain in the pq as shown in video  https://www.youtube.com/watch?v=CerlT7tTZfY
            pq.add(new Node(v.node, ans[v.node]));
        }
    }
}

class Node {

    // Member variables of this class
    public int node;
    public int cost;

    public Node(int src, int i) {
    }
}

/*
  // Main driver method
    public static void main(String arg[])
    {

        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges by declaring List class object
        // Declaring object of type List<Node>
        List<List<Node> > adj
            = new ArrayList<List<Node> >();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Inputs for the GFG(dpq) graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        // Calculating the single source shortest path
        GFG dpq = new GFG(V);
        dijkstra(adj, source);

        // Printing the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");

        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                               + dpq.dist[i]);
    }
}


 */