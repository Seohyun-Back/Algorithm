//15591

import java.io.*;
import java.util.*;

public class Main {
    static int N, Q, K, R;
    static List<int[]>[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        dist = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            dist[p].add(new int[]{q, r});
            dist[q].add(new int[]{p, r});
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < Q; t++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            int result = 0;
            boolean[] visited = new boolean[N + 1];
            Queue<Integer> q = new LinkedList<>();
            q.offer(R);
            while (!q.isEmpty()) {
                int cur = q.poll();
                visited[cur] = true;
                for (int i = 0; i < dist[cur].size(); i++) {
                    if (!visited[dist[cur].get(i)[0]] && dist[cur].get(i)[1] >= K) {
                        visited[dist[cur].get(i)[0]] = true;
                        q.add(dist[cur].get(i)[0]);
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}