//서버 증설 횟수

import java.util.*;
import java.io.*;

public class Solution {
    int[] players = new int[24];
    int m;
    int k;
    int answer = 0;

    public class Server {
        int s;
        int e;
        int n;

        public Server(int s, int e, int n) {
            this.s = s;
            this.e = e;
            this.n = n;
        }
    }

    public int solution(int[] players, int m, int k) {
        int time = 0;
        int totalServer = 0;
        Queue<Server> servers = new LinkedList<>();

        while (time < 24) {
            int needed = players[time] / m;
            if (totalServer < needed) {
                int temp = needed - totalServer;
                servers.offer(new Server(time, time + k - 1, temp));
                totalServer += temp;
                answer += temp;
            }
            //TODO: init servers, totalServer
            if (servers.size() != 0) {
                if (servers.peek().e == time) {
                    Server trash = servers.poll();
                    totalServer -= trash.n;
                }
            }
            time++;
        }
        return answer;
    }
}