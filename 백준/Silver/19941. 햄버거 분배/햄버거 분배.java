import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  static int N, K;
  static String map = "";
  static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = br.readLine();
    StringBuilder sb = new StringBuilder(map);
    for (int i = 0; i < N; i++) {
      if (sb.charAt(i) == 'H') continue;
      else if (sb.charAt(i) == 'P') {
        int ldx = Math.max(i - K, 0);
        int rdx = Math.min(i + K, N - 1);
        for (int j = ldx; j <= rdx; j++) {
          if (sb.charAt(j) == 'H') {
            result++;
            sb.setCharAt(j, 'X');
            break;
          }
        }
      }
    }
    System.out.println(result);
  }
}