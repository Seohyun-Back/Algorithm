import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int time = 0, cnt = 0, cheese;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[node.x][node.y] = true;
        Queue<Node> edge = new LinkedList<>();

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 1) {
                            map[nx][ny] = 2;
                            visited[nx][ny] = true;
                            edge.add(new Node(nx, ny));
                        } else if (map[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            q.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }
        while (!edge.isEmpty()) {
            Node t = edge.poll();
            map[t.x][t.y] = 0;
            cnt--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cnt++;
            }
        }
        cheese = cnt;
        while (cnt > 0) {
            time++;
            bfs(new Node(0, 0));
            for (int i = 0; i < N; i++) Arrays.fill(visited[i], false);
            if (cnt != 0) cheese = cnt;
        }
        System.out.println(time);
        System.out.println(cheese);

    }
}