public class GraphColoring {
    static int n;             
    static int m;              
    static int[][] graph;      
    static int[] x;            

    public static void mColor(int k) {
        if (k == n) {    
            printSolution();
            return;
        }

        for (int color = 1; color <= m; color++) {
            if (isSafe(k, color)) {
                x[k] = color;
                mColor(k + 1);
                x[k] = 0; 
            }
        }
    }
    public static boolean isSafe(int v, int c) {
        for (int i = 0; i < n; i++) {
            if (graph[v][i] == 1 && x[i] == c) {
                return false;
            }
        }
        return true;
    }

    public static void printSolution() {
        System.out.print("Solution: ");
        for (int i = 0; i < n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        n = 6;
        m = 3;
        graph = new int[][] {
            {0, 1, 1, 0, 1, 1},
            {1, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 0}
        };
        x = new int[n];
        System.out.println("Graph 1 solutions:");
        mColor(0);

        n = 5;
        m = 5;
        graph = new int[][] {
            {0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 1, 1, 0}
        };
        x = new int[n];
        System.out.println("Graph 2 solutions:");
        mColor(0);
    }
}