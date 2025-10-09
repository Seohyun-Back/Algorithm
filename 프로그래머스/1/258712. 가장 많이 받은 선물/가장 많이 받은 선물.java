import java.util.*;

class Solution {
    static int friend = 0;
    static int[] giftIndex;
    static int[][] board;
    static int[] nextGift;
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        friend = friends.length;
        giftIndex = new int[friend+1];
        board = new int[friend+1][friend+1];
        nextGift = new int[friend+1];
        Arrays.fill(giftIndex, 0);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i + 1);
        }

        for(int i=0; i<board.length; i++) Arrays.fill(board[i], 0);
        Arrays.fill(nextGift, 0);
        for(int i=0; i<friends.length; i++){
            for(int j=0; j<gifts.length; j++){
                String[] arr = gifts[j].split(" ");
                int giver = map.get(arr[0]);
                int receiver = map.get(arr[1]);
                board[giver][receiver]++;
                giftIndex[giver]++;
                giftIndex[receiver]--;
            }
        }
        for(int i=1; i<=friend; i++){
            for(int j=1; j<=friend; j++){
                if(i==j) continue;
                if(board[i][j]>board[j][i]) nextGift[i]++;
                else if(board[i][j]==board[j][i]){
                    if(giftIndex[i]>giftIndex[j]) nextGift[i]++;
                }
            }
        }
        
        for(int i=1; i<nextGift.length; i++){
            answer = Math.max(answer, nextGift[i]);
        }
        return answer;
    }
}