import java.util.*;

public class StructuralTestingTool {

    // A method that returns the maximum number of independent paths in a graph
    public static List<List<Integer>> getMaxIndependentPaths(int[][] graph) {
        List<List<Integer>> independentPaths = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0); // Start from the source node
        dfs(graph, 0, visited, currentPath, independentPaths);
        return independentPaths;
    }

    private static void dfs(int[][] graph, int node, Set<Integer> visited, List<Integer> currentPath, List<List<Integer>> independentPaths) {
        visited.add(node);
        if (node == graph.length - 1) { // We have reached the sink node
            independentPaths.add(new ArrayList<>(currentPath));
        } else {
            for (int neighbor : graph[node]) {
                if (!visited.contains(neighbor)) {
                    currentPath.add(neighbor);
                    dfs(graph, neighbor, visited, currentPath, independentPaths);
                    currentPath.remove(currentPath.size() - 1);
                }
            }
        }
        visited.remove(node);
    }

    // A method that returns the cyclomatic complexity of a graph
    public static int getCyclomaticComplexity(int[][] graph) {
        int edges = 0;
        int nodes = graph.length;
        for (int i = 0; i < nodes; i++) {
            edges += graph[i].length;
        }
        return edges - nodes + 2;
    }

    // A main method to test the tool with the given example
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {3}, {}};
        List<List<Integer>> independentPaths = getMaxIndependentPaths(graph);
        int cyclomaticComplexity = getCyclomaticComplexity(graph);

        System.out.println("Independent Paths:");
        for (List<Integer> path : independentPaths) {
            System.out.println(path.toString().replaceAll("[\\[\\],]", ""));
        }

        System.out.println("Cyclomatic Complexity: " + cyclomaticComplexity);
    }
}

