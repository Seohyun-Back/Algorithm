import java.util.*;

class Solution {
    static Queue<String> cache;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        cache = new LinkedList<String>();
        for(int i=0; i<cities.length; i++){
            if(cacheSize == 0 || !cache.contains(cities[i].toLowerCase())){
                if(cache.size() >= cacheSize) {
                    cache.poll();
                }
                cache.offer(cities[i].toLowerCase());
                answer += 5;
            }else if(cache.contains(cities[i].toLowerCase())){
                cache.remove(cities[i].toLowerCase());
                cache.offer(cities[i].toLowerCase());
                answer += 1;
            }
        }
        return answer;
    }
}