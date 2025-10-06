import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder(n + " is ");
        if(n%2==0){
            sb.append("even");
        }else{
            sb.append("odd");
        }
        System.out.println(sb.toString());
    }
}