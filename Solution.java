import java.util.*;
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] path : paths) {
            graph[path[0] - 1].add(path[1] - 1);
            graph[path[1] - 1].add(path[0] - 1);
        }

        int[] flowers = new int[n];
        backtrack(0, n, flowers, graph);
        return flowers;
    }
    private boolean backtrack(int garden, int n, int[] flowers, List<Integer>[] graph) {
        if (garden == n) return true;

        for (int type = 1; type <= 4; type++) {
            if (isSafe(garden, type, flowers, graph)) {
                flowers[garden] = type;
                if (backtrack(garden + 1, n, flowers, graph)) return true;
                flowers[garden] = 0;
            }
        }

        return false;
    }
    private boolean isSafe(int garden, int type, int[] flowers, List<Integer>[] graph) {
        for (int neighbor : graph[garden]) {
            if (flowers[neighbor] == type) return false;
        }
        return true;
    }
}
