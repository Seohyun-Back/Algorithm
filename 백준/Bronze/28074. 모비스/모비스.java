import java.io.*;
import java.util.*;

public class Main {
    static String word;
    static boolean[] used = new boolean[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        Arrays.fill(used, false);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'M') used[0] = true;
            else if (word.charAt(i) == 'O') used[1] = true;
            else if (word.charAt(i) == 'B') used[2] = true;
            else if (word.charAt(i) == 'I') used[3] = true;
            else if (word.charAt(i) == 'S') used[4] = true;
            for (int j = 0; j < 5; j++) {
                if (!used[j]) break;
                if (j == 4) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");

    }
}