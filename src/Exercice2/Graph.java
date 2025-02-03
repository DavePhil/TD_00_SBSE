package Exercice2;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    static List<List<Integer>> adjList;

    public Graph(int size) {
        adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    static void addEdge(int u, int v) {
        while (adjList.size() <= Math.max(u, v)) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Pour un graphe non orienté
    }

    static void removeAllEdges() {
        adjList.clear();
    }
}
