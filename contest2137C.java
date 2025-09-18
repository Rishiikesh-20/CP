import java.util.Scanner;


// should upsolve
public class contest2137C {
    public static void solve(int a,int b){
        // odd odd
        if((a&b&1)==1){
            System.out.println(a*b+1);
            return;
        }
        if((b&1)==1){
            System.out.println("-1");
            return;
        }
        if(a%2==0 && b%2==0){
            if((b/2)%2==0){
                System.out.println(a*b/2 + 2);
                return;
            }
            System.out.println("-1");
            return;
        }
        if((b/2)%2==0){
            System.out.println(a*b/2+2);
            return;
        }
        System.out.println("-1");
        return;
        
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
