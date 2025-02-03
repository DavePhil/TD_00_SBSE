package Exercice2;

public class main {
    public static void main(String[] args) {
        Graph graph = new Graph(15);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
        bfs.test();

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.test();

        Graph.test();
    }
}
