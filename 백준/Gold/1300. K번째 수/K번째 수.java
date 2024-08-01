import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static long hi, lo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        lo = 1;
        hi = K;
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid / i);
            }
            if (K <= cnt) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(lo);
    }
}