package course02;

public class RoadToBiodome10 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        boolean[][] adj = new boolean[101][101];
        boolean[] present = new boolean[101];

        for (String arg : args) {
            String cleanArg = arg.trim();
            if (cleanArg.isEmpty()) {
                continue;
            }

            String[] parts = cleanArg.split(",");
            if (parts.length != 2) {
                System.out.println("입력된 값이 올바르지 않습니다.");
                return;
            }

            try {
                int u = Integer.parseInt(parts[0].trim());
                int v = Integer.parseInt(parts[1].trim());

                if (u < 1 || u > 100 || v < 1 || v > 100) {
                    System.out.println("식물의 범위를 벗어난 숫자가 포함되어 있습니다.");
                    return;
                }

                adj[u][v] = true;
                adj[v][u] = true;
                present[u] = true;
                present[v] = true;

            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 올바르지 않습니다.");
                return;
            }
        }

        boolean[] dfsVisited = new boolean[101];
        int dfsGroupCount = 0;
        for (int i = 1; i <= 100; i++) {
            if (present[i] && !dfsVisited[i]) {
                dfsGroupCount++;
                dfs(i, adj, dfsVisited);
            }
        }

        boolean[] bfsVisited = new boolean[101];
        int bfsGroupCount = 0;
        for (int i = 1; i <= 100; i++) {
            if (present[i] && !bfsVisited[i]) {
                bfsGroupCount++;
                bfs(i, adj, bfsVisited);
            }
        }

        System.out.println("DFS: " + dfsGroupCount);
        System.out.println("BFS: " + bfsGroupCount);
    }

    public static void dfs(int node, boolean[][] adj, boolean[] visited) {
        visited[node] = true;

        for (int next = 1; next <= 100; next++) {
            if (adj[node][next] && !visited[next]) {
                dfs(next, adj, visited);
            }
        }
    }

    public static void bfs(int startNode, boolean[][] adj, boolean[] visited) {
        int[] queue = new int[101];
        int front = 0;
        int rear = 0;

        queue[rear++] = startNode;
        visited[startNode] = true;

        while (front < rear) {
            int curr = queue[front++];
            for (int next = 1; next <= 100; next++) {
                if (adj[curr][next] && !visited[next]) {
                    visited[next] = true;
                    queue[rear++] = next;
                }
            }
        }
    }
}
