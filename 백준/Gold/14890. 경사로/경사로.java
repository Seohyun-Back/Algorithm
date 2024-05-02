import java.io.*;
import java.util.*;


public class Main {
    static int N, L;
    static int[][] map;
    static int result = 0;

    public static boolean makeRoad(int[] arr) {
        int ramp = 0;
        boolean[] rampArr = new boolean[N];
        for (int i = 1; i < N; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) return false;
            else if (arr[i] == arr[i - 1] - 1) {
                if (ramp != 0) return false;
                ramp++;
                rampArr[i] = true;
            } else if (arr[i] == arr[i - 1]) {
                if (ramp > 0) {
                    rampArr[i] = true;
                    ramp++;
                }
            }
            if (ramp == L) ramp = 0;
        }

//        System.out.print("-> : ");
//        for (int i = 0; i < N; i++) System.out.print(rampArr[i] + " ");
//        System.out.println();

        if (ramp != 0) return false;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] == arr[i + 1] - 1) {
                if (ramp !=0 || rampArr[i]) return false;
                ramp++;
                rampArr[i] = true;
            } else if (arr[i] == arr[i + 1]) {
                if (ramp > 0) {
                    if (rampArr[i]) return false;
                    ramp++;
                }
            }
            if (ramp == L) ramp = 0;
        }
        if (ramp != 0) return false;


//        System.out.print("<- : ");
//        for (int i = 0; i < N; i++) System.out.print(rampArr[i] + " ");
//        System.out.println();
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            if (makeRoad(map[i])) {
//                System.out.println(i + " - 1");
                result++;
            }
            int[] arr2 = new int[N];
            for (int j = 0; j < N; j++) {
                arr2[j] = map[j][i];
            }
            if (makeRoad(arr2)) {
//                System.out.println(i + " - 2");
                result++;
            }
        }
        System.out.println(result);
    }
}
