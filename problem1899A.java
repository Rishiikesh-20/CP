import java.util.*;
public class problem1899A {
    public static void solve(int n){
        if((n-1)%3==0 || (n+1)%3==0){
            System.out.println("First");
            return;
        }
        System.out.println("Second");
        return;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int num=in.nextInt();
            solve(num);
        }
    }
}
