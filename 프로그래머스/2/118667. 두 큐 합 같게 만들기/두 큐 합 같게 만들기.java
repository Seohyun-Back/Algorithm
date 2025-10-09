import java.util.*;

class Solution {
    static long total=0;
    static int max = Integer.MIN_VALUE;
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    long a = 0;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int t = (queue1.length*3);
        for(int i=0; i<queue1.length; i++){
            total += queue1[i];
            a += queue1[i];
            max = Math.max(max, queue1[i]);
            q1.offer(queue1[i]);
            total += queue2[i];
            max = Math.max(max, queue2[i]);
            q2.offer(queue2[i]);
        }
        if(total%2 != 0 || max > total/2) return -1;
        long target = total/2;
        while(t>0){
            t--;
            if(a ==target) {
                return answer;
            }
            if(a<target){
                if(q2.isEmpty()) return -1;
                int temp = q2.poll();
                q1.offer(temp);
                a+=temp;
                answer++;
            }else{
                if(q1.isEmpty()) return -1;
                int temp = q1.poll();
                q2.offer(temp);
                a-=temp;
                answer++;
            }
        }  
        if(answer==0 || a != target) answer = -1;
        return answer;
    }
}