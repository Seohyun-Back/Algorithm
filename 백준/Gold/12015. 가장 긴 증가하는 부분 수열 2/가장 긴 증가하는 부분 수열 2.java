import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A, arr;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = A[0];
        for (int i = 1; i < N; i++) {
            int temp = A[i];
            if (temp > arr[cnt - 1]) {
                cnt++;
                arr[cnt - 1] = temp;
            } else {
                int lo = 0, hi = cnt;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (arr[mid] < temp) lo = mid + 1;
                    else hi = mid;
                }
                arr[lo] = temp;
            }
        }
        System.out.println(cnt);

    }
}