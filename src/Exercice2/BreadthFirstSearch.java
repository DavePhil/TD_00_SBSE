package Exercice2;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    Graph graph;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    void bfs(int s) {
        boolean[] visited = new boolean[Graph.adjList.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.println("Visiting " + cur);
            for (int x : Graph.adjList.get(cur)) {
                if (!visited[x]) {
                    q.add(x);
                    visited[x] = true;
                }
            }
        }
    }


    void test() {
        System.out.println("BFS Test: ");
        Graph.addEdge(0, 1);
        Graph.addEdge(0, 2);
        Graph.addEdge(1, 3);
        Graph.addEdge(1, 4);
        Graph.addEdge(2, 4);
        bfs(0);

        Graph.removeAllEdges();

        System.out.println(" ");
    }
}
