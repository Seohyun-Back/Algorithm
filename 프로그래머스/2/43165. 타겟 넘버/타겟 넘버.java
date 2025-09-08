class Solution {
    static int[] numbers;
    static int target;
    static int answer;
    
    public void dfs(int idx, int sum){
        if(idx == numbers.length){
            if(sum==target) answer++;
            return;
        }
        dfs(idx+1, sum+numbers[idx]);
        dfs(idx+1, sum-numbers[idx]);
        
        return;
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        answer = 0;
        dfs(0, 0);
        
        return answer;
    }
}