package Exercice2;

import java.util.*;

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

    /**
     * Finds the shortest path between two nodes using BFS.
     * @param start - starting node
     * @param end - target node
     * @return List<Integer> - the shortest path from start to end, or empty list if not connected
     */
    public static List<Integer> shortestPath(int start, int end) {
        if (start == end) return Collections.singletonList(start);

        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>(); // To reconstruct the path

        queue.add(start);
        visited[start] = true;
        parent.put(start, -1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int neighbor : adjList.get(cur)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    parent.put(neighbor, cur); // Track the path

                    // If we reached the end node, reconstruct the path
                    if (neighbor == end) {
                        return reconstructPath(parent, start, end);
                    }
                }
            }
        }
        return Collections.emptyList(); // No path found
    }

    /**
     * Reconstructs the path from start to end using the parent map.
     */
    private static List<Integer> reconstructPath(Map<Integer, Integer> parent, int start, int end) {
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = parent.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public void test() {

        System.out.println("Shortest Path Test ");

        Graph.addEdge(0, 1);
        Graph.addEdge(0, 2);
        Graph.addEdge(1, 3);
        Graph.addEdge(1, 4);
        Graph.addEdge(2, 4);
        Graph.addEdge(3, 5);
        Graph.addEdge(4, 5);
        Graph.addEdge(5, 6);
        Graph.addEdge(6, 7);

        System.out.println("Shortest path from 0 to 7: " + Graph.shortestPath(0, 7));
        System.out.println("Shortest path from 3 to 6: " + Graph.shortestPath(3, 6));
        System.out.println("Shortest path from 2 to 7: " + Graph.shortestPath(2, 7));
    }
}
