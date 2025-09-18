import java.util.Scanner;

public class contest2139A {
    public static void solve(int a,int b){
        if(a==b){
            System.out.println(0);
            return;
        }
        if(a%b==0 || b%a==0){
            System.out.println(1);
            return;
        }
        System.out.println(2);
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
