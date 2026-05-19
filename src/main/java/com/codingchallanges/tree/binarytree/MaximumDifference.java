package com.codingchallanges.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MaximumDifference {

    /*
     * Complete the 'maximumDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts UNWEIGHTED_INTEGER_GRAPH g as parameter.
     *
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */

    // Complete the following function
    public static int maximumDifference(int gNodes, List<Integer> gFrom, List<Integer> gTo) {
                    // Write your code here
        int result = 0;

        // Create a graph using adjacency list
        List<Integer>[] graph = new List[gNodes];
        for (int i = 0; i < gNodes; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < gFrom.size(); i++) {
            int from = gFrom.get(i) - 1;
            int to = gTo.get(i) - 1;
            graph[from].add(to);
            graph[to].add(from);
        }

        // Perform DFS to find the maximum difference
        boolean[] visited = new boolean[gNodes];
        for (int i = 0; i < gNodes; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(graph, visited, i, component);
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int node : component) {
                    min = Math.min(min, node + 1);
                    max = Math.max(max, node + 1);
                }
                result = Math.max(result, max - min);
            }
        }

        return result;
    }

    private static void dfs(List<Integer>[] graph, boolean[] visited, int node, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor, component);
            }
        }

    }
}

