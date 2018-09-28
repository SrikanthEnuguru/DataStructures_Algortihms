package practise.datastructures.graph;

import java.util.LinkedList;

public class Graph {
    int v; // No. of vertices
    LinkedList<Integer> adj[]; //Adjacency Lists

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
