import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Node>[] list;
    static boolean[] visit;
    static int result = 0;

    public static class Node {
        int x;
        int w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }

    public static void dfs(int num, int dim) {
        for (Node node : list[num]) {
            if (!visit[node.x]) {
                visit[node.x] = true;
                dfs(node.x, dim + node.w);
            }
        }
        result = Math.max(result, dim);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Node>();
        }
        // input
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            visit[i] = true;
            dfs(i, 0);
        }
        System.out.println(result);
    }
}