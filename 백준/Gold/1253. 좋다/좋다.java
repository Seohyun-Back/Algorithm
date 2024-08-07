import java.util.*;
import java.io.*;

//TODO: 음수 들어가면 자기보다 작은 수 ㄴㄴ

public class Main {
    static int N;
    static int[] A;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            int lo = 0, hi = N - 1;
            while (true) {
                if (lo == i) lo = i + 1;
                else if (hi == i) hi = i - 1;
                if (lo >= hi) break;
                if (A[lo] + A[hi] == A[i]) {
                    result++;
                    break;
                } else if (A[lo] + A[hi] > A[i]) hi--;
                else if (A[lo] + A[hi] < A[i]) lo++;
            }
        }
        System.out.println(result);
    }
}