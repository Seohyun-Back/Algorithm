import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] result = new int[2];
    static int temp = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int lo = 0, hi = N - 1;
        result[0] = arr[lo];
        result[1] = arr[hi];
        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (temp > Math.abs(sum)) {
                temp = Math.abs(sum);
                result[0] = arr[lo];
                result[1] = arr[hi];
                if (sum == 0) break;
            } else {
                if (sum < 0) lo++;
                else hi--;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}