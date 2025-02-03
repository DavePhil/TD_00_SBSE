package Exercice2;

import java.util.List;

public class DepthFirstSearch {

    private Graph graph;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    static void dfsRec(List<List<Integer> > adj, boolean[] visited, int s){
        visited[s] = true;
        System.out.println("Visiting " + s);
        for (int i : Graph.adjList.get(s)) {
            if (!visited[i]) {
                dfsRec(adj, visited, i);
            }
        }
    }


    public void dfs(int s) {
        boolean[] visited = new boolean[Graph.adjList.size()];
        dfsRec(Graph.adjList, visited, s);
    }

    void test() {
        System.out.println("First DFS Test: ");
        Graph.addEdge(1, 2);
        Graph.addEdge(1, 0);
        Graph.addEdge(2, 0);
        Graph.addEdge(2, 3);
        Graph.addEdge(2, 4);
        dfs(1);

        Graph.removeAllEdges();
    }
}
