import java.util.Scanner;

public class contest2148A {
    public static void solve(int x , int n){
        if(n%2==0){ System.out.println(0);return;}
        System.out.println(x);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            solve(a,b);
        }
    }
}
