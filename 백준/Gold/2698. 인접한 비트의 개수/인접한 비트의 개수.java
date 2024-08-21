import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int[][][] dp = new int[101][101][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp[1][0][1] = 1;
        dp[1][0][0] = 1;
        for (int k = 0; k < 101; k++) {
            for (int n = 2; n < 101; n++) {
                dp[n][k][1] += dp[n - 1][k][0];
                if (k != 0) dp[n][k][1] += dp[n - 1][k - 1][1];
                dp[n][k][0] += dp[n - 1][k][0] + dp[n - 1][k][1];
            }
        }

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            System.out.println(dp[s][k][0] + dp[s][k][1]);
        }
    }
}