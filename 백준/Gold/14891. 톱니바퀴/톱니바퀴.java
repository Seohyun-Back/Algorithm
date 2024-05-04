import java.util.*;
import java.io.*;

public class Main {
    static int[][] wheels = new int[4][8];
    static int K;
    static int result = 0;
//    static Node nodeA, nodeB, nodeC;
//    static Node[][] turnOrder;

    public static class Node {
        int a, b, c, d;

        public Node(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }


    public static void rotateClockwise(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            q.offer(wheels[n][i]);
        }
        for (int i = 1; i < 8; i++) {
            wheels[n][i] = q.poll();
        }
        wheels[n][0] = q.poll();
    }

    public static void rotateCounterClockwise(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 8; i++) {
            stack.push(wheels[n][i]);
        }
        for (int i = 6; i >= 0; i--) {
            wheels[n][i] = stack.pop();
        }
        wheels[n][7] = stack.pop();
    }

    public static void solution(int num, int dir) {
        // dir이 1인 경우는 시계 방향이고, -1인 경우는 반시계
        num--;
        int[] rotate = new int[4];
        rotate[num] = dir;
        for (int i = num; i >= 1; i--) {
            if (rotate[i] == -7) rotate[i - 1] = -7;
            else if (wheels[i - 1][2] == wheels[i][6]) rotate[i - 1] = -7;
            else if (wheels[i - 1][2] != wheels[i][6]) rotate[i - 1] = (rotate[i] == 1) ? -1 : 1;
        }
        for (int i = num; i < 3; i++) {
            if (rotate[i] == -7) rotate[i + 1] = -7;
            else if (wheels[i][2] == wheels[i + 1][6]) rotate[i + 1] = -7;
            else if (wheels[i][2] != wheels[i + 1][6]) rotate[i + 1] = (rotate[i] == 1) ? -1 : 1;
        }
        for (int i = 0; i < 4; i++) {
            if (rotate[i] == 1) rotateClockwise(i);
            else if (rotate[i] == -1) rotateCounterClockwise(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            char[] tempArr = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = tempArr[j] - '0';
            }
        }
        K = Integer.parseInt(br.readLine());
//        nodeA = new Node(0, 2, 1, 6);
//        nodeB = new Node(1, 2, 2, 6);
//        nodeC = new Node(2, 2, 3, 6);
//        turnOrder = new Node[][]{{nodeA, nodeB, nodeC}, {nodeA, nodeB, nodeC}, {nodeB, nodeC, nodeA}, {nodeC, nodeB, nodeA}};

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            solution(num, dir);
        }
        //점수계산만하면됨!
        // N극은 0, S극은 1
        ////        1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
        ////        2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
        ////        3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
        ////        4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
        if (wheels[0][0] == 1) result += 1;
        if (wheels[1][0] == 1) result += 2;
        if (wheels[2][0] == 1) result += 4;
        if (wheels[3][0] == 1) result += 8;
        System.out.println(result);
    }
}