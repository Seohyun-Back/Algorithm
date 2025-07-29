// 백준 25757

import java.util.*;
import java.io.*;

// TODO: Y-2 F-3 O-4

public class Main {
    public static int N;
    public static String game;
    public static HashSet<String> players = new HashSet<>();
    public static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        game = st.nextToken();
        if (game.equals("Y")) num = 1;
        else if (game.equals("F")) num = 2;
        else if (game.equals("O")) num = 3;

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            players.add(name);
        }
        int total = players.size();
        System.out.println(total / num);
    }
}