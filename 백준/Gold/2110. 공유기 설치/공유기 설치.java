import java.util.*;
import java.io.*;

public class Main {
    static int N, C;
    static int[] arr;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int lo = 1, hi = arr[N - 1];
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int pos = 0;
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (arr[i] - arr[pos] >= mid) {
                    pos = i;
                    cnt++;
                }
            }

            if (cnt < C) {
                hi = mid - 1;
                continue;
            }
            lo = mid + 1;
        }
        System.out.println(lo - 1);

    }
}