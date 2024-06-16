import java.util.*;
import java.io.*;

public class Main {
    static int N, M, HOUSE, CHICKEN;
    static int[][] map;
    static ArrayList<Node> chickens, houses;
    static boolean[] open;
    static int result = Integer.MAX_VALUE;


    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int getCityChickenDistance(ArrayList<Node> shops) {
        int result = 0;
        for (Node house : houses) {
            int dist = Integer.MAX_VALUE;
            for (Node shop : shops) {
                dist = Math.min(dist, Math.abs(house.x - shop.x) + Math.abs(house.y - shop.y));
            }
            result += dist;
        }
        return result;
    }

    public static void dfs(int s, int cnt) {
        if (cnt == M) {
            int res = 0;
            for (int i = 0; i < HOUSE; i++) {
                Node h = houses.get(i);
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < CHICKEN; j++) {
                    Node c = chickens.get(j);
                    if (open[j]) {
                        int dist = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                        temp = Math.min(temp, dist);
                    }
                }
                res += temp;
            }
            result = Math.min(result, res);
            return;
        }
        // 백트래킹
        for (int i = s; i < CHICKEN; i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houses.add(new Node(i, j));
                else if (map[i][j] == 2) chickens.add(new Node(i, j));
            }
        }
        HOUSE = houses.size();
        CHICKEN = chickens.size();
        open = new boolean[CHICKEN];

        if (chickens.size() <= M) {
            System.out.println(getCityChickenDistance(chickens));
            return;
        }
        dfs(0, 0);
        System.out.println(result);
        ;

    }
}