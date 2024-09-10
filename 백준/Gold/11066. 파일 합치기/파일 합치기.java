import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int N;
    static int[] arr;
    static int[] prefixSum;
    static int[][] dp;
    static int cost = 0;
    static int INF = Integer.MAX_VALUE / 3;
    static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        answer = new int[T];
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N];
            prefixSum = new int[N];
            dp = new int[N][N];
            for (int i = 0; i < N; i++) Arrays.fill(dp[i], INF);
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i][i] = 0;
            }
            prefixSum[0] = arr[0];
            for (int i = 1; i < N; i++) prefixSum[i] = arr[i] + prefixSum[i - 1];

            for (int gap = 1; gap < N; gap++) {
                for (int s = 0; s < N - gap; s++) {
                    for (int i = s; i < s + gap; i++) {
                        dp[s][s + gap] = Math.min(dp[s][s + gap], dp[s][i] + dp[i + 1][s + gap] + prefixSum[s + gap] - (s == 0 ? 0 : prefixSum[s - 1]));
                    }
                }
            }
            answer[t] = dp[0][N - 1];

        }
        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }

    }
}