import java.util.*;
import java.io.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean token = false;
    static int day = 0;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(Node node) {
        int num = 0, sum = 0;
        ArrayList<Node> union = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            num++;
            sum += map[n.x][n.y];
            union.add(n);
            for (int d = 0; d < 4; d++) {
                int nx = n.x + dx[d];
                int ny = n.y + dy[d];
                if (nx >= 0 && n.y + dy[d] >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny] && Math.abs(map[nx][ny] - map[n.x][n.y]) >= L && Math.abs(map[nx][ny] - map[n.x][n.y]) <= R) {
                        visited[nx][ny] = true;
                        token = true;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
        int pop = sum / num;
        for (Node value : union) {
            map[value.x][value.y] = pop;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            token = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        bfs(new Node(i, j));
                    }
                }
            }

            if (!token) break;
            day++;
        }
        System.out.println(day);
    }
}