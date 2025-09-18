import java.util.Scanner;

public class contest2137A {
    public static void solve(int k,int x){
        for(int i=0;i<k;i++){
            x=2*x;
        }
        System.out.println(x);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        
        for(int i=0;i<n;i++){
            int k=in.nextInt();
            int x=in.nextInt();
            solve(k,x);
        }
    }
}
