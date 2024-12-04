//16235

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[][] A;
    static ArrayList<Integer>[][] map;
    static Queue<Integer>[][] deadTrees;
    static int[][] nut;
    static int year = 0;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N + 1][N + 1];
        nut = new int[N + 1][N + 1];
        map = new ArrayList[N + 1][N + 1];
        deadTrees = new LinkedList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
                deadTrees[i][j] = new LinkedList<>();
                A[i][j] = Integer.parseInt(st.nextToken());
                nut[i][j] = 5;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[x][y].add(z);
        }
        while (year < K) {
            year++;
            //봄
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j].isEmpty()) continue;
                    Collections.sort(map[i][j]);
                    for (int t = 0; t < map[i][j].size(); t++) {
                        int tr = map[i][j].get(t);
                        if (tr <= nut[i][j]) {
                            nut[i][j] -= tr;
                            map[i][j].set(t, tr + 1);
                        } else {
                            deadTrees[i][j].offer(tr);
                            map[i][j].remove(t);
                            t--;
                        }
                    }
                }
            }
            //여름
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    while (!deadTrees[i][j].isEmpty()) {
                        int t = deadTrees[i][j].remove();
                        nut[i][j] += (t / 2);
                    }
                }
            }
            //가을
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j].isEmpty()) continue;
                    for (int t = 0; t < map[i][j].size(); t++) {
                        int tr = map[i][j].get(t);
                        if (tr % 5 != 0) continue;
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                                map[nx][ny].add(1);
                            }
                        }
                    }
                }
            }
            //겨울
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    nut[i][j] += A[i][j];
                }
            }
        }
        int tree = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tree += map[i][j].size();
            }
        }
        System.out.println(tree);
    }
}