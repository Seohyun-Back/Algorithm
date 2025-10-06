import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder answersb = new StringBuilder();
        String arr[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Set<Character> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) set.add(arr[i].charAt(0));
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(((int)s.charAt(i)>=48) && ((int)s.charAt(i)<=57)){
                answersb.append(s.charAt(i));
                continue;
            }
            for(int j=0; j<10; j++){
                if(i+arr[j].length()>s.length()) continue;
                if(arr[j].equals(s.substring(i, i+arr[j].length()))){
                    answersb.append(j);
                    i+= (arr[j].length()-1);
                }
            }
        }
        answer = Integer.parseInt(answersb.toString());
        return answer;
    }
}